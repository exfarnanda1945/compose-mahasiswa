package com.exfarnanda1945.composemahasiswa.data

import com.exfarnanda1945.composemahasiswa.data.model.Lecturer
import com.exfarnanda1945.composemahasiswa.data.model.Student
import com.exfarnanda1945.composemahasiswa.data.model.Course
import kotlinx.coroutines.flow.Flow

interface IStudentRepository {
    fun courseList(): Flow<List<Course>>
    fun getLecturerById(lecturerId:String):Lecturer
    fun getStudentByCourseId(nim:String,name:String,courseId:Int):List<Student>
}