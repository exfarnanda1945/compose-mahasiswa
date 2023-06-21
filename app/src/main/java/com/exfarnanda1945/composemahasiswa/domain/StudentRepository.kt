package com.exfarnanda1945.composemahasiswa.domain

import android.util.Log
import com.exfarnanda1945.composemahasiswa.data.IStudentRepository
import com.exfarnanda1945.composemahasiswa.data.local_source.StudentDao
import com.exfarnanda1945.composemahasiswa.data.model.Lecturer
import com.exfarnanda1945.composemahasiswa.data.model.Student
import com.exfarnanda1945.composemahasiswa.data.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class StudentRepository @Inject constructor(
    private val dao: StudentDao
) : IStudentRepository {
    override fun courseList(): Flow<List<Course>> = dao.courseList().transform { value ->
        val valueTransform: List<Course> = value.map {
            Course(it.id, it.name, it.lecturerId)
        }
        emit(valueTransform)
    }.catch {
        it.printStackTrace()
        Log.d("ERROR", it.localizedMessage!!)
    }.flowOn(Dispatchers.IO)

    override fun getLecturerById(lecturerId: String): Lecturer {
        val lecturer = dao.getLecturerById(lecturerId)
        return Lecturer(
            lecturer.nid, lecturer.name
        )
    }

    override fun getStudentByCourseId(nim: String, name: String, courseId: Int): List<Student> =
        dao.getStudentByCourseId(nim, name, courseId).map {
            Student(
                it.name, it.nim
            )
        }

}