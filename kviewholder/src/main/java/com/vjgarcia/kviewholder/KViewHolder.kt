package com.vjgarcia.kviewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class KViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindTo(item: T)
}
