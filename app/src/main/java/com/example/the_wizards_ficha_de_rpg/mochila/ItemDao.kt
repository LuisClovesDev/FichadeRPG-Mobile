package com.example.the_wizards_ficha_de_rpg.mochila

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_wizards_ficha_de_rpg.model.Item

@Dao
interface ItemDao {

    @Query("SELECT * FROM Item")
    fun buscatodos(): List<Item>

@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg item: Item )
}