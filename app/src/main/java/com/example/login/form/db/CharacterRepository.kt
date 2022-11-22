package com.example.login.form.db

import com.example.login.form.data.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterDao: CharacterDao) : ICharacterRepository {
    override fun getCharactersFromRoom() = characterDao.getCharacters()
    override fun getCharacterFromRoom(id: Int) = characterDao.getCharacter(id)
    override fun addCharacterToRoom(character: Character) = characterDao.addCharacter(character)
    override fun addCharacterListToRoom(characters: List<Character>) = characterDao.addCharacters(characters)
    override fun updateCharacterInRoom(character: Character) = characterDao.updateCharacter(character)
    override fun deleteCharacterFromRoom(character: Character) = characterDao.deleteCharacter(character)
}