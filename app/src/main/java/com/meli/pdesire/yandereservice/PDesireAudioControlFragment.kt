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
import com.meli.pdesire.yandereservice.framework.YanderePDesireAudioAPI
import com.meli.pdesire.yandereservice.framework.YandereRootUtility

class PDesireAudioControlFragment : PreferenceFragment() {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_pdesireaudio_control)
        setHasOptionsMenu(true)

        if (!YanderePDesireAudioAPI.getPDesireAudio().equals(""))
            Toast.makeText(activity, getString(R.string.pdesireaudio_found),
                    Toast.LENGTH_LONG).show();
        else
            Toast.makeText(activity, getString(R.string.pdesireaudio_not_found),
                    Toast.LENGTH_LONG).show();

        val pdesireaudio_uhqa = findPreference("pdesireaudio_uhqa_switch")

        pdesireaudio_uhqa.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereRootUtility.sudo("echo 1 " + YanderePDesireAudioAPI.getPDesireAudio())
            } else {
                YandereRootUtility.sudo("echo 0 " + YanderePDesireAudioAPI.getPDesireAudio())
            }

            true
        }


        val pdesireaudio_static = findPreference("pdesireaudio_static_switch")

        pdesireaudio_static.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereRootUtility.sudo("echo 1 " + YanderePDesireAudioAPI.getPDesireAudioStatic())
            } else {
                YandereRootUtility.sudo("echo 0 " + YanderePDesireAudioAPI.getPDesireAudioStatic())
            }

            true
        }
    }
}