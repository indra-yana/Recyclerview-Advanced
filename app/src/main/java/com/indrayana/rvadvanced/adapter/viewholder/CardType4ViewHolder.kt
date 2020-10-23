package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_4.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 11.10
 ****************************************************/
class CardType4ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_type_4,
            parent,
            false
        )
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_4.text = cardItem.title
        itemView.tv_item_description_4.text = cardItem.description

        itemView.btn_item_4.setOnClickListener {
            onItemClickListener?.onButtonItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_4.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_4.setOnLongClickListener {
            onItemClickListener?.onItemLongClick(it, bindingAdapterPosition)
            return@setOnLongClickListener true
        }
    }

}