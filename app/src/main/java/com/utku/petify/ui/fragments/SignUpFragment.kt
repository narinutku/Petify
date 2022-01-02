package com.utku.petify.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.utku.petify.R
import com.utku.petify.ui.activities.MenuActivity
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.ApiClient
import com.utku.petify.ui.model.SignUpRequest
import com.utku.petify.ui.model.SignUpResponse
import kotlinx.android.synthetic.main.fragment_add_post.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.*
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.edit_text_mail_sign_up
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.edit_text_name
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.edit_text_password_sign_up
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.edit_text_surname
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.txt_date_of_birth
import kotlinx.android.synthetic.main.sign_up_dialog_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_sign_up, container, false)
        rootView.btn_sign_up_cancel.setOnClickListener {
            replaceFragment(LoginFragment())

        }
        rootView.btn_sign_up_in_fragment.setOnClickListener {

            val postService = ApiClient.getClient().create(PostService::class.java)
            val post = postService.register(
                SignUpRequest(
                    edit_text_adress_sign_up.text.toString(),
                    txt_date_of_birth.text.toString(),
                    edit_text_mail_sign_up.text.toString(),
                    edit_text_name.text.toString(),
                    "e",
                    edit_text_surname.text.toString(),
                    edit_text_password_sign_up.text.toString(),
                    edit_text_phone_sign_up.text.toString()
                )


            )
            post.enqueue(object : Callback<SignUpResponse> {
                override fun onFailure(call: Call<SignUpResponse>?, t: Throwable?) {
                    if (t != null) {
                        Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(
                    call: Call<SignUpResponse>?,
                    response: Response<SignUpResponse>?
                ) {
                    if (response != null) {
                        if (response.isSuccessful) {
                            val prefences =
                                activity!!.getSharedPreferences("USER", Context.MODE_PRIVATE)
                            val editor = prefences.edit()
                            editor.putString("User", edit_text_mail_sign_up.text.toString())

                            editor.apply()
                            val intent = Intent(context, MenuActivity::class.java)
                            startActivity(intent)
//                            showdialog()
                        }
                    }
                }
            })


        }

        return rootView


    }

    fun showdialog() {
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(activity)
        builder.setTitle("Title")

// Set up the input
        val input = EditText(activity)
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setHint("Please Enter your verification code which sent your e mail")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

// Set up the buttons
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            // Here you get get input text from the Edittext
            val postService = ApiClient.getClient().create(PostService::class.java)

            var m_Text = input.text.toString()
            val post = postService.accountVerify(m_Text)
            post.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    if (t != null) {
                        Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    if (response != null) {
                        if (response.isSuccessful) {
                            val prefences =
                                activity!!.getSharedPreferences("USER", Context.MODE_PRIVATE)
                            val editor = prefences.edit()
                            editor.putString("User", edit_text_mail_sign_up.text.toString())

                            editor.apply()
                            val intent = Intent(context, MenuActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            })
        })
        builder.setNegativeButton(
            "Cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container_main, fragment)
        transaction.commit()

    }


}