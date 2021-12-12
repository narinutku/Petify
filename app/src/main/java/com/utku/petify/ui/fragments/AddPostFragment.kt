package com.utku.petify.ui.fragments

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.utku.petify.R
import kotlinx.android.synthetic.main.fragment_add_post.*
import java.util.jar.Manifest


class AddPostFragment : Fragment() {

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

    }

    private fun permissionControl(){
        if(ContextCompat.checkSelfPermission(requireView().context,android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
            openGallery()
        }
        else{
            activity?.let { ActivityCompat.requestPermissions(it, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1) }
        }

    }
    private val requestPermission=registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if(it){
            openGallery()
        }
    }
    var launchSomeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val uri:Uri?=data?.data
            image_add_photo.setImageURI(uri)
        }
    }

    private fun openGallery() {
      val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        launchSomeActivity.launch(intent)
    }

}