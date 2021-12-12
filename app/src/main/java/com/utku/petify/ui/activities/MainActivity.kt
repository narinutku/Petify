package com.utku.petify.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utku.petify.R
import com.utku.petify.ui.fragments.SignUpDialogFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btn_sign_up.setOnClickListener { var dialog= SignUpDialogFragment()
    dialog.show(supportFragmentManager,"signUpDialog") }

    }
}