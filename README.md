# kviewholder
Creating a recycler view adapter with multiple row types requires a lot of boilerplate code that we could easily avoid. That's the purpose of this library

## How to create a multiple rows recycler view adapter with this library?

Suppose we have the next view model:

```
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
```

And we have defined an xml called *text_row.xml* to represent the _Text_ model row view:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:gravity="center">
    <TextView
            android:id="@+id/title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:textColor="@android:color/black"
            android:textStyle="bold"
            android:textSize="18sp"
            tools:text="Any ruka title!!"/>
</LinearLayout>
```

Let's create the view holder for _Text_ model:

```
class TextViewHolder(itemView: View) : KViewHolder<Row.Text>(itemView) {
    override fun bindTo(item: Row.Text) {
        val title = itemView.findViewById<TextView>(R.id.title)
        title.text = item.title
    }
}
```

The only code we will have to write to bind the ViewHolder to the model is the next:
```
fun textRow() = itemViewTypeBinding<Row, KViewHolder<Row>>(
    itemType = Row.Text::class,
    viewHolder = TextViewHolder::class,
    layoutId = R.layout.text_row
)
```

And finally we need to define the adapter in the next way:
```
private val itemsAdapter = KAdapter(
        itemViewTypeBindings = arrayOf(textRow(), textWithImageRow()),
        itemDiffCallback = RowDiffCallback()
    )
```
