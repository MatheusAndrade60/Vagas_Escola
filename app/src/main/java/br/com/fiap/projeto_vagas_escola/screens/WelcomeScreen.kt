package br.com.fiap.projeto_vagas_escola.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto_vagas_escola.R
import br.com.fiap.projeto_vagas_escola.component.Header

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            //Medoto que ira retornar um layout para o Header
            Header()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (150).dp),
                    colors = CardDefaults.cardColors(Color.Gray),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(modifier = Modifier.padding(
                        vertical = 16.dp,
                        horizontal = 32.dp
                    )
                    ) {
                        Text(
                            text = "Seja Bem-vindo(a)",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(22.dp))
                        Button(
                            onClick = {navController.navigate("login")},
                            modifier = Modifier
                                .size(105.dp, 45.dp)
                                .align(Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        )
                        {
                            Text(
                                text = "INICIAR",
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun WelcomePreview() {
//    Welcome()
//}