package com.indrayana.rvadvanced.adapter.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.CardAdapter
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CategoryItem
import kotlinx.android.synthetic.main.item_rv_category.view.*


/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 12/04/2020 16.50
 ****************************************************/
class CardTypeCategoryViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_rv_category, parent, false)
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val categoryItem = item as CategoryItem

        itemView.tv_item_category_name.text = categoryItem.title
        itemView.btn_item_more.setOnClickListener {
            onItemClickListener?.onButtonItemClick(it, bindingAdapterPosition)
        }

        setupNestedList(itemView.context, itemView.rv_sub_item, categoryItem)
    }

    private fun setupNestedList(
        context: Context,
        recyclerView: RecyclerView,
        categoryItem: CategoryItem
    ) {
        val itemList = categoryItem.cardItem
        val itemAdapter = CardAdapter(itemList, categoryItem.viewType).apply {
            onItemClickListener = object : OnItemClickListenerImpl() {
                override fun onItemClick(view: View?, position: Int) {
                    super.onItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onItemLongClick(view: View?, position: Int) {
                    super.onItemLongClick(view, position)
                    Toast.makeText(
                        context,
                        "Long click item: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onButtonItemClick(view: View?, position: Int) {
                    super.onButtonItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Button item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onButtonNotificationItemClick(view: View?, position: Int) {
                    super.onButtonNotificationItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Button notification item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onButtonShareItemClick(view: View?, position: Int) {
                    super.onButtonShareItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Button share item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            itemViewSize = categoryItem.itemViewSize
        }

        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

}