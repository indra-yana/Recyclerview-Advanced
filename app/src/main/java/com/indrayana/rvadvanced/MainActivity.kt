package com.indrayana.rvadvanced

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.indrayana.rvadvanced.adapter.FragmentAdapter
import com.indrayana.rvadvanced.fragment.ListToGridFragment
import com.indrayana.rvadvanced.fragment.NestedListFragment
import com.indrayana.rvadvanced.fragment.SimpleListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var backPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_main)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_simple_list -> {
                    view_pager2.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_list_to_grid -> {
                    view_pager2.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_nested_list -> {
                    view_pager2.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

        setupViewPager(view_pager2)
    }

    private fun setupViewPager(viewPager2: ViewPager2) {
        val viewPager2Adapter = FragmentAdapter(this).apply {
            addFragment(SimpleListFragment(), getString(R.string.title_simple_list_fragment))
            addFragment(ListToGridFragment(), getString(R.string.title_list_to_grid_fragment))
            addFragment(NestedListFragment(), getString(R.string.title_nested_list_fragment))
        }

        viewPager2.isUserInputEnabled = false
        viewPager2.adapter = viewPager2Adapter
    }

    private fun setSelectedBottomNavigation(position: Int) {
        when (position) {
            0 -> bottom_navigation.selectedItemId = R.id.menu_simple_list
            1 -> bottom_navigation.selectedItemId = R.id.menu_list_to_grid
            2 -> bottom_navigation.selectedItemId = R.id.menu_nested_list
        }
    }

    override fun onBackPressed() {
        if (view_pager2.currentItem > 0) {
            view_pager2.currentItem = 0
            setSelectedBottomNavigation(view_pager2.currentItem)
        } else {
            // Check if back is already pressed. If yes, then exit the app.
            if (backPressedOnce) {
                super.onBackPressed()
                return
            }

            backPressedOnce = true
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                backPressedOnce = false
            }, 2000)
        }
    }
}
