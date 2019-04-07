package com.vjgarcia.kviewholdersample

import androidx.recyclerview.widget.DiffUtil

class RowDiffCallback() : DiffUtil.ItemCallback<Row>() {
    override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean =
        oldItem == newItem
}