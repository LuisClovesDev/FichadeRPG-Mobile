package com.example.the_wizards_ficha_de_rpg.mochila

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.the_wizards_ficha_de_rpg.model.Item

@Dao
interface ItemDao {

    @Query("SELECT * FROM Item")
    fun buscatodos(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg item: Item )

    @Delete
    fun remover(item: Item)

    @Query("SELECT * FROM Item WHERE id = :itemId")
    fun buscaPorId(itemId: Long): Item?

    @Update
    fun atualiza(item: Item)

}