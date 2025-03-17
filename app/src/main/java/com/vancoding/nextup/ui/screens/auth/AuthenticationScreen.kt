package com.vancoding.nextup.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vancoding.nextup.ui.screens.auth.components.EmailTextField
import com.vancoding.nextup.ui.screens.auth.components.PasswordTextField
import com.vancoding.nextup.ui.screens.auth.components.UsernameTextField

@Composable
fun AuthenticationScreen(
    isSignInScreen: Boolean,
    onSignUpClick: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var hidePassword by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 140.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "NextUp",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Stay ahead with NextUp.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }

        // Authentication Form (Sign In / Sign Up)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if (!isSignInScreen) {
                UsernameTextField(
                    modifier = Modifier.fillMaxWidth(),
                    username = username,
                    onUsernameChange = { username = it },
                    label = "Username",
                )
            }
            EmailTextField(
                modifier = Modifier.fillMaxWidth(),
                email = email,
                onEmailChange = { email = it },
                label = "Email",
            )
            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                password = password,
                onPasswordChange = { password = it },
                onTrailingIconClick = { hidePassword = !hidePassword },
                hidePassword = hidePassword,
                label = "Password",
            )
            Button(
                onClick = {
                    if (isSignInScreen) {
                        // Handle Sign In logic
                    } else {
                        // Handle Sign Up logic
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = if (isSignInScreen) "Sign In" else "Sign Up")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = if (isSignInScreen) "Don't have an account yet?" else "Already have an account?",
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
                TextButton(
                    onClick = {
                        onSignUpClick()
                    }
                ) {
                    Text(
                        text = if (isSignInScreen) "Sign Up" else "Sign In",
                        color = Color(0xFF03A9F4)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}