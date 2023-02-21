package com.example.dicodingtask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingtask.data.local.Photo
import com.example.dicodingtask.databinding.ListPhotoBinding
import java.util.*

class FavoriteAdapter(private val item:List<Photo>) : RecyclerView.Adapter<FavoriteAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ListPhotoBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ListPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val url = item[position].imagePath

        Glide.with(holder.itemView.context)
            .load(url)
            .into(holder.binding.imgPhoto)
        holder.binding.nameTextView.text = item[position].name?.let { capitalize(it) }
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