package com.utku.petify.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.utku.petify.R
import com.utku.petify.ui.adapter.MainMenuAdapter
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.User
import kotlinx.android.synthetic.main.fragment_main_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MainMenuFragment : Fragment() {

//    lateinit var postService: PostService
    var postList: MutableList<User>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postService = ApiClient.getClient().create(PostService::class.java)
        val post = postService.login("test@gmail.com","484656ck")
        post.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                if (response.isSuccessful) {
                  postList = (response.body() as MutableList<User>?)!!
                    createList(postList!!)
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        recycler_main_menu.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter = MainMenuAdapter(arrayListOf("1.ilan", "2.ilan", "3.ilan"))
//        }
        image_button_add_post.setOnClickListener {
            val fragmentAddPostFragment = AddPostFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, fragmentAddPostFragment)
            fragmentTransaction.commit()
        }
    }
    fun createList(list: MutableList<User>){
        recycler_main_menu.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MainMenuAdapter(arrayListOf(list[0].id_.toString(), list[0].userId.toString(), list[1].id_.toString(), list[1].userId.toString()))
        }
    }



}