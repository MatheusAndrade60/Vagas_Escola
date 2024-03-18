package br.com.fiap.projeto_vagas_escola.database.repository

import android.content.Context
import br.com.fiap.projeto_vagas_escola.database.dao.UsuarioDb
import br.com.fiap.projeto_vagas_escola.model.Usuario

class UsuarioRepository(context: Context) {

    var db = UsuarioDb.getDatabase(context).usuarioDao()

    fun salvar(usuario: Usuario): Long{
        return db.salvar(usuario = usuario)
    }

    fun validarCredenciais(email: String, senha: String): Boolean {
        val usuario = db.buscarUsuarioPorEmail(email)
        return usuario != null && usuario.senha == senha
    }
}