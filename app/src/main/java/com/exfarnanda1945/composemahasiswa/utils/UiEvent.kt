package com.exfarnanda1945.composemahasiswa.utils

import com.exfarnanda1945.composemahasiswa.data.model.Course

sealed class UiEvent{
    data class NavigateToDetail(val course:Course):UiEvent()
    object OnBack:UiEvent()
}
