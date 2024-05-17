package com.example.matches.di

import android.content.Context
import androidx.room.Room
import com.example.matches.data.local.FavouriteDao
import com.example.matches.data.local.FavouriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    const val databaseName = "favourites"
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FavouriteDatabase {
        return Room.databaseBuilder(context, FavouriteDatabase::class.java, databaseName).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: FavouriteDatabase) : FavouriteDao {
        return database.favouritesDao()
    }
}