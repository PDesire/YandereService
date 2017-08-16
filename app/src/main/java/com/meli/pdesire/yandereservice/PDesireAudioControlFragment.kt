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
import com.meli.pdesire.yandereservice.framework.YandereRootUtility
import java.io.File

class PDesireAudioControlFragment : PreferenceFragment() {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_pdesireaudio_control)
        setHasOptionsMenu(true)

        val pdesireaudio_wcd9330 = File("/sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")
        val pdesireaudio_wcd9330_new_api = File("/sys/module/snd_soc_wcd9330/PDesireAudio")
        val pdesireaudio_wcd9320 = File("/sys/module/snd_soc_wcd9320/uhqa_mode_pdesireaudio")
        val pdesireaudio_wcd9320_new_api = File("/sys/module/snd_soc_wcd9320/PDesireAudio")

        if (pdesireaudio_wcd9330.exists() || pdesireaudio_wcd9330_new_api.exists() || pdesireaudio_wcd9320.exists() || pdesireaudio_wcd9320_new_api.exists()) {
            Toast.makeText(getActivity(), "PDesireAudio found on Kernel",
                    Toast.LENGTH_LONG).show();
        }

        val pdesireaudio_uhqa = findPreference("pdesireaudio_uhqa_switch")

        pdesireaudio_uhqa.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9330/PDesireAudio")
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9320/uhqa_mode_pdesireaudio")
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9320/PDesireAudio")
            } else {
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio")
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9330/PDesireAudio")
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9320/uhqa_mode_pdesireaudio")
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9320/PDesireAudio")
            }

            true
        }


        val pdesireaudio_static = findPreference("pdesireaudio_static_switch")

        pdesireaudio_static.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9330/pdesireaudio_static_mode")
                YandereRootUtility.sudo("echo 1 /sys/module/snd_soc_wcd9320/pdesireaudio_static_mode")
            } else {
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9330/pdesireaudio_static_mode")
                YandereRootUtility.sudo("echo 0 /sys/module/snd_soc_wcd9320/pdesireaudio_static_mode")
            }

            true
        }
    }
}