package com.jcstres.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todolist = MutableLiveData<List<Todo>>()
    val todolist : LiveData<List<Todo>> = _todolist


    fun getAllTodo(){
        _todolist.value = TodoManager.getAllTodo().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String, date: String, description: String){
        TodoManager.addTodo(title,date,description)
        getAllTodo()
    }

    fun deleteTodo(id: String){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }

    fun editTodoTitle(id: String,newTitle: String){
        TodoManager.editTitle(id,newTitle)
        getAllTodo()
    }
    fun editTodoDescription(id: String,newDescription: String){
        TodoManager.editDescription(id,newDescription)
        getAllTodo()
    }

}