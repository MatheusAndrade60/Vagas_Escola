package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header
import androidx.compose.runtime.*
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.URL

@Composable
fun CadastroScreen(navController: NavController) {

//    val context = LocalContext.current
//    val contatoRepository = UsuarioRepository(context)

    var nomeResponsavel by remember {
        mutableStateOf("")
    }
    var cpfResponsavel by remember {
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
                .fillMaxHeight()
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
                        .padding(horizontal = 32.dp, vertical = 50.dp)
                ) {
                    Card(modifier = Modifier
                        .fillMaxWidth(),
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
                            Text(
                                text = "Nome do Responsavel",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = nomeResponsavel,
                                onValueChange = {
                                    nomeResponsavel = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 48.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "CPF do Responsavel",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cpfResponsavel,
                                onValueChange = {
                                    cpfResponsavel = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 48.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "CEP",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cep,
                                onValueChange = {
                                    cep = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 48.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Email",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = email,
                                onValueChange = {
                                    email = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 48.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Senha",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = senha,
                                onValueChange = {
                                    senha = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 48.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                            //Ao clicar no botao sera criado um novo usuario e logo em seguida ir mudar para a proxima tela
                            Button(
                                onClick = {
//                                   var usuario = Usuario(
//                                        id_usuario = 0,
//                                        nomeResponsavel = nomeResponsavel,
//                                        cpfResponsavel = cpfResponsavel,
//                                        cep = cep,
//                                        email = email,
//                                        senha = senha
//                                    )
//                                    contatoRepository.salvar(usuario)
                                    navController.navigate("login")
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .size(width = 118.dp, height = 40.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF459945))
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