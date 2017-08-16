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
import com.meli.pdesire.yandereservice.framework.YanderePackageManager
import com.meli.pdesire.yandereservice.framework.YandereRootUtility

class AudioSettingsFragment : PreferenceFragment() {



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_general)
        setHasOptionsMenu(true)

        val isV4AInstalled = YanderePackageManager.isAppInstalled("com.audlabs.viperfx", activity)

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
                YandereRootUtility.mount_rw_rootfs()
                YandereRootUtility.mount_rw_system()
                YandereRootUtility.sudo("cp /system/Yuno/stock/srs_processing.cfg /system/etc/srs")
                YandereRootUtility.mount_ro_rootfs()
                YandereRootUtility.mount_ro_system()
                YandereRootUtility.security_harden()

            } else {
                YandereRootUtility.mount_rw_rootfs()
                YandereRootUtility.mount_rw_system()
                YandereRootUtility.sudo("cp /system/Yuno/heavybass/srs_processing.cfg /system/etc/srs")
                YandereRootUtility.mount_ro_rootfs()
                YandereRootUtility.mount_ro_system()
                YandereRootUtility.security_harden()
            }
            true
        }


        val reboot = findPreference("reboot_click")

        reboot.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            YandereRootUtility.sudo("reboot")

            false
        }
    }
}