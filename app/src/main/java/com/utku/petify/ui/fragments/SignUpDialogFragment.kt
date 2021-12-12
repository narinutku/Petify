package com.utku.petify.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.utku.petify.R
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.view.*

class SignUpDialogFragment:DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View=inflater.inflate(R.layout.sign_up_dialog_fragment,container,false)
        rootView.btn_sign_up_cancel.setOnClickListener { dismiss() }
        rootView.btn_sign_up_in_fragment.setOnClickListener {  }
        return rootView

    }



}