package br.com.fiap.projeto_vagas_escola.database.repository
import br.com.fiap.projeto_vagas_escola.model.School

fun obterTodasEscolas(): List<School> {
    return listOf(
        School("E.E Irene de lima paiva", 30, "Rua Lutecia, 495", 2.2),
        School("Coronel Pedro Arbues", 50, "Rua do Saboó, 17", 1.2),
        School("Colégio Santa Marina", 25, "Rua Guilherme Giorgi, 204", 1.0),
        School("Colégio Angra", 18, "Rua tatuí, 25", 2.0),
        School("CEU Carrão", 4, "Rua Monte Serrat, 380", 0.5),
        School("E.M.E.F. Lourenço de Gusmão", 13, "Rua R. Picinguaba, 802", 3.0)
    )
}
fun getSchoolsByEscola(nomeEscola: String): List<School> {
    return obterTodasEscolas().filter {
        it.nomeEscola.startsWith(prefix = nomeEscola, ignoreCase = true)
    }
}

