package com.example.dicodingtask.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dicodingtask.R
import com.example.dicodingtask.adapter.PhotoAdapter
import com.example.dicodingtask.databinding.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel by sharedViewModel<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.photo().observe(viewLifecycleOwner){ photo->
            val adapter = PhotoAdapter(photo)
            val layoutManager = GridLayoutManager(requireContext(),2)
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = adapter

        }
    }
}