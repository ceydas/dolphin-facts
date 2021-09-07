package com.example.myapplication.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import java.io.IOException
import kotlin.random.Random
import android.graphics.drawable.Drawable

import android.content.res.AssetManager
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.FragmentFactsScreenBinding
import com.example.myapplication.view_models.FactsViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Dolphin
import com.example.myapplication.MainActivity


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
        binding.buttonNextFact.setOnClickListener(){onNext()}
        val view = binding.root
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        updateNewPage()
        return view
    }

    private fun onNext(){
        val action = FactsScreenDirections.actionFactsScreenToFactsNextScreen2()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun updateNewPage(){
        binding.imgDolphin.setImageResource(viewModel.image)
        binding.tvDolphinName.text = viewModel.dolphinName
        binding.tvFact.text = viewModel.fact
        binding.tvFact.setTextColor(viewModel.colorFact)
        binding.tvDolphinName.setTextColor(viewModel.colorName)
    }




}