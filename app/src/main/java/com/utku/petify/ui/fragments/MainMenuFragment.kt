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
import com.utku.petify.ui.model.AdvertResponse
import com.utku.petify.ui.model.ApiClient
import kotlinx.android.synthetic.main.fragment_main_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MainMenuFragment : Fragment() {

//    lateinit var postService: PostService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val postService = ApiClient.getClient().create(PostService::class.java)
        val post=postService.getAdverties()
        post.enqueue(object : Callback<MutableList<AdvertResponse>>{
            override fun onResponse(
                call: Call<MutableList<AdvertResponse>?>?,
                response: Response<MutableList<AdvertResponse>?>?
            ) {
                if (response != null) {
                    response.body()?.let { showAdverties(it) }
                };

            }

            override fun onFailure(call: Call<MutableList<AdvertResponse>?>?, t: Throwable?) {
                if (t != null) {
                    Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                }
            }


        })
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        image_button_add_post.setOnClickListener {
            val fragmentAddPostFragment = AddPostFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, fragmentAddPostFragment)
            fragmentTransaction.commit()
        }
    }

    private fun showAdverties(mutableList: MutableList<AdvertResponse>) {
        recycler_main_menu.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MainMenuAdapter(mutableList)
        }
    }






}