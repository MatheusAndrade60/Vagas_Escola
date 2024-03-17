package br.com.fiap.projeto_vagas_escola.database.repository

import br.com.fiap.projeto_vagas_escola.model.School

fun obterTodasEscolas():List<School> {
    return listOf(
        School("E.E Irene de lima paiva",30,"Rua Lutecia, 495",2.2 ),
        School("Coronel Pedro Arbues",50,"Rua do Saboó, 17",1.2)
        School()

    )
}