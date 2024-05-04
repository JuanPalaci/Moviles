package com.jcstres.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(viewModel: TodoViewModel){
    val todoList by viewModel.todolist.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }
    var inputTextD by remember {
        mutableStateOf("")
    }
    val datepicked = remember { mutableStateOf(LocalDate.now())}
    val isOpen = remember { mutableStateOf(false)}


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.25f)
                ,value = inputText , onValueChange = {
                    inputText = it
                },
                label = { Text("Title") })
            Button(onClick = {
                viewModel.addTodo(inputText,datepicked.value.toString(),inputTextD)
                inputText = ""
                inputTextD = ""
            }) {
                Text(text = "Add")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(modifier = Modifier
                .padding(5.dp),
                readOnly = true,
                value = datepicked.value.format(DateTimeFormatter.ISO_DATE),
                label = { Text("Date") },
                onValueChange = {})
            IconButton(
                onClick = {isOpen.value = true }
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_edit_calendar_24), contentDescription = "Delete",
                    tint = Color.Black)
            }
            if (isOpen.value) {
                CustomDatePickerDialog(
                    onAccept = {
                        isOpen.value = false // close dialog
                        if (it != null) { // Set the date
                            datepicked.value = Instant
                                .ofEpochMilli(it)
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDate()
                        }
                    },
                    onCancel = {
                        isOpen.value = false //close dialog
                    }
                )
            }
        }
        OutlinedTextField(modifier = Modifier
            .padding(5.dp)
            ,value = inputTextD ,  onValueChange = {
                        inputTextD = it
            },
                    label = { Text("Description") }
        )

        todoList?.let{
            LazyColumn {
                itemsIndexed(it){
                        index: Int, item: Todo ->
                    TodoItem(item = item, onDelete = {
                        viewModel.deleteTodo(item.title)
                    }, onEdit = { newTitle, newDescription ->
                        viewModel.editTodoTitle(item.title, newTitle)
                        viewModel.editTodoDescription(item.title, newDescription)
                    }
                        )
                }
            }
        }?: Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
            ,text = "No items yet")

    }
}

@Composable
//ese onDelete sirve para pasar como parametro el ViewModel y simplificarme la existencia
fun TodoItem(item: Todo, onDelete: ()-> Unit,onEdit: (String, String)-> Unit ) {
    var showDialog by remember { mutableStateOf(false) }
    var newTitle by remember { mutableStateOf(item.title) }
    var newDescription by remember { mutableStateOf(item.description) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Editar Tarea") },
            text = {
                Column {
                    OutlinedTextField(
                        value = newTitle,
                        onValueChange = { newTitle = it },
                        label = { Text("Nuevo título") },


                    )
                    OutlinedTextField(
                        value = newDescription,
                        onValueChange = { newDescription = it },
                        label = { Text("Nueva descripción") }
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    onEdit(newTitle, newDescription)
                    showDialog = false
                }) {
                    Text("Confirmar")

                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")

                }
            }
        )
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFAEFFF6))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .weight(1f)

        ) {
            Text(text = item.date,
                fontSize = 12.sp,
                color = Color.Blue
                )
            Text(text = item.title,
                fontSize = 20.sp,
                color = Color.Black)
            Text(text = item.description,
                fontSize = 20.sp,
                color = Color.Black)
        }
        IconButton(onClick =  onDelete ) {
            Icon(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "Delete",
                tint = Color.Black)
        }
        IconButton(onClick = {showDialog = true}){
                Icon(painter = painterResource(id = R.drawable.baseline_border_color_24), contentDescription = "edit")
        }
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePickerDialog(
    onAccept: (Long?) -> Unit,
    onCancel: () -> Unit
) {
    val state = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = { },
        confirmButton = {
            Button(onClick = { onAccept(state.selectedDateMillis) }) {
                Text("Accept")
            }
        },
        dismissButton = {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = state)
    }
}
