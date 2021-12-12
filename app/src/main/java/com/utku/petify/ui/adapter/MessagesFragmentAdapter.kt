package com.utku.petify.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MessagesFragmentAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
private val fragmentList: MutableList<Fragment> = ArrayList()
private val titleList: MutableList<String> = ArrayList()


        override fun getCount(): Int {
        return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
        return fragmentList[position]
        }
        //Bu fonksiyon ile Fragment'leri ve title'ları ekliyoruz
        fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
        }
        //Title'ların pozisyonunu veriyoruz
        override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
        }
        }