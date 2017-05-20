package com.meli.pdesire.projectmeliaudioeffects

/**
 * Created by PDesire on 20.05.2017.
 */

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference

import java.io.IOException

class PDesireAudioControlFragment : PreferenceFragment() {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_pdesireaudio_control)
        setHasOptionsMenu(true)


        val pdesireaudio_uhqa = findPreference("pdesireaudio_uhqa_switch")

        pdesireaudio_uhqa.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched)
                try {
                    val command = "su -c echo 1 /sys/module/snd_soc_wcd93*/uhqa_mode_pdesireaudio"
                    val p = Runtime.getRuntime().exec(command)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            else
                try {
                    val command = "su -c echo 0 /sys/module/snd_soc_wcd93*/uhqa_mode_pdesireaudio"
                    val p = Runtime.getRuntime().exec(command)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            true
        }


        val pdesireaudio_static = findPreference("pdesireaudio_static_switch")

        pdesireaudio_static.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched)
                try {
                    val command = "su -c echo 1 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode"
                    val p = Runtime.getRuntime().exec(command)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            else
                try {
                    val command = "su -c echo 0 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode"
                    val p = Runtime.getRuntime().exec(command)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            true
        }
    }
}