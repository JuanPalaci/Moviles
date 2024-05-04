package com.jctres.stateexample


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


//para convertirlo en viewModel se necesita el :ViewModel
class StateTestViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname : LiveData<String> = _surname


    fun onNameUpdate(newName: String){
        _name.value = newName
    }

    fun onSurNameUpdate(newSurName: String){
        _surname.value = newSurName
    }
}