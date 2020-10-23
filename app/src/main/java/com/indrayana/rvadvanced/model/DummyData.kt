package com.indrayana.rvadvanced.model

import android.content.Context
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.utils.ItemViewSize
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_1
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_2
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_3
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_4
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_5
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_6
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_7
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_8

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 08.10
 ****************************************************/
object DummyData {
    fun cardItemDummyData(context: Context?): MutableList<CardItem> {
        return mutableListOf(
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 1", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_1
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 2", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_2
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 3", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_3
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 4", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_4
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 5", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_5
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 6", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_6
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 7", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_7
            ),
            CardItem(
                context?.getString(R.string.title_lorem_ipsum) + " items 8", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_8
            )
        )
    }

    fun cardItemDummyDataLarge(context: Context?, amountData: Int): MutableList<CardItem> {
        val items = mutableListOf<CardItem>()
        (0..amountData).map {
            items.add(cardItemDummyData(context).random())
        }

        return items
    }

    fun carouselItemDummyData(context: Context?): MutableList<CarouselItem> {
        return mutableListOf(
            CarouselItem("Home", R.drawable.ic_menu_home),
            CarouselItem("Hotel", R.drawable.ic_menu_hotel),
            CarouselItem("Atm", R.drawable.ic_menu_atm),
            CarouselItem("Food", R.drawable.ic_menu_food),
            CarouselItem("Airport", R.drawable.ic_menu_airplane),
            CarouselItem("Cars", R.drawable.ic_menu_car),
            CarouselItem("Gas", R.drawable.ic_menu_gas),
            CarouselItem("Subway", R.drawable.ic_menu_subway),
            CarouselItem("School", R.drawable.ic_menu_school),
            CarouselItem("Place", R.drawable.ic_menu_map)
        )
    }

    fun carouselItemDummyDataLarge(context: Context?, amountData: Int): MutableList<CarouselItem> {
        val items = mutableListOf<CarouselItem>()
        (0..amountData).map {
            items.add(carouselItemDummyData(context).random())
        }

        return items
    }

    fun categoryItemDummyData(context: Context?): MutableList<CategoryItem> {
        return mutableListOf(
            CategoryItem(
                "Category 1",
                VIEW_TYPE_CARD_1,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_LARGE
            ),
            CategoryItem(
                "Category 2",
                VIEW_TYPE_CARD_2,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_XLARGE
            ),
            CategoryItem(
                "Category 3",
                VIEW_TYPE_CARD_3,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_LARGE
            ),
            CategoryItem(
                "Category 4",
                VIEW_TYPE_CARD_4,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_MEDIUM
            ),
            CategoryItem(
                "Category 5",
                VIEW_TYPE_CARD_5,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_LARGE
            ),
            CategoryItem(
                "Category 6",
                VIEW_TYPE_CARD_6,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_MEDIUM
            ),
            CategoryItem(
                "Category 7",
                VIEW_TYPE_CARD_7,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_LARGE
            ),
            CategoryItem(
                "Category 8",
                VIEW_TYPE_CARD_8,
                cardItemDummyDataLarge(context, (5..30).random()),
                ItemViewSize.ITEM_SIZE_LARGE
            )
        )
    }

}