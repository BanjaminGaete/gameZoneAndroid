package com.example.gamezone.viewModel


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamezone.models.LoginModel

class LoginViewModel: ViewModel() {

    var loginViewModel by mutableStateOf(LoginModel("",""))
        private set


    fun cambioCorreo(nuevoCorreo:String){
        loginViewModel = loginViewModel.copy(correo = nuevoCorreo)
    }

    fun cambioContrasena(nuevaContrasena:String){
        loginViewModel = loginViewModel.copy(contrasena = nuevaContrasena)
    }


    //ALERTA CONFIRMACION
    var mostrarAlerta by mutableStateOf(false)
        private set
    var tituloAlerta by mutableStateOf("")
        private set
    var mensajeALerta by mutableStateOf("")
        private set
    var textoBotonAlerta by mutableStateOf("")
        private set

    fun descartarAlerta(){
        mostrarAlerta = false
    }

    //NAVEGACION
    var deberiamosNavegar by mutableStateOf(false)
        private set

    fun cambiarEstadoNavegacion(){
        deberiamosNavegar = false
    }


    // VARIABLES CONFIRMAR
    var mostrarConfirmar by mutableStateOf(false)
        private set
    var tituloConfirmar by mutableStateOf("")
        private set
    var mensajeConfirmar by mutableStateOf("")
        private set
    var textoBtnConfirmar by mutableStateOf("")
        private set
    var textoBtnCancelar by mutableStateOf("")
        private set


    fun btnAceptarConfirmar(){
        mostrarConfirmar = false
    }

    fun btnCancelarConfirmar(){
        mostrarConfirmar = false
    }

    fun terminarConfirmar(){
        mostrarConfirmar = false
    }








    fun auth(){
        Log.d("CORREO",loginViewModel.correo)
        Log.d("CONTRASEÑA",loginViewModel.contrasena)

        if(loginViewModel.correo == "1" && loginViewModel.contrasena == "1"){
            //navegar al inicio
            deberiamosNavegar = true

        }else if(loginViewModel.correo.isBlank() || loginViewModel.contrasena.isBlank()){
            //Error ---> alerta
            tituloAlerta = "Error de validación"
            mensajeALerta = "El correo y la contraseña no pueden estar vacíos."
            textoBotonAlerta = "Confrimar"
            //mostrarAlerta = true

            tituloConfirmar = "Confirmación"
            mensajeConfirmar = "Esta seguro que desea hacerlo?"
            textoBtnConfirmar = "Confirmar"
            textoBtnCancelar = "Cancelar"
            mostrarConfirmar = true
        }else{
            //Error  --> alerta
            tituloAlerta = "Error de credenciales"
            mensajeALerta = "El correo o la contraseña no corresponden."
            textoBotonAlerta = "Aceptar"
            mostrarAlerta = true
        }
    }


}