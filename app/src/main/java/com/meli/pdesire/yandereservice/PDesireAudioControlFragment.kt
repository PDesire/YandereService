package com.meli.pdesire.yandereservice

/**
 * Created by PDesire on 20.05.2017.
 */

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import android.widget.Toast
import java.io.File

class PDesireAudioControlFragment : PreferenceFragment() {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_pdesireaudio_control)
        setHasOptionsMenu(true)

        val pdesireaudio_wcd9330 = File("/sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")

        if (!pdesireaudio_wcd9330.exists()) {
            Toast.makeText(getActivity(), "PDesireAudio not found on Kernel",
                    Toast.LENGTH_LONG).show();
        }

        val pdesireaudio_uhqa = findPreference("pdesireaudio_uhqa_switch")

        pdesireaudio_uhqa.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched)
                RootUtility.sudo("su -c echo 1 /sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")
            else
                RootUtility.sudo("su -c echo 0 /sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")

            true
        }


        val pdesireaudio_static = findPreference("pdesireaudio_static_switch")

        pdesireaudio_static.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched)
                RootUtility.sudo("su -c echo 1 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode")
            else
                RootUtility.sudo("su -c echo 0 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode")

            true
        }
    }
}