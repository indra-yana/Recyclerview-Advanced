package com.indrayana.rvadvanced.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.adapter.viewholder.CarouselMenuViewHolder
import com.indrayana.rvadvanced.model.CarouselItem

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 11/04/2020 08.46
 ****************************************************/
class CarouselMenuAdapter(private var itemList: MutableList<CarouselItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListenerImpl? = null
    var recyclerView: RecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CarouselMenuViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CarouselMenuViewHolder).bindItem(itemList[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }
}