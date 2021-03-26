package uz.mobiler.loginui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import uz.mobiler.loginui.R
import uz.mobiler.loginui.ui.theme.primaryColor
import uz.mobiler.loginui.ui.theme.whiteBackground

@Composable
fun LoginPage() {

    val image = imageResource(id = R.drawable.login_image)

    val emailValue = remember { mutableStateOf("") }
    val paswordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val focusRequester: FocusRequester = remember { FocusRequester() }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {

            Image(
                image, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(
                    RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp)
                )
                .background(whiteBackground)
                .padding(10.dp)
        ) {

            ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Sign in",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit.Companion.Sp(2)
                    ),
                    fontSize = TextUnit.Companion.Sp(30)
                )
                Spacer(modifier = Modifier.padding(20.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email address") },
                        placeholder = { Text(text = "Email address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = paswordValue.value,
                        onValueChange = { paswordValue.value = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = vectorResource(id = R.drawable.password_eye),
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Sign in", fontSize = TextUnit.Sp(20))
                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = "Create an account", modifier = Modifier.clickable(onClick = {
//                        navController.navigate("register_page") {
//                            popUpTo = navController.graph.startDestination
//                            launchSingleTop = true
//                        }
                    }))
                    Spacer(modifier = Modifier.padding(20.dp))

                }
            }

        }
    }
}