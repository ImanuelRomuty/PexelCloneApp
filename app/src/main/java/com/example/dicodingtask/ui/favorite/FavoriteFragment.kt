package com.example.dicodingtask.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dicodingtask.R
import com.example.dicodingtask.adapter.FavoriteAdapter

import com.example.dicodingtask.databinding.FragmentFavoriteBinding

import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FavoriteFragment : Fragment() {
    private val binding: FragmentFavoriteBinding by viewBinding()
    private val viewModel by sharedViewModel<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserve()

    }
    private fun setUpObserve(){
        viewModel.photo().observe(viewLifecycleOwner) { photo ->
            val adapter = FavoriteAdapter(photo)
            val layoutManager = GridLayoutManager(requireContext(), 2)
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = adapter
        }
    }
}