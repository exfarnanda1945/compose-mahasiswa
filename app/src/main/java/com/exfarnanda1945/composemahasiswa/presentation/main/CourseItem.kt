package com.exfarnanda1945.composemahasiswa.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exfarnanda1945.composemahasiswa.data.model.Course

@Composable
fun CourseItem(
    course: Course,
    onClick: (course: Course) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .shadow(4.dp)
            .clickable {
                onClick(course)
            },
    ) {
        Text(
            course.name, style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            ), modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
        )
    }
}
