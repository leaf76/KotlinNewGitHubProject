package com.leaf76.kotlinnewgithubproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.leaf76.kotlinnewgithubproject.R
import com.leaf76.kotlinnewgithubproject.databinding.FragmentMainBinding
import com.leaf76.kotlinnewgithubproject.viewmodels.MainViewModel
import kotlinx.coroutines.*


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

        showResponse()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showResponse(){
        mainViewModel.getSearchGitHubUsers()
    }

}