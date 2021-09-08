package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFactsNextScreenBinding
import com.example.myapplication.view_models.FactsViewModel

class FactsNextScreen : Fragment() {

    private lateinit var viewModel: FactsViewModel


    private lateinit var binding: FragmentFactsNextScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_facts_next_screen,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(FactsViewModel::class.java)

        binding.buttonNextFact.setOnClickListener(){onNext()}

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        updateNewPage()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "Crickets!")
    }

    private fun onNext(){
        val action = FactsNextScreenDirections.actionFactsNextScreenToViewPagerFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun updateNewPage(){
        binding.imgDolphin.setImageResource(viewModel.image)
        binding.tvDolphinName.text = viewModel.dolphinName
        binding.tvFact.text = viewModel.fact
        binding.tvFact.setTextColor(resources.getColor(viewModel.colorFact))
        binding.tvDolphinName.setTextColor(resources.getColor(viewModel.colorName))
    }


}