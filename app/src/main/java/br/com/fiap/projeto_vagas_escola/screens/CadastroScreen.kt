package br.com.fiap.projeto_vagas_escola.screens

import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.database.repository.UsuarioRepository
import br.com.fiap.projeto_vagas_escola.model.Endereco
import br.com.fiap.projeto_vagas_escola.model.Usuario
import br.com.fiap.projeto_vagas_escola.service.RetrofitFactory
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroScreen(navController: NavController) {
    var nome_responsavel by remember {
        mutableStateOf("")
    }
    var cpf_responsavel by remember {
        mutableStateOf("")
    }
    var cep by remember {
        mutableStateOf("")
    }
    var cepState by remember {
        mutableStateOf(Endereco())
    }
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }

    val canNavigate = nome_responsavel.isNotBlank() &&
            cpf_responsavel.isNotBlank() &&
            cep.isNotBlank() &&
            email.isNotBlank() &&
            senha.isNotBlank()

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
            item() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 50.dp)
                ) {
                    val context = LocalContext.current
                    val usuarioRepository = UsuarioRepository(context)

                    Card(
                        modifier = Modifier
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
                                value = nome_responsavel,
                                onValueChange = {
                                    nome_responsavel = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
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
                                value = cpf_responsavel,
                                onValueChange = {
                                    if(it.length <= 11){
                                        cpf_responsavel = it
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )
                            Text(
                                text = "Somente números. Ex:00000011111",
                                modifier = Modifier
                                    .padding(start = 20.dp),
                                fontSize = 11.sp,
                                color = Color.Gray
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
                                    if(it.length <= 8){
                                        cep = it
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        val call = RetrofitFactory().getCepService().getEnderecoByCep(cep = cep)
                                        call.enqueue(object : Callback<Endereco>{
                                            override fun onResponse(
                                                call: Call<Endereco>,
                                                response: Response<Endereco>
                                            ){
                                                cepState = response.body()!!
                                            }
                                            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                                                Log.i("API", "onResponse: ${t.message}")
                                            }
                                        })
                                    }) {
                                        Icon(imageVector = Icons.Default.Search, contentDescription = "icon_search")
                                    }
                                }
                            )
                            Text(
                                text = "Somente números. Ex:00001111",
                                modifier = Modifier
                                    .padding(start = 20.dp),
                                fontSize = 11.sp,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Rua",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cepState.rua,
                                onValueChange = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Cidade",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cepState.cidade,
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Bairro",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cepState.bairro,
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "UF",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                            OutlinedTextField(
                                value = cepState.uf,
                                onValueChange = {
                                    if(it.length <= 2){
                                        cep = it
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
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
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
                                    if(it.length <= 6){
                                        senha = it
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = 50.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.gray),
                                    focusedBorderColor = colorResource(id = R.color.black)
                                ),
                                shape = RoundedCornerShape(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )
                            Text(
                                text = "No máximo 6 números",
                                modifier = Modifier
                                    .padding(start = 20.dp),
                                fontSize = 11.sp,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                            //Ao clicar no botao sera criado um novo usuario e logo em seguida ir mudar para a proxima tela
                            Button(
                                onClick = {
                                   val usuario = Usuario(
                                        id_usuario = 0,
                                        nome_responsavel = nome_responsavel,
                                        cpf_responsavel = cpf_responsavel,
                                        cep = cep,
                                        rua = cepState.rua,
                                        cidade = cepState.cidade,
                                        bairro = cepState.bairro,
                                        uf = cepState.uf,
                                        email = email,
                                        senha = senha
                                   )
                                    usuarioRepository.salvar(usuario)
                                    navController.navigate("login")
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .size(width = 118.dp, height = 40.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF459945)),
                                enabled = canNavigate
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