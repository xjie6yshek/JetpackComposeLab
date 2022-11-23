package com.example.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.form.api.RetrofitHelper
import com.example.login.form.data.Character
import com.example.login.form.db.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.Objects
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: CharacterRepository
):ViewModel() {
    var characterList:List<Character> by mutableStateOf(arrayListOf())

    var errorMessage: String by mutableStateOf("")

    var loading: Boolean by mutableStateOf(true)

    val characters = repo.getCharactersFromRoom()

//    fun getCharacters() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repo.getCharactersFromRoom().collect { response ->
//                characters = response
//            }
//        }
//    }

    fun requestCharacterList(){
        viewModelScope.launch(Dispatchers.IO) {
            loading = true
            val authService = RetrofitHelper.getAuthService()

            try {
                val response = authService.getCharacters()
                characterList = response
                loading = false
                errorMessage = ""
                repo.addCharacterListToRoom(response)
            }
            catch (e: Exception) {
                loading = false
                errorMessage = e.message.toString()
            }
        }
    }

    fun filterCharacterList(characterName: String): List<Character> {
        if (characterName == "") return arrayListOf()

//        characterList = characterList.filter {
//                character -> character.name.lowercase().contains(characterName.lowercase())
//        }

        return characterList.filter {
                character -> character.name.lowercase().contains(characterName.lowercase())
        }
    }
}
