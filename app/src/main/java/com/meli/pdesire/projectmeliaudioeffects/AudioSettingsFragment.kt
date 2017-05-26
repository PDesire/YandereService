package com.meli.pdesire.projectmeliaudioeffects

/**
 * Created by PDesire on 20.05.2017.
 */

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.preference.SwitchPreference

class AudioSettingsFragment : PreferenceFragment() {

    private fun isAppInstalled(uri: String): Boolean {
        val context = activity
        val pm = context.packageManager
        var installed: Boolean
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            installed = true
        } catch (e: PackageManager.NameNotFoundException) {
            installed = false
        }

        return installed
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_general)
        setHasOptionsMenu(true)

        val isAM3DInstalled = isAppInstalled("com.fihtdc.am3dfx")
        val isDolbyInstalled = isAppInstalled("com.dolby.ds1appUI")
        val isV4AInstalled = isAppInstalled("com.audlabs.viperfx")

        val screen = preferenceScreen
        val am3d = findPreference("am3d") as PreferenceScreen
        val dolby = findPreference("dolby") as PreferenceScreen
        val v4a = findPreference("v4a") as PreferenceScreen
        if (!isAM3DInstalled) {
            screen.removePreference(am3d)
        }

        if (!isDolbyInstalled) {
            screen.removePreference(dolby)
        }

        if (!isV4AInstalled) {
            screen.removePreference(v4a)
        }

        val heavybass = findPreference("heavybass_switch")

        heavybass.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched)
                RootUtility.sudo("sh /system/Desire/Shells/Heavybass_Enable.sh")

            else
                RootUtility.sudo("sh /system/Desire/Shells/Heavybass_Disable.sh")
            true
        }


        val reboot = findPreference("reboot_click")

        reboot.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            RootUtility.sudo("su -c reboot")

            false
        }
    }
}