package com.interview.breath.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interview.breath.R


class RecyclerPeresetAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerPeresetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.persent_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img_android: TextView

        init {
            img_android =
                view.findViewById<View>(R.id.viewPeresent) as TextView
        }
    }

}
