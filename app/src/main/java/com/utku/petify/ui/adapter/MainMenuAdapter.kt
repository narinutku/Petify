package com.utku.petify.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utku.petify.R
import com.utku.petify.ui.model.AdvertResponse
import kotlinx.android.synthetic.main.row_list_for_post.view.*

class MainMenuAdapter(postList: MutableList<AdvertResponse>) :
    RecyclerView.Adapter<MainMenuAdapter.ContextHolder>() {
    val postList: MutableList<AdvertResponse> = postList

    class ContextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContextHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_list_for_post, parent, false)



        return ContextHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContextHolder,
        position: Int
    ) {
// holder.itemView.txt_title.text=postList[position]
        holder.itemView.txt_title.text=postList[position].title
        holder.itemView.txt_content.text=postList[position].description
        holder.itemView.txt_creationTime.text=postList[position].creationTime
        holder.itemView.txt_family.text=postList[position].petFamily
        holder.itemView.txt_gender.text=postList[position].petGender
        holder.itemView.txt_username_for_list.text=postList[position].advertiserName

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}