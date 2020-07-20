package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Post
import kotlinx.android.synthetic.main.list_item_recycler_view.view.*

class PostsAdapter(
    private val dataList: List<Post>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_recycler_view, parent, false
        )
        return PostsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentItem = dataList[position]

        holder.id.text = "ID: ${currentItem.id}"
        holder.userId.text = "User ID: ${currentItem.userId}"
        holder.title.text = "Title: ${currentItem.title}"
        holder.text.text = "Text: ${currentItem.text}"

    }

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val id: TextView = itemView.post_id
        val userId: TextView = itemView.post_userId
        val title: TextView = itemView.post_title
        val text: TextView = itemView.post_text

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                onItemClickListener.onItemClick(dataList[position].id)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(postId: Int)
    }
}