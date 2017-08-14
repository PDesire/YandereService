package com.meli.pdesire.yandereservice

/**
 * Created by PDesire on 20.05.2017.
 */

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment

class EngineFragment : PreferenceFragment() {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_engines)
        setHasOptionsMenu(true)

        val yume = findPreference("Yume")
        val meli = findPreference("Meli")


        yume.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            RootUtility.sudo("su -c sh /system/Desire/Shells/Engines/Yume/Final/Final.sh")

            false
        }

        meli.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            RootUtility.sudo("su -c sh /system/Desire/Shells/Rage_Enable.sh")

            false
        }
    }
}
