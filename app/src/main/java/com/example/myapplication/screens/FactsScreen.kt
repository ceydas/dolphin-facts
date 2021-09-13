package com.example.myapplication.screens

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.FragmentFactsScreenBinding
import com.example.myapplication.view_models.FactsViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import java.lang.StringBuilder
import kotlin.math.ln


class FactsScreen( ) : Fragment() {

    private val viewModel by lazy {ViewModelProvider(this).get(FactsViewModel()::class.java)}
    private var _binding: FragmentFactsScreenBinding? = null
    // onDestroyView.
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFactsScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
        binding.fabDelete.setOnClickListener { onCustomFactDeleted() }

        updateNewPage()
        return view
    }

    fun updateNewPage(){
        binding.imgDolphin.setImageResource(viewModel.image)
        binding.tvDolphinName.text = viewModel.dolphinName
        binding.tvFact.text = viewModel.fact
        binding.tvFact.setTextColor(resources.getColor(viewModel.colorFact))
        binding.tvDolphinName.setTextColor(resources.getColor(viewModel.colorName))
        Log.i("update length", "length:${binding.tvFact.length()}")
        Log.i("update color", "color:${binding.tvFact.currentTextColor}")
        if (binding.tvFact.length() < 167) {
            binding.scrollView.isVerticalScrollBarEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onCustomFactDeleted() : View? {
        viewModel.onCustomFactDeleted()
        updateNewPage()
        return view
    }





}