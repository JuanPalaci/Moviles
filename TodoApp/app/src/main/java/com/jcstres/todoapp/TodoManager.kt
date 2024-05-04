package com.jcstres.todoapp

import android.os.Build
import androidx.annotation.RequiresApi

object TodoManager {
    private val todoList = mutableListOf<Todo>()

    fun getAllTodo(): List<Todo>{
        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String,date: String,description: String){
        todoList.add(Todo(title, date,description))
    }

    fun deleteTodo(id: String){
        todoList.removeIf {
            it.title == id
        }
    }

    fun editTitle(id: String, newTitle: String){
        todoList.find{it.title == id}?.title = newTitle
    }

    fun editDescription(id: String, newDescription: String){
        todoList.find {it.title == id }?.description = newDescription
    }

}