package com.bigw.pokemonheroes.adapter

import java.io.Serializable

data class PokemonModel(
    val id: Int,
    val name: String,
    val img: String,
    val type: String,
    val weight: Double,
    val height: Double,
    val hp: Int,
    val atk: Int,
    val def: Int,
    val sa: Int,
    val sd: Int,
    val speed: Int
) : Serializable
