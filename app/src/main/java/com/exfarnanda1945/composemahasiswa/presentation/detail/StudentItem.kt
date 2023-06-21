package com.exfarnanda1945.composemahasiswa.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.exfarnanda1945.composemahasiswa.R
import com.exfarnanda1945.composemahasiswa.data.model.Student

@Composable
fun StudentItem(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(students.size) { index ->
            val student = students[index]
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .shadow(4.dp)) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = stringResource(R.string.student_id) + student.nim)
                    Text(text = stringResource(R.string.name) + student.name)
                }
            }
        }
    }
}