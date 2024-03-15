package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.component.Header
import br.com.fiap.projeto_vagas_escola.component.TextField

@Composable
fun CadastroScreen(navController: NavController) {

    var nome_responsavel by remember {
        mutableStateOf("")
    }
    var cpf by remember {
        mutableStateOf("")
    }
    var cep by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }

    //Box inicial com logo e titulo
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
        ) {
            item {
                Header()
            }//Medoto que ira retornar um layout para o Header

            //Card para cadastrar um usuario
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-20).dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                        ) {
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "CADASTRO",
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )

                            //Aqui esta sendo utilizado um metodo que cria um OutlinedTextField
                            Spacer(modifier = Modifier.height(15.dp))
                            TextField(titulo = "Nome do Responsavel", "nome_responsavel", KeyboardType.Text)

                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(titulo = "CPF do Responsavel", "cpf", KeyboardType.Number)

                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(titulo = "CEP", "cep",KeyboardType.Number)

                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(titulo = "Email", "email", KeyboardType.Email)

                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(titulo = "Senha", "senha", KeyboardType.Password)

                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = {
                                    navController.navigate("login")
                                          },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .size(width = 118.dp, height = 40.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)
                            ) {
                                Text(
                                    text = "FINALIZAR",
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun CadastroScreenPreview() {
//    CadastroScreen()
//}