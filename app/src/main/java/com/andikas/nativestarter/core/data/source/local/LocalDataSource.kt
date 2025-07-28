package com.andikas.nativestarter.core.data.source.local

import com.andikas.nativestarter.core.data.source.local.database.AppDatabase
import com.andikas.nativestarter.core.data.source.local.preferences.AppPreferences
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val appDatabase: AppDatabase,
    private val appPreferences: AppPreferences
) {

}