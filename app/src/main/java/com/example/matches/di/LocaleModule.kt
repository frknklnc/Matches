package com.example.matches.di

import android.content.Context
import androidx.room.Room
import com.example.matches.data.model.locale.FavouritesDao
import com.example.matches.data.model.locale.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocaleModule {

    const val databaseName = "favourites"
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FavouritesDatabase{
        return Room.databaseBuilder(context, FavouritesDatabase::class.java, databaseName).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: FavouritesDatabase) : FavouritesDao {
        return database.favouritesDao()
    }
}