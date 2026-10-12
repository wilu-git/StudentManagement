package com.undyingguild.studentmanagement.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query(value = "SELECT * FROM students ORDER BY name")
    fun getAllStudents(): Flow<List<Student>>

    @Insert
    suspend fun insertStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)


}
//ONce we use the function it will automatically call the query from the database no need to manual refresh
//Once nagkaroon ng insert (It will automatically put the flow)
//no suspend because the database is stil lsmall and want to introduce the topic
//1 table per 1 DAO