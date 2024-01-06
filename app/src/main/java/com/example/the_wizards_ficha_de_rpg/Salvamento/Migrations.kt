package com.example.the_wizards_ficha_de_rpg.Salvamento

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration( 1 , 2 ){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS Atributos_Save (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL DEFAULT 1000, " +
                    "ptD INTEGER NOT NULL, " +
                    "ptR INTEGER NOT NULL, " +
                    "ptI INTEGER NOT NULL, " +
                    "ptF INTEGER NOT NULL, " +
                    "ptVI INTEGER NOT NULL, " +
                    "ptMA INTEGER NOT NULL)"
        )
    }

}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS Item_feitico_temp (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "imagem BLOB NOT NULL, " +
                    "nome TEXT NOT NULL, " +
                    "custodemana TEXT NOT NULL, " +
                    "tempodecarga TEXT NOT NULL, " +
                    "descricao TEXT NOT NULL)"
        )
        // Copia os dados da tabela antiga para a nova
        database.execSQL("INSERT INTO Item_feitico_temp SELECT * FROM Item_feitico")

        // Remove a tabela antiga
        database.execSQL("DROP TABLE Item_feitico")

        // Renomeia a tabela temporária para o nome original
        database.execSQL("ALTER TABLE Item_feitico_temp RENAME TO Item_feitico")
    }
}

val MIGRATION_3_4 = object : Migration(3,4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Cria uma tabela temporária com os campos adicionais
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS Atributos_Save_temp (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL DEFAULT 1000, " +
                    "ptD INTEGER NOT NULL, " +
                    "ptR INTEGER NOT NULL, " +
                    "ptI INTEGER NOT NULL, " +
                    "ptF INTEGER NOT NULL, " +
                    "ptVI INTEGER NOT NULL, " +
                    "ptMA INTEGER NOT NULL, " +
                    "BdD INTEGER NOT NULL DEFAULT 0, " +
                    "BdR INTEGER NOT NULL DEFAULT 0, " +
                    "BdI INTEGER NOT NULL DEFAULT 0, " +
                    "BdF INTEGER NOT NULL DEFAULT 0, " +
                    "BdVI INTEGER NOT NULL DEFAULT 0, " +
                    "BdMA INTEGER NOT NULL DEFAULT 0)"
        )

        // Copia os dados da tabela antiga para a nova
        database.execSQL(
            "INSERT INTO Atributos_Save_temp (id, ptD, ptR, ptI, ptF, ptVI, ptMA, BdD, BdR, BdI, BdF, BdVI, BdMA) " +
                    "SELECT id, ptD, ptR, ptI, ptF, ptVI, ptMA, 0, 0, 0, 0, 0, 0 FROM Atributos_Save"
        )

        // Remove a tabela antiga
        database.execSQL("DROP TABLE Atributos_Save")

        // Renomeia a tabela temporária para o nome original
        database.execSQL("ALTER TABLE Atributos_Save_temp RENAME TO Atributos_Save")
    }
}

val MIGRATION_4_5 = object : Migration(4,5) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Cria uma tabela temporária com os campos adicionais
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS Atributos_Save_temp (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL DEFAULT 1000, " +
                    "ptD INTEGER NOT NULL, " +
                    "ptR INTEGER NOT NULL, " +
                    "ptI INTEGER NOT NULL, " +
                    "ptF INTEGER NOT NULL, " +
                    "ptVI INTEGER NOT NULL, " +
                    "ptMA INTEGER NOT NULL, " +
                    "BdD INTEGER NOT NULL DEFAULT 0, " +
                    "BdR INTEGER NOT NULL DEFAULT 0, " +
                    "BdI INTEGER NOT NULL DEFAULT 0, " +
                    "BdF INTEGER NOT NULL DEFAULT 0, " +
                    "BdVI INTEGER NOT NULL DEFAULT 0, " +
                    "BdMA INTEGER NOT NULL DEFAULT 0, " +
                    "ExD INTEGER NOT NULL DEFAULT 0, " +
                    "ExR INTEGER NOT NULL DEFAULT 0, " +
                    "ExI INTEGER NOT NULL DEFAULT 0, " +
                    "ExF INTEGER NOT NULL DEFAULT 0, " +
                    "ExVI INTEGER NOT NULL DEFAULT 0, " +
                    "ExMA INTEGER NOT NULL DEFAULT 0, " +
                    "Ar_M INTEGER NOT NULL DEFAULT 0, " +
                    "Ar_F INTEGER NOT NULL DEFAULT 0, " +
                    "Mobi INTEGER NOT NULL DEFAULT 0, " +
                    "raca TEXT NOT NULL DEFAULT 'null', " +
                    "ele TEXT NOT NULL DEFAULT 'null')"
        )

        // Copia os dados da tabela antiga para a nova
        database.execSQL(
            "INSERT INTO Atributos_Save_temp (id, ptD, ptR, ptI, ptF, ptVI, ptMA, BdD, BdR, BdI, BdF, BdVI, BdMA, ExD, ExR, ExI, ExF, ExVI, ExMA, Ar_M, Ar_F, Mobi, raca, ele) " +
                    "SELECT id, ptD, ptR, ptI, ptF, ptVI, ptMA, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'null', 'null' FROM Atributos_Save"
        )

        // Remove a tabela antiga
        database.execSQL("DROP TABLE Atributos_Save")

        // Renomeia a tabela temporária para o nome original
        database.execSQL("ALTER TABLE Atributos_Save_temp RENAME TO Atributos_Save")
    }
}

val MIGRATION_5_6 = object : Migration(5, 6) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Cria uma tabela temporária com a coluna adicionada
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS Item_feitico_temp (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "imagem BLOB NOT NULL, " +
                    "nome TEXT NOT NULL, " +
                    "custodemana TEXT NOT NULL, " +
                    "tempodecarga TEXT NOT NULL, " +
                    "descricao TEXT NOT NULL, " +
                    "isSelected INTEGER NOT NULL DEFAULT 0)"
        )

        // Copia os dados da tabela antiga para a nova
        database.execSQL(
            "INSERT INTO Item_feitico_temp (id, imagem, nome, custodemana, tempodecarga, descricao) " +
                    "SELECT id, imagem, nome, custodemana, tempodecarga, descricao FROM Item_feitico"
        )

        // Remove a tabela antiga
        database.execSQL("DROP TABLE Item_feitico")

        // Renomeia a tabela temporária para o nome original
        database.execSQL("ALTER TABLE Item_feitico_temp RENAME TO Item_feitico")
    }
}
