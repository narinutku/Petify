package com.utku.petify.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.utku.petify.R
import com.utku.petify.ui.activities.MenuActivity
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.User
import kotlinx.android.synthetic.main.fragment_add_post.*
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.*
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.sign_up_dialog_fragment, container, false)
        rootView.btn_sign_up_cancel.setOnClickListener { dismiss() }
        rootView.btn_sign_up_in_fragment.setOnClickListener {

            val postService = ApiClient.getClient().create(PostService::class.java)
            val post = postService.register(
                edit_text_name.text.toString(),
                edit_text_surname.text.toString(),
                txt_date_of_birth.text.toString(),
                edittextPhone.text.toString(),
                edit_text_mail_sign_up.text.toString(),
                "e",
                edit_text_password_sign_up.text.toString()
            )
            post.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    if (t != null) {
                        Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    if (response != null) {
                        if (response.isSuccessful) {
                            val intent = Intent(context, MenuActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            })


        }

        return rootView

    }
}