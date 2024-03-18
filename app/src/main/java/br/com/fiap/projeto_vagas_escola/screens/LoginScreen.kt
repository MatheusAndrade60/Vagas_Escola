package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header
import br.com.fiap.projeto_vagas_escola.database.repository.UsuarioRepository

@Composable
fun LoginScreen(navController: NavController, usuarioRepository: UsuarioRepository){
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    var borderColor by remember {
        mutableStateOf(Color.Gray)
    }
    var
        errorText by remember {
        mutableStateOf("")
    }

    //Box inicial com logo e titulo
    Box(
        modifier = Modifier
            .fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
        ) {
            //Medoto que ira retornar um layout para o Header
            Header()

            //Card com o login do usuario
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
                    Column(
                        modifier = Modifier
                            .padding(
                                vertical = 16.dp,
                                horizontal = 32.dp
                            )
                    ) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "LOGIN",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )

                        //Aqui esta sendo utilizado um metodo que cria um OutlinedTextField
                        Spacer(modifier = Modifier.height(20.dp))
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
                                borderColor = Color.Gray
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 50.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = borderColor,
                                focusedBorderColor = Color.Black
                            ),
                            shape = RoundedCornerShape(30.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        )

                        Spacer(modifier = Modifier.height(15.dp))
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
                                if(it.length <= 6){
                                    senha = it
                                }
                                borderColor = Color.Gray
                                errorText = ""
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 50.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = borderColor,
                                focusedBorderColor = Color.Black
                            ),
                            shape = RoundedCornerShape(30.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                            visualTransformation = PasswordVisualTransformation()
                        )
                        //Mostra uma mensagem de erro caso email ou senha seja incorreto
                        Text(
                            text = errorText,
                            fontSize = 12.sp,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 3.dp)
                        )

                        //Botão que ir levar o usuario para a tela de cadastro
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Button(onClick = {
                                navController.navigate("cadastro")
                            },
                                modifier = Modifier
                                    .size(width = 129.dp, height = 31.dp),
                                colors = ButtonDefaults.buttonColors(Color.White),
                                shape = RectangleShape
                            ) {
                                Text(
                                    text = "Cadastrar-se",
                                    fontSize = 12.sp,
                                    color = Color.Black
                                )
                            }

                        }

                        //Botão que ir logar o usuario e levalo para a tela da utilização da API
                        Spacer(modifier = Modifier.height(2.dp))
                        Button(
                            onClick = {
                                if (usuarioRepository.validarCredenciais(email, senha)) {
                                    navController.navigate("home")
                                }else{
                                    borderColor = Color.Red
                                    errorText = "Email ou senha inválido"
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(width = 103.dp, height = 40.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF459945))
                        )
                        {
                            Text(
                                text = "ENTRAR",
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun LoginScreenPreview() {
//    LoginScreen()
//}