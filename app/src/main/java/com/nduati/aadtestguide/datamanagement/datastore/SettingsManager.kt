package com.nduati.aadtestguide.datamanagement.datastore

import android.content.Context
import androidx.datastore.createDataStore

class SettingsManager(context: Context) {
    private val dataStore = context.createDataStore(name = "settings_pref")
}