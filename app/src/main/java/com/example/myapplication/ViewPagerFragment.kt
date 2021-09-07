package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.FragmentViewPagerBinding
import com.example.myapplication.screens.AboutScreen
import com.example.myapplication.screens.FactsNextScreen
import com.example.myapplication.screens.FactsScreen


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(FactsScreen(), FactsNextScreen(),AboutScreen())
        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle)

        val theViewPager = binding.viewPager
        binding.viewPager.adapter = adapter
        /*
        val firstFragment = theViewPager.getChildAt(0) as RecyclerView
        theViewPager.setCurrentItem(1,false)

            val itemCount = adapter.itemCount
        firstFragment.apply{
            addOnScrollListener( InfiniteScrollBehaviour(itemCount,
                layoutManager as LinearLayoutManager))
        }

        theViewPager.adapter = adapter

        fun getCurrentItem(): Int {
            return when (theViewPager.currentItem) {
                0 -> itemCount - 3
                itemCount - 1 -> 0
                else -> theViewPager.currentItem - 1
            }
        }

         */


        return view
    }


    inner class InfiniteScrollBehaviour(
        private val itemCount: Int,
        private val layoutManager: LinearLayoutManager
    ) : RecyclerView.OnScrollListener() {

        override fun onScrolled(
            recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val firstItemVisible
                    = layoutManager.findFirstVisibleItemPosition()
            val lastItemVisible
                    = layoutManager.findLastVisibleItemPosition()
            if (firstItemVisible == (itemCount - 1) && dx > 0) {
                recyclerView.scrollToPosition(1)
            } else if (lastItemVisible == 0 && dx < 0) {
                recyclerView.scrollToPosition(itemCount - 2)
            }
        }
    }





}