package com.utku.petify.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utku.petify.R
import com.utku.petify.ui.adapter.MainMenuAdapter.ContextHolder
import kotlinx.android.synthetic.main.row_list_for_post.view.*

class MainMenuAdapter(postList: ArrayList<String>) :
    RecyclerView.Adapter<MainMenuAdapter.ContextHolder>() {
    val postList: MutableList<String> = postList

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
holder.itemView.txt_title.text=postList[position]

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}