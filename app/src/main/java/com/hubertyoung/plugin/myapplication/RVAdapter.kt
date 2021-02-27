package com.hubertyoung.plugin.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_video.view.*

/**
 * <br>
 * function:
 * <p>
 * @author:HubertYoung
 * @date:2/27/21 4:28 PM
 * @since:V
 * @desc:com.hubertyoung.plugin.myapplication
 */
class RVAdapter(
    val mContext: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: MutableList<ItemEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> VideoViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false)
            )
            else -> TextViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return data?.let {
            if (it[position].type == "video") 1 else 0
        } ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bean = data?.get(position)
        if (holder is TextViewHolder) {
            holder.itemView.textView.text = bean?.content
        } else if (holder is VideoViewHolder) {

            holder.itemView.videoView.setMediaController(holder.localMediaController)
            holder.itemView.videoView.setVideoPath(bean?.content)
            holder.itemView.videoView.start()
        }
    }

    fun setData(list: MutableList<ItemEntity>) {
        this.data = list
    }

    inner class TextViewHolder(view: View) : RecyclerView.ViewHolder(view)

    inner class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val localMediaController: MediaController = MediaController(mContext)
    }
}