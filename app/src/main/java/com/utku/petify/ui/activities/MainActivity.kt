package com.utku.petify.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.utku.petify.R
import com.utku.petify.ui.fragments.LoginFragment


class MainActivity : AppCompatActivity() {

    private val loginFragment= LoginFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(loginFragment)

        setContentView(R.layout.activity_main)

    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container_main,fragment)
            transaction.commit()

        }
    }
}