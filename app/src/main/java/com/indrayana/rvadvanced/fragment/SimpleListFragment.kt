package com.indrayana.rvadvanced.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.CardAdapter
import com.indrayana.rvadvanced.adapter.CarouselMenuAdapter
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.DummyData.cardItemDummyDataLarge
import com.indrayana.rvadvanced.model.DummyData.carouselItemDummyData
import com.indrayana.rvadvanced.utils.CarouseIItemRecyclerView
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_1
import kotlinx.android.synthetic.main.fragment_simple_list.*

/**
 * A simple [Fragment] subclass.
 */
class SimpleListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCarouselMenu(rv_item_carousel)
        setupSimpleList(rv_simple_list)
    }

    private fun setupCarouselMenu(rvItemCarousel: CarouseIItemRecyclerView) {
        val itemList = carouselItemDummyData(requireContext())
        val itemAdapter = CarouselMenuAdapter(itemList).apply {
            onItemClickListener = object : OnItemClickListenerImpl() {
                override fun onItemClick(view: View?, position: Int) {
                    Toast.makeText(
                        context,
                        "Item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                    recyclerView?.scrollToPosition(position)
                }
            }
        }

        rvItemCarousel.apply {
            initialize(itemAdapter)
            setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
            setHasFixedSize(true)
            smoothScrollToPosition(0)
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        }

        itemAdapter.notifyDataSetChanged()
    }

    private fun setupSimpleList(recyclerView: RecyclerView) {
        val itemList = cardItemDummyDataLarge(requireContext(), 50)
        val itemAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_1).apply {
            onItemClickListener = object : OnItemClickListenerImpl() {
                override fun onItemClick(view: View?, position: Int) {
                    super.onItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onItemLongClick(view: View?, position: Int) {
                    super.onItemLongClick(view, position)
                    Toast.makeText(
                        context,
                        "Long click item: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

}
