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
            RootUtility.mount_rw_rootfs()
            RootUtility.mount_rw_system()
            RootUtility.sudo("cp /system/Yuno/Engines/Yume/Final/etc/audio_effects.conf /system/etc")
            RootUtility.sudo("cp /system/Yuno/Engines/Yume/Final/vendor/audio_effects.conf /system/etc")
            RootUtility.mount_ro_rootfs()
            RootUtility.mount_ro_system()
            RootUtility.security_harden()

            false
        }

        meli.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            RootUtility.mount_rw_rootfs()
            RootUtility.mount_rw_system()
            RootUtility.sudo("cp /system/Yuno/Engines/Meli/etc/audio_effects.conf /system/etc")
            RootUtility.sudo("cp /system/Yuno/Engines/Meli/vendor/audio_effects.conf /system/etc")
            RootUtility.mount_ro_rootfs()
            RootUtility.mount_ro_system()
            RootUtility.security_harden()

            false
        }

        RootUtility.security_harden()
    }
}
