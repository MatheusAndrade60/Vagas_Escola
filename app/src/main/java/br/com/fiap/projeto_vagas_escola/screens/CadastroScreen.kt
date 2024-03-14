package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.R

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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(color = Color.Gray)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Vagas De Matricula",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            //Card para cadastrar um usuario
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (50).dp),
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
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )

                        //Aqui esta sendo utilizado um metodo que cria um OutlinedTextField
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(titulo = "Nome do Responsavel")

                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(titulo = "CPF")

                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(titulo = "CEP")

                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(titulo = "Email")

                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(titulo = "Senha")

                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {navController.navigate("login")},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "FINALIZAR")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OutlinedTextField(titulo : String) {
    val titulo by remember {
        mutableStateOf(titulo)
    }
    var guarda_digito by remember {
        mutableStateOf("")
    }

    Text(
        text = titulo,
        modifier = Modifier.padding(bottom = 8.dp),
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
    OutlinedTextField(
        value = guarda_digito,
        onValueChange = {
            guarda_digito = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 48.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorResource(id = R.color.gray),
            focusedBorderColor = colorResource(id = R.color.black)
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}

@Preview
@Composable
private fun OutlinedTextFieldPreview() {
    //OutlinedTextField()
}