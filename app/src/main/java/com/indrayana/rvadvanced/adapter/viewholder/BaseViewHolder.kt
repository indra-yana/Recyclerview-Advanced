package com.indrayana.rvadvanced.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.utils.ItemViewSize
import com.indrayana.rvadvanced.utils.Utils.Companion.getDeviceWidthPercentage

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 13/04/2020 09.46
 ****************************************************/
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindItem(item: Any, onItemClickListener: OnItemClickListenerImpl?)

    fun setItemViewSize(viewSize: ItemViewSize?) {
        viewSize?.let {
            itemView.layoutParams.width = getDeviceWidthPercentage(itemView.context, viewSize)
        }
    }

}