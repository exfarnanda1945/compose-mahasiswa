package com.exfarnanda1945.composemahasiswa.presentation.detail

import com.exfarnanda1945.composemahasiswa.data.model.Lecturer
import com.exfarnanda1945.composemahasiswa.data.model.Student

data class DetailScreenState(
    val lecturer: Lecturer = Lecturer("",""),
    val students:List<Student> = listOf()
)
