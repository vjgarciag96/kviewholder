package com.vjgarcia.kviewholdersample

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.vjgarcia.kviewholder.KViewHolder
import com.vjgarcia.kviewholder.itemViewTypeBinding

// Text row
fun textRow() = itemViewTypeBinding<Row, KViewHolder<Row>>(
    itemType = Row.Text::class,
    viewHolder = TextViewHolder::class,
    layoutId = R.layout.text_row
)

class TextViewHolder(itemView: View) : KViewHolder<Row.Text>(itemView) {
    override fun bindTo(item: Row.Text) {
        val title = itemView.findViewById<TextView>(R.id.title)
        title.text = item.title
    }
}

// Text with image row
fun textWithImageRow() = itemViewTypeBinding<Row, KViewHolder<Row>>(
    itemType = Row.TextWithImage::class,
    viewHolder = TextWithImageView::class,
    layoutId = R.layout.text_with_image_row
)

class TextWithImageView(itemView: View) : KViewHolder<Row.TextWithImage>(itemView) {
    override fun bindTo(item: Row.TextWithImage) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        title.text = item.title
        avatar.setImageResource(item.image)
    }
}
