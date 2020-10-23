package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CardItem
import kotlinx.android.synthetic.main.item_card_type_8.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 13/04/2020 18.49
 ****************************************************/
class CardType8ViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_card_type_8, parent, false)
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val cardItem = item as CardItem

        itemView.tv_item_title_8.text = cardItem.title
        itemView.tv_item_caption_8.text = cardItem.title
        itemView.iv_item_banner_8.setImageResource(cardItem.imageResource)
        itemView.iv_item_thumbnail_8.setImageResource(cardItem.imageResource)

        itemView.item_card_view_8.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }

        itemView.btn_item_8.setOnClickListener {
            onItemClickListener?.onButtonItemClick(it, bindingAdapterPosition)
        }

        itemView.btn_item_share_8.setOnClickListener {
            onItemClickListener?.onButtonShareItemClick(it, bindingAdapterPosition)
        }

        itemView.btn_item_notification_8.setOnClickListener {
            onItemClickListener?.onButtonNotificationItemClick(it, bindingAdapterPosition)
        }
    }
}