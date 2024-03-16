package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.Image
import androidx.compose.ui.tooling.preview.Preview
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header

@Composable
fun HomeScreen() {

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
                ){
                    Card(modifier = Modifier
                        .fillMaxWidth(),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
                    {
                        Text(text = "  Digite aqui o endereço da escola desejada:",
                            fontSize = 14.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Image(
                        painter = painterResource(id = R.drawable.escola),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(500.dp)
                            .padding(top = 16.dp)
                    )
                        }
                    }
                }
            }
        }


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
