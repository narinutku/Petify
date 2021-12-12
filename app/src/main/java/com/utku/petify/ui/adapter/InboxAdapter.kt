package com.utku.petify.ui.adapter

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utku.petify.R
import kotlinx.android.synthetic.main.row_list_for_messages.view.*
import kotlinx.android.synthetic.main.row_list_for_post.view.*
import kotlinx.android.synthetic.main.row_list_for_post.view.txt_title

class InboxAdapter(postList: ArrayList<String>) :
    RecyclerView.Adapter<InboxAdapter.ContextHolder>() {
    val messageList: MutableList<String> = postList

    class ContextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContextHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_list_for_messages, parent, false)



        return ContextHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContextHolder,
        position: Int
    ) {
        holder.itemView.txt_title.text=messageList[position]
        holder.itemView.setOnClickListener {
            TransitionManager.beginDelayedTransition(holder.itemView.cardview_message);
            holder.itemView.txt_message_content.setVisibility(View.VISIBLE);
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}