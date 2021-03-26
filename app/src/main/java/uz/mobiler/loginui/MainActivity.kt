package uz.mobiler.loginui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import uz.mobiler.loginui.composables.LoginPage
import uz.mobiler.loginui.composables.RegisterPage
import uz.mobiler.loginui.ui.theme.LoginUITheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            LoginUITheme {
                LoginApplication()
            }
        }
    }

    @Composable
    fun LoginApplication() {
        LoginPage()
//        val navController = rememberNavController()
//        NavHost(navController = navController, startDestination = "login_page", builder = {
//            composable("login_page", content = { LoginPage(navController = navController) })
//            composable("register_page", content = { RegisterPage(navController = navController) })
//        })
    }
}
