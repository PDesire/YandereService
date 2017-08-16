package com.meli.pdesire.yandereservice

/**
 * Created by PDesire on 20.05.2017.
 */

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import com.meli.pdesire.yandereservice.framework.YandereRootUtility

class EngineFragment : PreferenceFragment() {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_engines)
        setHasOptionsMenu(true)

        val yume = findPreference("Yume")
        val meli = findPreference("Meli")


        yume.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            YandereRootUtility.mount_rw_rootfs()
            YandereRootUtility.mount_rw_system()
            YandereRootUtility.sudo("cp /system/Yuno/Engines/Yume/Final/etc/audio_effects.conf /system/etc")
            YandereRootUtility.sudo("cp /system/Yuno/Engines/Yume/Final/vendor/audio_effects.conf /system/etc")
            YandereRootUtility.mount_ro_rootfs()
            YandereRootUtility.mount_ro_system()
            YandereRootUtility.security_harden()

            false
        }

        meli.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            YandereRootUtility.mount_rw_rootfs()
            YandereRootUtility.mount_rw_system()
            YandereRootUtility.sudo("cp /system/Yuno/Engines/Meli/etc/audio_effects.conf /system/etc")
            YandereRootUtility.sudo("cp /system/Yuno/Engines/Meli/vendor/audio_effects.conf /system/etc")
            YandereRootUtility.mount_ro_rootfs()
            YandereRootUtility.mount_ro_system()
            YandereRootUtility.security_harden()

            false
        }

        YandereRootUtility.security_harden()
    }
}
