package com.utku.petify.ui.fragments

import android.os.Bundle
import android.provider.Telephony
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.utku.petify.R
import com.utku.petify.ui.adapter.MessagesFragmentAdapter
import kotlinx.android.synthetic.main.fragment_messages.*
import kotlinx.android.synthetic.main.fragment_messages.view.*


class MessagesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_messages, container, false)
        addFragment(view)
        return view
    }

    private fun addFragment(view: View) {
        val adapter=MessagesFragmentAdapter(childFragmentManager)

        adapter.addFragment(InboxFragment(), "Gelen Kutusu")
        adapter.addFragment(NotificationFragment(), "Bildirimler")
//        val viewPagers=view.findViewById<ViewPager>(R.id.viewPager)
//        val tabLayouts=view.findViewById<TabLayout>(R.id.tabLayout)


        //Adapter'ımızdaki verileri viewPager adapter'a veriyoruz
       view.viewPager.adapter=adapter
        //Tablar arasında yani viewPager'lar arasında geçisi sağlıyoruz
     view.tabLayout.setupWithViewPager(view.viewPager)

    }


}