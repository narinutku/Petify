package com.utku.petify.ui.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.utku.petify.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.utku.petify.ui.helper.PostService
import com.utku.petify.ui.model.AdvertRequest
import com.utku.petify.ui.model.AdvertResponse
import com.utku.petify.ui.model.ApiClient
import kotlinx.android.synthetic.main.fragment_add_post.*


class AddPostFragment : Fragment() {
    var radioGroupGender: RadioGroup? = null
    lateinit var radioButtonGender: RadioButton
    var radioGroupGenus: RadioGroup? = null
    lateinit var radioButtonGenus: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_add_photo.setOnClickListener {
            permissionControl()
            requestPermission
        }
        btn_add_post.setOnClickListener {
            radioGroupGender = view.findViewById(R.id.radioGroupgender)
            radioGroupGenus=view.findViewById(R.id.radioGroupGenus)
            val selectedOptionGender: Int = radioGroupGender!!.checkedRadioButtonId
            radioButtonGender = view.findViewById(selectedOptionGender)
            val selectedOptionGenus: Int = radioGroupGenus!!.checkedRadioButtonId
            radioButtonGenus = view.findViewById(selectedOptionGenus)
            val postService = ApiClient.getClient().create(PostService::class.java)
            val post = postService.addAdverties(
                AdvertRequest(
                    edittextDesc.text.toString(),
                    "",
                    "",
                    radioButtonGender.text.toString(),
                    radioButtonGenus.text.toString(),
                    "",
                    edittextTitle.text.toString(),
                    ""
                )
            )
post.enqueue(object :Callback<AdvertResponse>{

    override fun onResponse(call: Call<AdvertResponse>?, response: Response<AdvertResponse>?) {
        Toast.makeText(context,"Your Post Added Succeesfully", Toast.LENGTH_LONG).show()

    }

    override fun onFailure(call: Call<AdvertResponse>?, t: Throwable?) {
        if (t != null) {
            Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG).show()
        }
    }

})
        }

    }

    private fun permissionControl() {
        if (ContextCompat.checkSelfPermission(
                requireView().context,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openGallery()
        } else {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            }
        }

    }

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                openGallery()
            }
        }
    var launchSomeActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val uri: Uri? = data?.data
                image_add_photo.setImageURI(uri)
            }
        }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        launchSomeActivity.launch(intent)
    }

}