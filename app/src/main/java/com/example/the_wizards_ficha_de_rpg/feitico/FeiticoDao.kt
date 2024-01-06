package com.example.the_wizards_ficha_de_rpg.feitico

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.the_wizards_ficha_de_rpg.model.Item

@Dao
interface FeiticoDao {

    @Query("SELECT * FROM Item_feitico")
    fun buscatodos(): List<Item_feitico>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg feitico: Item_feitico)

    @Delete
    fun remover(Feitico: Item_feitico)

    @Query("SELECT * FROM Item_feitico WHERE id = :Feiticoid")
    fun buscaPorId(Feiticoid: Long): Item_feitico?

    @Update
    fun atualiza(ItemFeitico: Item_feitico)



}