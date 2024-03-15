package br.com.fiap.projeto_vagas_escola.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projeto_vagas_escola.R

@Composable
fun TextField(titulo: String, nome_variavel: String, tipo_teclado: KeyboardType) {
    val titulo by remember {
        mutableStateOf(titulo)
    }
    var nome_variavel by remember {
        mutableStateOf("")
    }

    Text(
        text = titulo,
        modifier = Modifier.padding(bottom = 8.dp),
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
    OutlinedTextField(
        value = nome_variavel,
        onValueChange = {
            /*
            Seria interessante limitar o tamanho da senha, mas para isso, temos que arrumar
            essa parte onde cada TextField vai ter um nome de variavel diferente para que possa
            ser usada a variavel
               if (nome_variavel == "senha"){
                    if(it.length <= 8){
                        nome_variavel = it
                    }
                }
             */
            nome_variavel = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 48.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorResource(id = R.color.gray),
            focusedBorderColor = colorResource(id = R.color.black)
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = tipo_teclado),
    )
}