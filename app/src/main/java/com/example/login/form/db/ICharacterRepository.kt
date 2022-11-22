package com.example.login.form.db

import com.example.login.form.data.Character
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {
    fun getCharactersFromRoom(): Flow<List<Character>>
    fun getCharacterFromRoom(id: Int): Flow<Character>
    fun addCharacterToRoom(character: Character)
    fun addCharacterListToRoom(characters: List<Character>)
    fun updateCharacterInRoom(character: Character)
    fun deleteCharacterFromRoom(character: Character)
}