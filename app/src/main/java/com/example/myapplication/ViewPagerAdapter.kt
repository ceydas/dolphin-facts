package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.myapplication.screens.AboutScreen
import com.example.myapplication.screens.FactsScreen
class ViewPagerAdapter(list: ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle){


     private val fragmentList : MutableList<Fragment> = list



    override fun getItemCount(): Int {
        return 120
        //fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        if ( position < 60)
            fragmentList.add(position, FactsScreen())
        return fragmentList[position]
    }

    fun getCurrentItem(): Int {
        return when (getCurrentItem()) {
            0 -> itemCount - 3
            itemCount - 1 -> 0
            else -> getCurrentItem() - 1
        }
    }






}