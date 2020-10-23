package com.indrayana.rvadvanced.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.adapter.viewholder.CardTypeCategoryViewHolder
import com.indrayana.rvadvanced.model.CategoryItem

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 12/04/2020 17.02
 ****************************************************/
class CategoryAdapter(
    private var itemList: MutableList<CategoryItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListenerImpl? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardTypeCategoryViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CardTypeCategoryViewHolder).bindItem(itemList[position], onItemClickListener)
    }
}