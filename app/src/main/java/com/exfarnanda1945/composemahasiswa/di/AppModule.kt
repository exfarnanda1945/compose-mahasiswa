package com.exfarnanda1945.composemahasiswa.di

import com.exfarnanda1945.composemahasiswa.data.IStudentRepository
import com.exfarnanda1945.composemahasiswa.data.local_source.StudentDao
import com.exfarnanda1945.composemahasiswa.domain.StudentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStudentRepository(dao: StudentDao): IStudentRepository =
        StudentRepository(dao)
}