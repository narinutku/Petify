package com.utku.petify.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.utku.petify.R
import com.utku.petify.ui.fragments.MainMenuFragment
import com.utku.petify.ui.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    private val mainMenuFragment=MainMenuFragment()
    private val messagesFragment=com.utku.petify.ui.fragments.MessagesFragment()
    private val profileFragment=com.utku.petify.ui.fragments.ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        replaceFragment(mainMenuFragment)
    bottom_navigation.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.icon_main_page -> {
                // Respond to navigation item 1 click
                replaceFragment(mainMenuFragment)
                true
            }
            R.id.icon_message -> {
                // Respond to navigation item 2 click
                replaceFragment(messagesFragment)
                true
            }
            R.id.icon_person -> {
                // Respond to navigation item 2 click
                replaceFragment(profileFragment)
                true
            }
        }
        true
    }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container,fragment)
            transaction.commit()

        }
    }
}