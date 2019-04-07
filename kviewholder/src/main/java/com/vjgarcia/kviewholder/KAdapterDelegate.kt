package com.vjgarcia.kviewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.full.primaryConstructor

internal class KAdapterDelegate<T : Any, VH : RecyclerView.ViewHolder>(
    private val bindings: Array<ItemViewTypeBinding<T, VH>>
) {

    fun getItemViewType(item: T): Int {
        val type = bindings.indexOfFirst { binding ->
            binding.itemClass.isInstance(item)
        }

        if (type == INVALID_BINDING_TYPE) {
            throw IllegalArgumentException("You must provide a binding for ${item::class.java.name}")
        }

        return type
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = bindings[viewType]
        val primaryConstructor = binding.viewHolderClass.primaryConstructor
        val view = LayoutInflater.from(parent.context).inflate(binding.layoutId, parent, false)

        if (primaryConstructor == null
            || primaryConstructor.parameters.size != 1
            || primaryConstructor.parameters[0].type.javaClass.isInstance(view)
        ) {
            throw IllegalArgumentException("You must provide a primary constructor with a parameter of type View for your ViewHolder")
        }

        return primaryConstructor.call(view)
    }

    private companion object {
        const val INVALID_BINDING_TYPE = -1
    }
}