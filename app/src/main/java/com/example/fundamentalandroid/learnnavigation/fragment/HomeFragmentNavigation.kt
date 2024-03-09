package com.example.fundamentalandroid.learnnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.fundamentalandroid.R
import com.example.fundamentalandroid.databinding.FragmentHomeNavigationBinding


class HomeFragmentNavigation : Fragment() {

    private  var _binding: FragmentHomeNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryNavigation.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragmentNavigation_to_categoryFragment)
        )

        binding.btnProfileNavigation.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragmentNavigation_to_profileActivity)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}