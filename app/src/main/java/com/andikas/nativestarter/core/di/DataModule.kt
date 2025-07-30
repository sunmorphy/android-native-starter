package com.andikas.nativestarter.core.di

import android.content.Context
import com.andikas.nativestarter.core.data.source.local.database.AppDatabase
import com.andikas.nativestarter.core.data.source.local.preferences.AppPreferences
import com.andikas.nativestarter.core.data.source.remote.network.Network
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences {
        return AppPreferences(context)
    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetwork(@ApplicationContext context: Context): Network {
        return Network(context)
    }
}