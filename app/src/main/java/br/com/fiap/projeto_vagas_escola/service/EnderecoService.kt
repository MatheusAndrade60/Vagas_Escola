package br.com.fiap.projeto_vagas_escola.service

import br.com.fiap.projeto_vagas_escola.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {
    //Base Url: https://viacep.com.br/ws/
    @GET("{cep}/json/")
    fun getEnderecoByCep(@Path("cep") cep: String): Call<Endereco>
}