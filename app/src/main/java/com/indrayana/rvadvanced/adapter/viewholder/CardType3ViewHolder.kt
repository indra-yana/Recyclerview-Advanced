package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_3.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 11.08
 ****************************************************/
class CardType3ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_type_3,
            parent,
            false
        )
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_3.text = cardItem.title
        itemView.tv_item_description_3.text = cardItem.description

        itemView.btn_item_3.setOnClickListener {
            onItemClickListener?.onButtonItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_3.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.item_card_view_3.setOnLongClickListener {
            onItemClickListener?.onItemLongClick(it, bindingAdapterPosition)
            return@setOnLongClickListener true
        }
    }

}