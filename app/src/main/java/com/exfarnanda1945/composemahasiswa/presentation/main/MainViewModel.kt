package com.exfarnanda1945.composemahasiswa.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.composemahasiswa.data.IStudentRepository
import com.exfarnanda1945.composemahasiswa.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: IStudentRepository
) : ViewModel() {
    val state = repository.courseList()
    private var _mainChannel = Channel<UiEvent>()
    val mainChannel = _mainChannel.receiveAsFlow()

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnItemClick -> sendUiEvent(UiEvent.NavigateToDetail(event.course))
        }
    }

    private fun sendUiEvent(uiEvent: UiEvent) {
        viewModelScope.launch {
            _mainChannel.send(uiEvent)
        }
    }

}