package br.com.fiap.projeto_vagas_escola.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.projeto_vagas_escola.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario) : Long

    @Query("SELECT * FROM TB_USUARIOS WHERE email = :email LIMIT 1")
    fun buscarUsuarioPorEmail(email: String): Usuario?
}