package br.com.fiap.projeto_vagas_escola.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                Header()
            }

            item {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = "Digite aqui o endereço da escola desejada:",
                                fontSize = 14.sp,
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(onClick = { /* Ação de clique do ícone */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Pesquisar"
                                )
                            }
                        }
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.escola),
                        contentDescription = "mapa",
                        modifier = Modifier
                            .size(500.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = {navController.navigate("school")},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF58B958)),
                            modifier = Modifier.weight(1f), // Use weight para ocupar o espaço restante na linha
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row {
//                                Image(// TENTEI INSERIR ESSE ICONE MAS NÃO FICOU LEGAL
//                                    painter = painterResource(id = R.drawable.escolaicon),
//                                    contentDescription = null,
//                                    modifier = Modifier.size(24.dp) // Defina o tamanho da imagem conforme necessário
//                                )
                                Spacer(modifier = Modifier.width(8.dp)) // Adicione um espaçamento entre a imagem e o texto
                                Text(text = "Pesquisar escolas próximas")
                            }
                        }
                    }
                }
            }
        }
    }
}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}
