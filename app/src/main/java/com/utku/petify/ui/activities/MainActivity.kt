package com.utku.petify.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.utku.petify.R
import com.utku.petify.ui.fragments.SignUpDialogFragment
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btn_sign_up.setOnClickListener { var dialog= SignUpDialogFragment()
    dialog.show(supportFragmentManager,"signUpDialog") }
 btn_login.setOnClickListener {
     val postService = ApiClient.getClient().create(PostService::class.java)
     val post = postService.login("test@gmail.com","484656ck")
     post.enqueue(object : Callback<List<User>> {
         override fun onFailure(call: Call<List<User>>, t: Throwable) {
             Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
         }

         override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

             if (response.isSuccessful) {
               val intent=Intent(applicationContext,MenuActivity::class.java)
                 startActivity(intent)
             }
         }
     })
 }
    }

}