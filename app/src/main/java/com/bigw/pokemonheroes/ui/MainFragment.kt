package com.bigw.pokemonheroes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bigw.pokemonheroes.R
import com.bigw.pokemonheroes.adapter.PokemonAdapter
import com.bigw.pokemonheroes.adapter.PokemonModel
import com.bigw.pokemonheroes.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main){

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { PokemonAdapter(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)

        setAdapter()
        loadAction()

    }

    private fun loadAction() {
        adapter.onClickItem = {id, color ->

            Log.d("tageeee323", "loadAction: $color")

            val pokemon = adapter.getData(id)

            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAboutFragment(pokemon, color))

        }
    }

    private fun setAdapter() {
        var pokemons = ArrayList<PokemonModel>()

        pokemons.add(PokemonModel(0, "Bulbasaur", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png", "Grass", 6.8, 2.04, 3, 3, 3, 4, 4, 3))
        pokemons.add(PokemonModel(1, "Ivysaur", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/002.png", "Grass", 12.7, 3.03, 4, 4, 4, 5, 5, 4))
        pokemons.add(PokemonModel(2, "Venusaur", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/003.png", "Grass", 99.7, 6.07, 5, 5, 5, 6, 6, 5))
        pokemons.add(PokemonModel(3, "Charmander", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png", "Fire", 8.1, 2.00, 3, 4, 3, 4, 3, 4))
        pokemons.add(PokemonModel(4, "Charmeleon", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/005.png", "Fire", 18.5, 3.07, 4, 4, 4, 5, 4, 5))
        pokemons.add(PokemonModel(5, "Charizard", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png", "Fire", 90.2, 5.07, 5, 5, 5, 7, 5, 6))
        pokemons.add(PokemonModel(6, "Squirtle", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png", "Water", 8.6, 1.08, 3, 3, 4, 3, 4, 3))
        pokemons.add(PokemonModel(7, "Wartortle", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/008.png", "Water", 22.2, 3.03, 4, 4, 5, 4, 5, 4))
        pokemons.add(PokemonModel(8, "Blastoise", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/009.png", "Water", 85.2, 5.03, 5, 5, 6, 5, 7, 5))
        pokemons.add(PokemonModel(9, "Caterpie", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/010.png", "Bug", 2.7, 1.00, 3, 2, 3, 2, 2, 3))
        pokemons.add(PokemonModel(10, "Metapod", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/011.png", "Bug", 9.5, 2.04, 3, 2, 4, 3, 3, 3))
        pokemons.add(PokemonModel(11, "Butterfree", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/012.png", "Bug", 31.7, 3.07, 4, 3, 3, 6, 5, 5))
        pokemons.add(PokemonModel(12, "Weedle", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/013.png", "Bug", 3.1, 1.00, 3, 3, 2, 2, 2, 3))
        pokemons.add(PokemonModel(13, "Kakuna", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/014.png", "Bug", 9.9, 2.00, 3, 2, 3, 2, 2, 3))
        pokemons.add(PokemonModel(14, "Beedrill", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/015.png", "Bug", 29.4, 3.03, 4, 6, 3, 3, 5, 5))
        pokemons.add(PokemonModel(15, "Pidgey", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/016.png", "Normal", 1.8, 1.00, 3, 3, 3, 3, 3, 4))
        pokemons.add(PokemonModel(16, "Pidgeotto", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/017.png", "Normal", 29.9, 3.07, 4, 4, 4, 3, 3, 5))
        pokemons.add(PokemonModel(17, "Pidgeot", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/018.png", "Normal", 39.4, 4.11, 5, 5, 5, 5, 5, 6))
        pokemons.add(PokemonModel(18, "Rattata", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/019.png", "Normal", 3.1, 1.00, 2, 4, 3, 2, 3, 5))
        pokemons.add(PokemonModel(19, "Raticate", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/020.png", "Normal", 18.1, 2.04, 4, 5, 4, 3, 5, 6))

        adapter.setdata(pokemons)

        var pokemon = adapter.getData(3)











































    }


}