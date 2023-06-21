package com.exfarnanda1945.composemahasiswa.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.composemahasiswa.data.IStudentRepository
import com.exfarnanda1945.composemahasiswa.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: IStudentRepository
) : ViewModel() {

    var detailScreenState by mutableStateOf(DetailScreenState())
    var searchState by mutableStateOf(SearchStudentState())

    private var _detailChannel = Channel<UiEvent>()
    val detailChannel = _detailChannel.receiveAsFlow()


    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.OnFind -> getLecturerAndStudent(event.lectureId, event.courseId)
            is DetailScreenEvent.OnSearchNameChange -> {
                searchState = searchState.copy(name = event.name)
            }

            is DetailScreenEvent.OnSearchNimChange -> {
                searchState = searchState.copy(nim = event.nim)
            }
            DetailScreenEvent.PopBackStack -> sendUiEvent(UiEvent.OnBack)
        }
    }


    fun getLecturerAndStudent(lecturerId: String, courseId: Int) {

        val lecturerDeferred = viewModelScope.async(Dispatchers.IO) {
            repository.getLecturerById(lecturerId)
        }

        val studentDeferred = viewModelScope.async(Dispatchers.IO) {
            repository.getStudentByCourseId(
                "%${searchState.nim}%",
                "%${searchState.name}%",
                courseId
            )
        }


        viewModelScope.launch {
            val student = studentDeferred.await()
            val lecturer = lecturerDeferred.await()
            detailScreenState = detailScreenState.copy(
                lecturer = lecturer,
                students = student
            )
        }
    }

    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch {
            _detailChannel.send(uiEvent)
        }
    }


}