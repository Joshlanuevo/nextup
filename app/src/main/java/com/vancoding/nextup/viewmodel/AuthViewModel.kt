package com.vancoding.nextup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.nextup.data.repository.AuthRepository
import com.vancoding.nextup.utils.SignInState
import com.vancoding.nextup.utils.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
): ViewModel() {
    private val _signUpState = MutableStateFlow<SignUpState>(SignUpState.Default)
    val signUpState: StateFlow<SignUpState> get() = _signUpState

    private val _signInState = MutableStateFlow<SignInState>(SignInState.Default)
    val signInState: StateFlow<SignInState> get() = _signInState

    fun signUp(username: String, email: String, password: String) {
        viewModelScope.launch {
            _signUpState.value = SignUpState.Loading
            val result = authRepository.signUp(username, email, password)
            _signUpState.value = result.fold(
                onSuccess = { SignUpState.Success(it) },
                onFailure = { SignUpState.Failure(it.message ?: "An error occurred") }
            )
        }
    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _signInState.value = SignInState.Loading
            val result = authRepository.signIn(email, password)
            _signInState.value = result.fold(
                onSuccess = { SignInState.Success(it) },
                onFailure = { SignInState.Failure(it.message ?: "An error occurred") }
            )
        }
    }
}