package com.example.login.form.db

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.login.form.data.Character
import com.example.utils.Constants.Companion.CHARACTER_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Query("SELECT * FROM $CHARACTER_TABLE ORDER BY id ASC")
    fun getCharacters(): Flow<List<Character>>
    @Query("SELECT * FROM $CHARACTER_TABLE WHERE id = :id")
    fun getCharacter(id: Int): Flow<Character>
    @Insert(onConflict = IGNORE)
    fun addCharacter(character: Character)
    @Insert(onConflict = IGNORE)
    fun addCharacters(character: List<Character>)
    @Update
    fun updateCharacter(character: Character)
    @Delete
    fun deleteCharacter(character: Character)
}
