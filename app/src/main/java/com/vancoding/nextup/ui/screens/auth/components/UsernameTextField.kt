package com.vancoding.nextup.ui.screens.auth.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UsernameTextField(
    modifier: Modifier = Modifier,
    username: String,
    label: String = "Username",
    onUsernameChange: (String) -> Unit,
) {
    CustomTextField(
        modifier = modifier,
        value = username,
        onValueChange = onUsernameChange,
        label = label,
        leadingIcon = Icons.Filled.Person,
    )
}