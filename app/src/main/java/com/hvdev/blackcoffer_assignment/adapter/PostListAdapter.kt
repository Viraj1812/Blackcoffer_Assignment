package com.hvdev.blackcoffer_assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hvdev.blackcoffer_assignment.R
import com.hvdev.blackcoffer_assignment.databinding.RowCaptionListBinding
import com.hvdev.blackcoffer_assignment.model.PostData

class PostListAdapter(
    val context: Context,
    private val captionList: ArrayList<PostData>,
    private val glide: RequestManager = Glide.with(context)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_caption_list, parent, false)
        return CaptionListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CaptionListViewHolder) {
            val subCatDataModel: PostData = captionList[position]

            holder.binding.name.text = subCatDataModel.name
            holder.binding.tvLc.text = subCatDataModel.location
            holder.binding.interest.text = subCatDataModel.interest
            holder.binding.statusLine.text = subCatDataModel.status
            glide.load(subCatDataModel.image).into(holder.binding.profile)

        }
    }

    override fun getItemCount(): Int {
        return captionList.size
    }

    class CaptionListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RowCaptionListBinding.bind(itemView)
    }
}
