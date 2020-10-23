package com.indrayana.rvadvanced.model

import com.indrayana.rvadvanced.utils.ItemViewSize

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 12/04/2020 16.53
 ****************************************************/
data class CategoryItem(
    var title: String,
    var viewType: Int,
    var cardItem: MutableList<CardItem>,
    var itemViewSize: ItemViewSize
)