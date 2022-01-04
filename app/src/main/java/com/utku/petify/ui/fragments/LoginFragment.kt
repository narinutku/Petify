package com.utku.petify.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.utku.petify.R
import com.utku.petify.ui.activities.MenuActivity
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.Login
import com.utku.petify.ui.model.User
import kotlinx.android.synthetic.main.fragment_login.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
btn_sign_up.setOnClickListener {
    replaceFragment(SignUpFragment())
}
        btn_login.setOnClickListener {
            val postService = ApiClient.getClient().create(PostService::class.java)
           // val login= Login(edittext_mail_login.text.toString(),editTextTextPassword.text.toString());
            val login= Login("utku@hotmail.com","484656ck");
            val post = postService.login(login)
            post.enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {

                    if (response.isSuccessful) {
                        val prefences = activity!!.getSharedPreferences("USER", Context.MODE_PRIVATE)
                        val editor = prefences.edit()
                        editor.putString("User",response.body().username)

                        editor.apply()
                        val intent= Intent(context, MenuActivity::class.java)
                        startActivity(intent)
                    }
                }
            })


        }

    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction= requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container_main,fragment)
            transaction.commit()

        }
    }

}