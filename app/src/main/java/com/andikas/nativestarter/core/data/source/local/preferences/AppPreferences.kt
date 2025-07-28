package com.andikas.nativestarter.core.data.source.local.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.andikas.nativestarter.BuildConfig
import javax.inject.Inject

class AppPreferences @Inject constructor(val context: Context) {
    companion object {
        const val PREFS = "${BuildConfig.APPLICATION_ID}.prefs"
    }


    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val prefs: SharedPreferences =
        EncryptedSharedPreferences.create(
            PREFS,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
}