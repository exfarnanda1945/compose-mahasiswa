package com.exfarnanda1945.composemahasiswa.data.local_source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.composemahasiswa.utils.Constant

@Entity(
    tableName = Constant.COURSE_TABLE_NAME,
    indices = [Index(value = ["dosen_id"], unique = true)],
    foreignKeys = [ForeignKey(
        LecturerEntity::class,
        parentColumns = ["nid"],
        childColumns = ["dosen_id"]
    )]
)
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo("nama")
    val name:String,
    @ColumnInfo("dosen_id")
    val lecturerId:String,


)
