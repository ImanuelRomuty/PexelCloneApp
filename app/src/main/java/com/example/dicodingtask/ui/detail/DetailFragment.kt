package com.example.dicodingtask.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.dicodingtask.R
import com.example.dicodingtask.data.local.Photo
import com.example.dicodingtask.databinding.FragmentDetailBinding
import com.example.dicodingtask.ui.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class DetailFragment : Fragment() {
    private val binding: FragmentDetailBinding by viewBinding()
    private val viewModel by sharedViewModel<DetailViewModel>()
    private val favoriteViewModel by sharedViewModel<FavoriteViewModel>()
    private val arguments : DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load(arguments.photo.src?.original)
            .into(binding.imgPhoto)



        binding.photographerNameTextView.text = arguments.photo.photographer?.let { capitalize(it) }
        binding.photographerUrlTextView.text = arguments.photo.photographerUrl
        binding.alternativeTextView.text = arguments.photo.alt?.let { capitalize(it) }
        binding.addFavoriteButton.setOnClickListener {
            val photo = Photo(
                id = arguments.photo.id,
                imagePath = arguments.photo.src?.original,
                name = arguments.photo.photographer,
                url = arguments.photo.photographerUrl,
                alt = arguments.photo.alt
            )
            viewModel.insertPhoto(photo)
            Toast.makeText(context , "Sukses Tambah Data" , Toast.LENGTH_SHORT).show()
            favoriteViewModel.favoritePhoto()
            findNavController().navigate(R.id.action_detailFragment_to_home_menu)
        }
        binding.shareButton.setOnClickListener {
            sharePhoto()
            findNavController().navigate(R.id.action_detailFragment_to_home_menu)
        }

    }
    private fun capitalize(text : String):String{
        val words = text.split(" ").toMutableList()
        var output = ""
        for(word in words){
            output += word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } +" "
        }
        output = output.trim()
        return output
    }
    private fun sharePhoto() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Photographer Name : ${arguments.photo.photographer} \nPhotographer Url : ${arguments.photo.photographerUrl} \nPhoto Link : ${arguments.photo.src?.original}")
        val chooser = Intent.createChooser(intent, "Photo from Pexels")
        startActivity(chooser)
    }


}