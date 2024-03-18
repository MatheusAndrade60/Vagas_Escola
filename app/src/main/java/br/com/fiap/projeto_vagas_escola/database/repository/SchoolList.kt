package br.com.fiap.projeto_vagas_escola.database.repository
import br.com.fiap.projeto_vagas_escola.model.School
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


fun obterTodasEscolas():List<School> {
    return listOf(
        School("E.E Irene de lima paiva", 30, "Rua Lutecia, 495", 2.2),
        School("Coronel Pedro Arbues", 50, "Rua do Saboó, 17", 1.2),
        School("Colégio Santa Marina", 25, "Rua Guilherme Giorgi, 204", 1.0),
        School("Colégio Angra", 18, "Rua tatuí, 25")
    )
}
fun getSchoolsByNomeEscola(nomeEscola:String): List<School> {
    return obterTodasEscolas().filter {
        it.nomeEscola.startsWith(prefix = nomeEscola, ignoreCase = true)
    }
}

