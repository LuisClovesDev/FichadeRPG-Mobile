package com.example.the_wizards_ficha_de_rpg.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val bitmap: Bitmap, // Certifique-se de que a classe Item tenha um campo bitmap do tipo Bitmap
    val nome: String,
    val descricao: String,
    val bonus: String,
    val isSelected: Boolean = false
)