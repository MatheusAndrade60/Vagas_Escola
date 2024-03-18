package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.com.fiap.projeto_vagas_escola.component.Header
import br.com.fiap.projeto_vagas_escola.database.repository.getSchoolsByEscola
import br.com.fiap.projeto_vagas_escola.database.repository.obterTodasEscolas
import br.com.fiap.projeto_vagas_escola.model.School


@Composable
fun SchoolListScreen(navController: NavHostController, schoolListScreen: Unit){
    var stateSchool by remember {
        mutableStateOf("")
    }
    var listSchoolsByEscola by remember {
        mutableStateOf(getSchoolsByEscola(stateSchool))
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ){
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Lista de Escolas da Região ",
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Header()
            OutlinedTextField(
                value = stateSchool,
                onValueChange = {
                    stateSchool = it
                    listSchoolsByEscola = getSchoolsByEscola(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label = {
                    Text(text = "Nome da Escola")
                },
                trailingIcon = {
                    IconButton(onClick = {})
                    {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "icon-search"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.padding(10.dp)) {
                items(listSchoolsByEscola) {
                    SchoolCard(school = it)
                }
            }
        }
    }
}
@Composable
fun SchoolCard(school: School){
    Card(modifier = Modifier.padding(bottom = 8.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF7FCA7F))
        )
        {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(3f)) {
                Text(
                    text = school.nomeEscola,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = school.enderecoEscola,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Vagas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = school.quantidadeVagas.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Yellow
                )
            }
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SchoolListScreenView() {
//    SchoolListScreen()
//}


