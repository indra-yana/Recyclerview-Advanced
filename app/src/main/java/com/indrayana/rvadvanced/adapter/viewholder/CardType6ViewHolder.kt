package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_6.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 10.49
 ****************************************************/
class CardType6ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_type_6,
            parent,
            false
        )
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_6.text = cardItem.title
        itemView.iv_item_banner_6.setImageResource(cardItem.imageResource)

        itemView.item_card_view_6.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_6.setOnLongClickListener {
            onItemClickListener?.onItemLongClick(it, bindingAdapterPosition)
            return@setOnLongClickListener true
        }
    }

}