package com.example.hpapplicationtp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios_entity")
data class Examen(
  @ColumnInfo(name = "nombre_usuario") var nombre_usuario: String,
  @ColumnInfo(name = "password") var password: String,
  @ColumnInfo(name = "mail") var mail: String
) {
  @PrimaryKey(autoGenerate = true) var id: Int = 0
}
