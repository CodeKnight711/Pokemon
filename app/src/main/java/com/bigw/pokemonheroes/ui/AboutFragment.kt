package com.bigw.pokemonheroes.ui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.bigw.pokemonheroes.R
import com.bigw.pokemonheroes.adapter.SetItemStatusBarColor
import com.bigw.pokemonheroes.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about){

    private val binding by lazy { FragmentAboutBinding.inflate(layoutInflater) }
    private val args : AboutFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        loadActions()

    }

    private fun loadActions() {
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setData() {
        val pokemon = args.pokemon
        val color = args.color
        SetItemStatusBarColor(color, false)

        val shape = GradientDrawable()
        shape.cornerRadius = 150F
        shape.setColor(color)
        binding.topBar.background = shape
        binding.pokemonImg.load(pokemon.img)
        binding.pokemonName.text = pokemon.name
        when(pokemon.type){
            "Grass" ->{
                val shape_text = GradientDrawable()
                shape_text.cornerRadius = 35F
                shape_text.setColor(Color.parseColor("#4CAF50"))
                binding.pokemonType.background = shape_text
                binding.pokemonType.text = "Grass"
            }
            "Fire" ->{
                val shape_text = GradientDrawable()
                shape_text.cornerRadius = 35F
                shape_text.setColor(Color.parseColor("#BD1717"))
                binding.pokemonType.background = shape_text
                binding.pokemonType.text = "Fire"
            }
            "Water" ->{
                val shape_text = GradientDrawable()
                shape_text.cornerRadius = 35F
                shape_text.setColor(Color.parseColor("#03A9F4"))
                binding.pokemonType.background = shape_text
                binding.pokemonType.text = "Water"
            }
            "Bug" ->{
                val shape_text = GradientDrawable()
                shape_text.cornerRadius = 35F
                shape_text.setColor(Color.parseColor("#DD592F"))
                binding.pokemonType.background = shape_text
                binding.pokemonType.text = "Bug"
            }
            "Normal" ->{
                val shape_text = GradientDrawable()
                shape_text.cornerRadius = 35F
                shape_text.setColor(Color.parseColor("#9C9695"))
                binding.pokemonType.background = shape_text
                binding.pokemonType.text = "Normal"
            }
        }
        binding.pokemonWeight.text = "${pokemon.weight} KG"
        binding.pokemonHeight.text = "${pokemon.height} M"
        binding.progressHp.progress = pokemon.hp
        binding.progressAt.progress = pokemon.atk
        binding.progressDe.progress = pokemon.def
        binding.progressSa.progress = pokemon.sa
        binding.progressSd.progress = pokemon.sd
        binding.progressS.progress = pokemon.speed


        binding.hpText.text = "${pokemon.hp}/15"
        binding.atText.text = "${pokemon.atk}/15"
        binding.dfText.text = "${pokemon.def}/15"
        binding.saText.text = "${pokemon.sa}/15"
        binding.sdText.text = "${pokemon.sd}/15"
        binding.sText.text = "${pokemon.speed}/15"

    }


}















































