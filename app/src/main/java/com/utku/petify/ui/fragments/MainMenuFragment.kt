package com.utku.petify.ui.fragments

import android.R.attr.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.utku.petify.R
import com.utku.petify.ui.adapter.MainMenuAdapter
import kotlinx.android.synthetic.main.fragment_main_menu.*


class MainMenuFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        recycler_main_menu.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MainMenuAdapter(arrayListOf("1.ilan", "2.ilan", "3.ilan"))
        }
        image_button_add_post.setOnClickListener {
            val fragmentAddPostFragment = AddPostFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, fragmentAddPostFragment)
            fragmentTransaction.commit()
        }
    }


}