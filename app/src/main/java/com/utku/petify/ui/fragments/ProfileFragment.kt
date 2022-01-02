package com.utku.petify.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.utku.petify.R
import com.utku.petify.ui.adapter.MainMenuAdapter
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.User
import com.utku.petify.ui.model.UserProfile
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
var username=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postService = ApiClient.getClient().create(PostService::class.java)
        val post = postService.getProfile()
        val prefences = requireActivity().getSharedPreferences("USER", Context.MODE_PRIVATE)
        username = prefences.getString("User","").toString()
        post.enqueue(object : Callback<List<UserProfile>> {


            override fun onFailure(call: Call<List<UserProfile>>?, t: Throwable?) {
                if (t != null) {
                    Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onResponse(call: Call<List<UserProfile>>?, response: Response<List<UserProfile>>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        var List: List<UserProfile> = response.body().filter { s -> s.eMail==username }
                    txt_mail_profile.text="E mail: "+List[0].eMail
                        txt_phone_profile.text="Phone Number: "+ List[0].phoneNumber
                        txt_username_profile.text=List[0].firstName+" "+List[0].lastName
                    }
                }
            }
        })
//        recycler_profile_advert.apply {
//            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
//            adapter = MainMenuAdapter(arrayListOf("1.ilan", "2.ilan", "3.ilan"))
//        }
    }

}