package br.com.fiap.projeto_vagas_escola.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_USUARIO")
data class Usuario(
    @PrimaryKey(autoGenerate = true) var id_usuario : Long = 0,
    var nome_responsavel : String = "",
    var cpf_responsavel : String = "",
    var cep : String = "",
    var email : String = "",
    var senha : String = "",
)