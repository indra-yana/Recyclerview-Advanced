package com.indrayana.rvadvanced.adapter.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_1.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 11.03
 ****************************************************/
class CardType1ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_type_1,
            parent,
            false
        )
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_1.text = cardItem.title
        itemView.tv_item_description_1.text = cardItem.description
        itemView.iv_item_banner_1.setImageResource(cardItem.imageResource)
        itemView.overflow_menu.setOnClickListener {
            showPopupMenu(itemView.overflow_menu, cardItem.title)
        }

        itemView.item_card_view_1.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_1.setOnLongClickListener {
            onItemClickListener?.onItemLongClick(it, bindingAdapterPosition)
            return@setOnLongClickListener true
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private fun showPopupMenu(view: View, tag: String?) {
        // inflate menu
        PopupMenu(view.context, view).apply {
            menuInflater.inflate(R.menu.overflow_menu, menu)
            setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_add_favourite -> {
                        Toast.makeText(view.context, "$tag added to favourite", Toast.LENGTH_SHORT).show()
                        return@OnMenuItemClickListener true
                    }
                    R.id.action_delete -> {
                        Toast.makeText(view.context, "$tag deleted", Toast.LENGTH_SHORT).show()
                        return@OnMenuItemClickListener true
                    }
                }
                return@OnMenuItemClickListener false
            })
            show()
        }
    }

}