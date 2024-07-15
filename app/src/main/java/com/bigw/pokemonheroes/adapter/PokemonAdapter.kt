package com.bigw.pokemonheroes.adapter

import android.R
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.request.transition.Transition
import com.bigw.pokemonheroes.databinding.ItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import java.net.URL


class PokemonAdapter(context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    var color: Int? = null

    var onClickItem: ((id: Int, color: Int) -> Unit)? = null

    val context = context

    private var data = ArrayList<PokemonModel>()

    fun setdata(data: ArrayList<PokemonModel>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun getData(position: Int) : PokemonModel{
        return data[position]
    }

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun binddata(pokemon: PokemonModel, position: Int){
            binding.itemText.text = pokemon.name
            binding.itemImage.load(pokemon.img)

            val imageUrl = pokemon.img

            getDominantColorFromUrl(context, imageUrl) { dominantColor ->
                binding.root.setBackgroundColor(dominantColor)
                color = dominantColor
                val shape = GradientDrawable()
                shape.cornerRadius = 35F
                shape.setColor(dominantColor)
                binding.root.background = shape
            }

            binding.root.setOnClickListener {

                val image = data[position].img

                getDominantColorFromUrl(context, image){dominantColor ->
                    onClickItem?.invoke(position, dominantColor)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binddata(data[position], position)
    }

    fun getDominantColorFromUrl(context: Context, url: String, callback: (Int) -> Unit) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val dominantColor = getDominantColor(resource)
                    callback(dominantColor)
                }
                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    fun getDominantColor(bitmap: Bitmap): Int {
        val palette = Palette.from(bitmap).generate()
        return palette.getDominantColor(0x000000)
    }

}



















