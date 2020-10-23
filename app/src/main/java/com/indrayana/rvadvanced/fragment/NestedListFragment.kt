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
import com.indrayana.rvadvanced.adapter.CategoryAdapter
import com.indrayana.rvadvanced.adapter.OnItemClickListenerImpl
import com.indrayana.rvadvanced.model.DummyData.categoryItemDummyData
import kotlinx.android.synthetic.main.fragment_nested_list.*

/**
 * A simple [Fragment] subclass.
 */
class NestedListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nested_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNestedList(rv_nested_list)
    }

    private fun setupNestedList(recyclerView: RecyclerView) {
        val itemList = categoryItemDummyData(requireContext())
        val itemAdapter = CategoryAdapter(itemList).apply {
            onItemClickListener = object : OnItemClickListenerImpl() {
                override fun onButtonItemClick(view: View?, position: Int) {
                    super.onButtonItemClick(view, position)
                    Toast.makeText(
                        context,
                        "Button category item clicked: ${itemList[position].title}",
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
