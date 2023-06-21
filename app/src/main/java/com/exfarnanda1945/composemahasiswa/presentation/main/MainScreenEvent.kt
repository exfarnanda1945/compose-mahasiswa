package com.exfarnanda1945.composemahasiswa.presentation.main

import com.exfarnanda1945.composemahasiswa.data.model.Course

sealed class MainScreenEvent {
    data class OnItemClick(val course: Course) : MainScreenEvent()
}