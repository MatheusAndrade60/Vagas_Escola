package br.com.fiap.projeto_vagas_escola

import br.com.fiap.projeto_vagas_escola.screens.SchoolListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.projeto_vagas_escola.database.repository.UsuarioRepository
import br.com.fiap.projeto_vagas_escola.screens.HomeScreen
import br.com.fiap.projeto_vagas_escola.screens.CadastroScreen
import br.com.fiap.projeto_vagas_escola.screens.LoginScreen
import br.com.fiap.projeto_vagas_escola.screens.WelcomeScreen
import br.com.fiap.projeto_vagas_escola.ui.theme.ProjetoVagas_EscolaTheme

class MainActivity : ComponentActivity() {
    private lateinit var usuarioRepository: UsuarioRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoVagas_EscolaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    usuarioRepository = UsuarioRepository(context = this@MainActivity)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable(route = "welcome") {
                            WelcomeScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController, usuarioRepository)
                        }
                        composable(route = "cadastro") {
                            CadastroScreen(navController)
                        }
                        composable(route = "home") {
                            HomeScreen(navController)
                        }
                        composable(route = "school") {
                            SchoolListScreen(navController, Unit)
                        }
                    }
                }
            }
        }
    }
}

