package com.vjgarcia.kviewholdersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vjgarcia.kviewholder.KAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var items: RecyclerView
    private val itemsAdapter = KAdapter(
        itemViewTypeBindings = arrayOf(textRow(), textWithImageRow()),
        itemDiffCallback = RowDiffCallback()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpItemsRecyclerView()
    }

    private fun setUpItemsRecyclerView() {
        items = findViewById(R.id.items)
        items.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemsAdapter
        }

        itemsAdapter.submitList(
            listOf(
                Row.Text(id = "1", title = "Hello World!!!"),
                Row.TextWithImage(id = "2", title = "Rukaaaaaa!", image = R.drawable.abc_ic_star_black_48dp)
            )
        )
    }
}
