package br.com.fiap.projeto_vagas_escola.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.fiap.projeto_vagas_escola.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario) : Long
}