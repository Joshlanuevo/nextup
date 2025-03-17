package com.vancoding.nextup.ui.screens.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    label: String,
    onPasswordChange: (String) -> Unit,
    onTrailingIconClick: () -> Unit,
    hidePassword: Boolean,
) {
    val trailingIcon = if (hidePassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
    val visualTransformation = if (hidePassword) PasswordVisualTransformation() else VisualTransformation.None

    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = onPasswordChange,
        label = label,
        leadingIcon = Icons.Filled.Lock,
        trailingIcon = trailingIcon,
        onTrailingIconClick = onTrailingIconClick,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation,
    )
}