package com.example.the_wizards_ficha_de_rpg

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.the_wizards_ficha_de_rpg.mochila.ItemDao
import com.example.the_wizards_ficha_de_rpg.mochila.convertes
import com.example.the_wizards_ficha_de_rpg.model.Item

@Database(entities = [Item::class], version = 1)
@TypeConverters(convertes::class)
abstract class Data_Class_Item_Doa: RoomDatabase() {

    abstract fun itemDao(): ItemDao
}