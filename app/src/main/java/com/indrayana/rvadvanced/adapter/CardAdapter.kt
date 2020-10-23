package com.indrayana.rvadvanced.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.adapter.viewholder.*
import com.indrayana.rvadvanced.model.CardItem
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_1
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_2
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_3
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_4
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_5
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_6
import com.indrayana.rvadvanced.utils.ItemViewSize
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_7
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_8

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 05/04/2020 16.30
 ****************************************************/
class CardAdapter(
    private var itemList: MutableList<CardItem>,
    private var viewType: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListenerImpl? = null
    var itemViewSize: ItemViewSize? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (this.viewType) {
            VIEW_TYPE_CARD_1 -> CardType1ViewHolder(parent)
            VIEW_TYPE_CARD_2 -> CardType2ViewHolder(parent)
            VIEW_TYPE_CARD_3 -> CardType3ViewHolder(parent)
            VIEW_TYPE_CARD_4 -> CardType4ViewHolder(parent)
            VIEW_TYPE_CARD_5 -> CardType5ViewHolder(parent)
            VIEW_TYPE_CARD_7 -> CardType7ViewHolder(parent)
            VIEW_TYPE_CARD_8 -> CardType8ViewHolder(parent)
            else -> CardType6ViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (this.viewType) {
            VIEW_TYPE_CARD_1 -> (holder as CardType1ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_2 -> (holder as CardType2ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_3 -> (holder as CardType3ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_4 -> (holder as CardType4ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }

            VIEW_TYPE_CARD_5 -> (holder as CardType5ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_6 -> (holder as CardType6ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_7 -> (holder as CardType7ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
            VIEW_TYPE_CARD_8 -> (holder as CardType8ViewHolder).apply {
                bindItem(itemList[position], onItemClickListener)
                setItemViewSize(itemViewSize)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (this.viewType) {
            VIEW_TYPE_CARD_1 -> VIEW_TYPE_CARD_1
            VIEW_TYPE_CARD_2 -> VIEW_TYPE_CARD_2
            VIEW_TYPE_CARD_3 -> VIEW_TYPE_CARD_3
            VIEW_TYPE_CARD_4 -> VIEW_TYPE_CARD_4
            VIEW_TYPE_CARD_5 -> VIEW_TYPE_CARD_5
            VIEW_TYPE_CARD_6 -> VIEW_TYPE_CARD_6
            VIEW_TYPE_CARD_7 -> VIEW_TYPE_CARD_7
            VIEW_TYPE_CARD_8 -> VIEW_TYPE_CARD_8
            else -> super.getItemViewType(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setViewType(viewType: Int) {
        this.viewType = viewType
    }

}