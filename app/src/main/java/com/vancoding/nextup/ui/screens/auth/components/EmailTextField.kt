package com.vancoding.nextup.ui.screens.auth.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    label: String,
    onEmailChange: (String) -> Unit,
) {
    CustomTextField(
        modifier = modifier,
        value = email,
        onValueChange = onEmailChange,
        label = label,
        leadingIcon = Icons.Filled.Email,
    )
}