package com.exfarnanda1945.composemahasiswa.presentation.detail

sealed class DetailScreenEvent{
    data class OnSearchNameChange(val name:String):DetailScreenEvent()
    data class OnSearchNimChange(val nim:String):DetailScreenEvent()
    data class OnFind(val lectureId:String,val courseId:Int):DetailScreenEvent()
    object PopBackStack:DetailScreenEvent()
}
