package com.example.the_wizards_ficha_de_rpg.Salvamento

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.the_wizards_ficha_de_rpg.feitico.FeiticoDao
import com.example.the_wizards_ficha_de_rpg.feitico.Item_feitico
import com.example.the_wizards_ficha_de_rpg.mochila.ItemDao
import com.example.the_wizards_ficha_de_rpg.mochila.convertes
import com.example.the_wizards_ficha_de_rpg.model.Item

@Database(entities = [Item::class, Atributos_Save::class, Item_feitico::class], version = 6, exportSchema = true)
@TypeConverters(convertes::class)
abstract class Data_Class_Item_Doa : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    abstract fun feiticoDao(): FeiticoDao

    abstract fun mainSave(): AtributosDAO

    companion object {
        private var INSTANCE: Data_Class_Item_Doa? = null

        fun instancia(context: Context): Data_Class_Item_Doa {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Data_Class_Item_Doa::class.java,
                    "nome_do_seu_banco_de_dados"
                )   .addMigrations(MIGRATION_1_2,MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5,MIGRATION_5_6)
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}
