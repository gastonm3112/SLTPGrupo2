package com.example.hpapplicationtp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("select * from usuarios_entity")
    fun getAll(): List<Usuario>

    @Insert
    fun insertUsuario(usuario: Usuario)
}
