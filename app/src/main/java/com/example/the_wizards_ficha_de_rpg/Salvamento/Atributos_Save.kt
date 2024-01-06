package com.example.the_wizards_ficha_de_rpg.Salvamento

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Atributos_Save(
    @PrimaryKey(autoGenerate = true) val id: Int = 1000,
    val ptD: Int,
    val ptR: Int,
    val ptI: Int,
    val ptF: Int,
    val ptVI: Int,
    val ptMA: Int,
    // BONUS
    val BdD: Int = 0,
    val BdR: Int = 0,
    val BdI: Int = 0,
    val BdF: Int = 0,
    val BdVI: Int = 0,
    val BdMA: Int = 0,
    //EXTRA BONUS
    val ExD: Int = 0,
    val ExR: Int = 0,
    val ExI: Int = 0,
    val ExF: Int = 0,
    val ExVI: Int = 0,
    val ExMA: Int = 0,
    //ARMADURAS E MOBILIDADE
    val Ar_M: Int = 0,
    val Ar_F: Int = 0,
    val Mobi: Int = 0,
    //RAÇA
    val raca: String = "null",
    //ELEMENTO
    val ele: String = "null"

) : Parcelable