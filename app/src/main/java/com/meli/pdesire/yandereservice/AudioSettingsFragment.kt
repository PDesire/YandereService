package com.meli.pdesire.yandereservice

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

        val isV4AInstalled = isAppInstalled("com.audlabs.viperfx")

        val screen = preferenceScreen
        val v4a = findPreference("v4a") as PreferenceScreen

        if (!isV4AInstalled) {
            screen.removePreference(v4a)
        }

        val heavybass = findPreference("heavybass_switch")

        heavybass.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                RootUtility.mount_rw_rootfs()
                RootUtility.mount_rw_system()
                RootUtility.sudo("cp /system/Yuno/stock/srs_processing.cfg /system/etc/srs")
                RootUtility.mount_ro_rootfs()
                RootUtility.mount_ro_system()
                RootUtility.security_harden()

            } else {
                RootUtility.mount_rw_rootfs()
                RootUtility.mount_rw_system()
                RootUtility.sudo("cp /system/Yuno/heavybass/srs_processing.cfg /system/etc/srs")
                RootUtility.mount_ro_rootfs()
                RootUtility.mount_ro_system()
                RootUtility.security_harden()
            }
            true
        }


        val reboot = findPreference("reboot_click")

        reboot.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            RootUtility.sudo("reboot")

            false
        }
    }
}