package com.exfarnanda1945.composemahasiswa.data.local_source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.composemahasiswa.utils.Constant

@Entity(
    tableName = Constant.LECTURER_TABLE_NAME,
    indices = [Index(value = ["nid"], unique = true)]
)
data class LecturerEntity(
    @PrimaryKey
    val nid: String,
    @ColumnInfo("nama")
    val name:String
)
