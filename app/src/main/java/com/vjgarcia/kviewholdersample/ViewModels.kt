package com.vjgarcia.kviewholdersample

import androidx.annotation.DrawableRes

sealed class Row {
    abstract val id: String
    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int

    data class Text(
        override val id: String,
        val title: String
    ) : Row()

    data class TextWithImage(
        override val id: String,
        val title: String,
        @DrawableRes val image: Int
    ) : Row()
}