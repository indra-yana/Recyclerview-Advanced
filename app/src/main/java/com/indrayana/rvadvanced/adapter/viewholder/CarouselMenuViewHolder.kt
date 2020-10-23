package com.indrayana.rvadvanced.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.CarouselItem
import kotlinx.android.synthetic.main.item_carousel_menu.view.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 11/04/2020 08.49
 ****************************************************/
class CarouselMenuViewHolder(itemView: View) : BaseViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_menu, parent, false)
    )

    override fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?) {
        val carouselItem = item as CarouselItem

        itemView.list_item_text.text = carouselItem.title
        itemView.list_item_icon.setImageResource(carouselItem.iconResId)

        itemView.item_card_view_carousel.setOnClickListener {
            onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }
    }

}