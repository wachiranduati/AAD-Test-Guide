package com.nduati.aadtestguide.paginglibrary.paging

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.nduati.aadtestguide.R


class ItemAdapter : PagedListAdapter<Item, ItemAdapter.ItemViewHolder>(REPO_COMPARATOR) {
    lateinit var mCtx : Context

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val imageView : ImageView = v.findViewById(R.id.imageView);
        val textView : TextView = v.findViewById(R.id.textViewName);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        mCtx = parent.context
        val view : View = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item,
            parent,
            false
        )
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            Glide.with(mCtx)
                .load(item.owner!!.profile_image)
                .into(holder.imageView)
            holder.textView.text = item.owner!!.display_name
        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show()
        }
    }

    companion object{
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.answer_id == newItem.answer_id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}