package com.vjgarcia.kviewholder

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : Any, VH : RecyclerView.ViewHolder> itemViewTypeBinding(
    itemType: KClass<*>,
    viewHolder: KClass<*>,
    @LayoutRes layoutId: Int
): ItemViewTypeBinding<T, VH> = ItemViewTypeBinding(
    itemType as KClass<T>,
    viewHolder as KClass<VH>,
    layoutId
)

class ItemViewTypeBinding<T : Any, VH : RecyclerView.ViewHolder> internal constructor(
    val itemClass: KClass<out T>,
    val viewHolderClass: KClass<out VH>,
    @LayoutRes val layoutId: Int
)