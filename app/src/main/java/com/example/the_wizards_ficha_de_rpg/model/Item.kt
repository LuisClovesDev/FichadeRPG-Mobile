package com.example.the_wizards_ficha_de_rpg.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Item (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var bitmap: Bitmap,
    var nome: String,
    var descricao: String,
    var bonus: String,
    val isSelected: Boolean = false
) : Parcelable
