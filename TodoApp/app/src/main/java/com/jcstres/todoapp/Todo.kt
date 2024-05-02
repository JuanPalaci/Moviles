package com.jcstres.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

//data class sirven para las variables
data class Todo(
    var id: Int,
    var title: String,
    var cratedAt: Date
)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo() : List<Todo>{
    return listOf<Todo>(
        Todo(1,"First todo", Date.from(Instant.now())),
        Todo(2,"Second todo", Date.from(Instant.now())),
        Todo(3,"Third todo", Date.from(Instant.now())),
        Todo(4,"Fourth todo", Date.from(Instant.now())),
    );
}
