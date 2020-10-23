package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_7.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 13/04/2020 19.01
 ****************************************************/
class CardType7ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_card_type_7, parent, false)
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_7.text = cardItem.title
        itemView.tv_item_caption_7.text = cardItem.title
        itemView.tv_item_description_7.text = cardItem.description
        itemView.iv_item_banner_7.setImageResource(cardItem.imageResource)

        itemView.item_card_view_7.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.btn_item_share_7.setOnClickListener {
            onItemClickListener?.onButtonShareItemClick(it, bindingAdapterPosition)
        }

        itemView.btn_item_notification_7.setOnClickListener {
            onItemClickListener?.onButtonNotificationItemClick(it, bindingAdapterPosition)
        }
    }
}