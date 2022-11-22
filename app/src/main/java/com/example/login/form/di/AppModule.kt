package com.example.login.form.di

import android.content.Context
import androidx.room.Room
import com.example.login.form.db.CharacterDao
import com.example.login.form.db.CharacterDb
import com.example.login.form.db.CharacterRepository
import com.example.login.form.db.ICharacterRepository
import com.example.utils.Constants.Companion.CHARACTER_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCharacterDb(//доступ к базе данных
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        CharacterDb::class.java,
        CHARACTER_TABLE
    ).build()
    @Provides
    fun provideCharacterDao(
        characterDb: CharacterDb
    ) = characterDb.characterDao()
    @Provides
    fun provideCharacterRepository(//доступ к репозиторию с данными
        characterDao: CharacterDao
    ): ICharacterRepository = CharacterRepository(
        characterDao = characterDao
    )
}
