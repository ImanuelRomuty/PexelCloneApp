package com.example.dicodingtask.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingtask.data.api.response.Photo
import com.example.dicodingtask.databinding.ListPhotoBinding
import com.example.dicodingtask.ui.home.HomeFragmentDirections
import java.util.*


class PhotoAdapter(private val item:List<Photo>) : RecyclerView.Adapter<PhotoAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ListPhotoBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ListPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val url = item[position].src?.medium

        Glide.with(holder.itemView.context)
            .load(url)
            .into(holder.binding.imgPhoto)
        holder.binding.nameTextView.text = item[position].photographer?.let { capitalize(it) }

        holder.binding.cardPhoto.setOnClickListener {
            Log.d("HomePhoto", "Id Photo : ${item[position].id}")
            val photo = Photo(
                id = item[position].id,
                photographer = item[position].photographer,
                photographerUrl = item[position].photographerUrl,
                src = item[position].src,
                alt = item[position].alt
            )
            it.findNavController().navigate(HomeFragmentDirections.actionHomeMenuToDetailFragment(photo))
        }
        }
    override fun getItemCount(): Int {
        return item.size
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
}