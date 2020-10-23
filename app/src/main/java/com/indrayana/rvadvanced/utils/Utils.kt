package com.indrayana.rvadvanced.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 12/04/2020 22.11
 ****************************************************/
class Utils {

    companion object {
        private fun getDisplayMetrics(context: Context): DisplayMetrics {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)

            return displayMetrics
        }

        fun getDeviceWidthPercentage(context: Context, viewSize: ItemViewSize?): Int {
            val displayMetrics = getDisplayMetrics(context)
            var deviceWidthPercent = displayMetrics.widthPixels
            var deviceHeightPercent = displayMetrics.heightPixels

            viewSize?.let {
                deviceWidthPercent = when (it) {
                    ItemViewSize.ITEM_SIZE_SMALL -> {
                        (displayMetrics.widthPixels / 3)
                    }
                    ItemViewSize.ITEM_SIZE_MEDIUM -> {
                        (displayMetrics.widthPixels / 2)
                    }
                    ItemViewSize.ITEM_SIZE_LARGE -> {
                        (displayMetrics.widthPixels) - (displayMetrics.widthPixels / 6)
                    }
                    ItemViewSize.ITEM_SIZE_XLARGE -> {
                        (displayMetrics.widthPixels)
                    }
                }
            }

            return deviceWidthPercent
        }
    }

}