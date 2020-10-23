package com.indrayana.rvadvanced.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 06/04/2020 21.31
 ****************************************************/
class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var mFragmentList = mutableListOf<Fragment>()
    private var mFragmentTitleList = mutableListOf<String>()
    private var mFragmentIconList = mutableListOf<Int>()

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    fun addFragment(fragment: Fragment, title: String, iconResId: Int) {
        addFragment(fragment, title)
        mFragmentIconList.add(iconResId)
    }

    fun getFragmentTitle(position: Int): String {
        return mFragmentTitleList[position]
    }

    fun getFragmentIcon(position: Int): Int {
        return mFragmentIconList[position]
    }

}