package com.exfarnanda1945.composemahasiswa.data.local_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.LecturerEntity
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.StudentEntity
import com.exfarnanda1945.composemahasiswa.data.local_source.entity.CourseEntity

@Database(
    entities = [LecturerEntity::class, CourseEntity::class, StudentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class StudentDatabase:RoomDatabase() {
    abstract val dao: StudentDao
}