package com.exfarnanda1945.composemahasiswa.di

import android.content.Context
import androidx.room.Room
import com.exfarnanda1945.composemahasiswa.data.local_source.StudentDatabase
import com.exfarnanda1945.composemahasiswa.utils.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, StudentDatabase::class.java, DATABASE_NAME)
            .createFromAsset("database/mahasiswa.db")
            .build()

    @Singleton
    @Provides
    fun provideDao(database: StudentDatabase) = database.dao
}