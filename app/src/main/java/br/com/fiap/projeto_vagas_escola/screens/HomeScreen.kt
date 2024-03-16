package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                Header()
            }

            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ){
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = "Digite aqui o endereço da escola desejada:",
                                fontSize = 14.sp
                            )
                        },
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.escola),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(500.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Arthur Morgan")
                    Text(text = "Dutch")
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
