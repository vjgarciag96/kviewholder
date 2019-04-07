package com.vjgarcia.kviewholder

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class KAdapter<T : Any, VH : KViewHolder<T>>(
    itemViewTypeBindings: Array<ItemViewTypeBinding<T, VH>>,
    itemDiffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(itemDiffCallback) {

    private val adapterDelegate: KAdapterDelegate<T, VH> = KAdapterDelegate(itemViewTypeBindings)

    override fun getItemViewType(position: Int): Int = adapterDelegate.getItemViewType(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        adapterDelegate.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindTo(getItem(position))
    }
}