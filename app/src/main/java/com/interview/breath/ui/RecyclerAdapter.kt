package com.interview.breath.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.interview.breath.R


class RecyclerAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.image_gridelayout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
        Glide.with(context)
            .load(
                "data:image/jpeg;base64,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"
            )
            .apply(requestOptions)
            .skipMemoryCache(true)//for caching the image url in case phone is offline
            .into(viewHolder.img_android)

    }

    override fun getItemCount(): Int {
        return 1000
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img_android: ImageView

        init {
            img_android =
                view.findViewById<View>(R.id.iv_glide) as ImageView
        }
    }

}