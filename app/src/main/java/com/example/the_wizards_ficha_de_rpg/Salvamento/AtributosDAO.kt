package com.example.the_wizards_ficha_de_rpg.Salvamento

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_wizards_ficha_de_rpg.model.Item

@Dao
interface AtributosDAO {

    @Query("SELECT * FROM atributos_save WHERE id = 1001;")
    fun busca(): Atributos_Save?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg Atributos: Atributos_Save)

    @Delete
    fun remover(Atributos: Atributos_Save)



}