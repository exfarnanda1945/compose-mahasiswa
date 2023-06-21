package com.exfarnanda1945.composemahasiswa.data.local_source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.composemahasiswa.utils.Constant


@Entity(
    tableName = Constant.STUDENT_TABLE_NAME,
    indices = [Index(value = ["nim"], unique = true)],
    foreignKeys = [ForeignKey(
        CourseEntity::class,
        parentColumns = ["id"],
        childColumns = ["matakuliah_id"]
    )]
)
data class StudentEntity(
    @PrimaryKey
    val nim: String,
    @ColumnInfo("nama")
    val name:String,
    @ColumnInfo("matakuliah_id")
    val courseId:Int
)