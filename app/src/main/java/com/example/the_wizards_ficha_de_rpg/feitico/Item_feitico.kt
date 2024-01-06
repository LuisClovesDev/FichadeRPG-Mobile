package com.example.the_wizards_ficha_de_rpg.feitico

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Item_feitico(

    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var imagem: Bitmap,
    var nome: String,
    var custodemana:String,
    var tempodecarga:String,
    var descricao: String,
    val isSelected: Boolean = false

    ): Parcelable