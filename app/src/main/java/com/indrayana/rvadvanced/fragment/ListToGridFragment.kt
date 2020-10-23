package com.indrayana.rvadvanced.fragment


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indrayana.rvadvanced.R
import com.indrayana.rvadvanced.adapter.CardAdapter
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.DummyData
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_1
import com.indrayana.rvadvanced.utils.ItemViewType.Companion.VIEW_TYPE_CARD_2
import kotlinx.android.synthetic.main.fragment_list_to_grid.*

/**
 * A simple [Fragment] subclass.
 */
class ListToGridFragment : Fragment() {

    companion object {
        const val VIEW_TYPE_LIST = VIEW_TYPE_CARD_2
        const val VIEW_TYPE_GRID = VIEW_TYPE_CARD_1
    }

    private var mCurrentLayout = VIEW_TYPE_LIST
    private lateinit var mLayoutManager: GridLayoutManager
    private lateinit var mItemAdapter: CardAdapter
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_to_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(rv_list_to_grid)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_change_view).apply {
            if (mCurrentLayout == VIEW_TYPE_LIST) {
                icon = getDrawable(requireContext(), R.drawable.ic_view_grid_white_48dp)
                title = "Change view to grid"
            } else {
                icon = getDrawable(requireContext(), R.drawable.ic_view_list_white_48dp)
                title = "Change view to list"
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_to_grid_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_view) {
            changeRecyclerViewLayout(item)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val itemList = DummyData.cardItemDummyDataLarge(requireContext(), 50)
        mItemAdapter = CardAdapter(itemList, VIEW_TYPE_LIST).apply {
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

                override fun onButtonItemClick(view: View?, position: Int) {
                    super.onButtonItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Button item clicked: ${itemList[position].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        mLayoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)

        mRecyclerView = recyclerView
        mRecyclerView.apply {
            adapter = mItemAdapter
            layoutManager = mLayoutManager
            setHasFixedSize(true)
        }
    }

    private fun changeRecyclerViewLayout(item: MenuItem) {
        if (mCurrentLayout == VIEW_TYPE_LIST) {
            mLayoutManager.spanCount = 2

            mCurrentLayout = VIEW_TYPE_GRID
            mItemAdapter.setViewType(VIEW_TYPE_GRID)

            item.apply {
                icon = getDrawable(requireContext(), R.drawable.ic_view_list_white_48dp)
                title = "Change view to list"
            }
        } else if (mCurrentLayout == VIEW_TYPE_GRID) {
            mLayoutManager.spanCount = 1

            mCurrentLayout = VIEW_TYPE_LIST
            mItemAdapter.setViewType(VIEW_TYPE_LIST)

            item.apply {
                icon = getDrawable(requireContext(), R.drawable.ic_view_grid_white_48dp)
                title = "Change view to grid"
            }
        }

        val pos = mLayoutManager.findFirstVisibleItemPosition()
        if (pos > -1) {
            mItemAdapter.notifyItemRangeChanged(pos, mItemAdapter.itemCount)
        }
    }

}
