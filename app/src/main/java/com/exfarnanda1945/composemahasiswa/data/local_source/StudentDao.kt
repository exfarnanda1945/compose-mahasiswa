package com.exfarnanda1945.composemahasiswa.data.local_source

import androidx.room.Dao
import androidx.room.Query
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.CourseEntity
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.LecturerEntity
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.StudentEntity
import com.exfarnanda1945.composemahasiswa.utils.Constant
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query("SELECT * FROM ${Constant.COURSE_TABLE_NAME} ORDER BY id")
    fun courseList(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM ${Constant.LECTURER_TABLE_NAME} WHERE nid = :lecturerId")
    fun getLecturerById(lecturerId: String): LecturerEntity

    @Query("SELECT * FROM ${Constant.STUDENT_TABLE_NAME} where nim LIKE :nim and nama LIKE :name AND matakuliah_id = :courseId")
    fun getStudentByCourseId(nim: String, name: String, courseId: Int): List<StudentEntity>

}