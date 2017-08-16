package com.meli.pdesire.yandereservice

/**
 * Created by PDesire on 20.05.2017.
 */


import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import com.meli.pdesire.yandereservice.framework.YandereOutputWrapper

class PDesireAudioCreditsFragment : PreferenceFragment() {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        addPreferencesFromResource(R.xml.pref_other_pdesireaudio)
        setHasOptionsMenu(true)
        val credits = findPreference("credits_click")
        credits.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            YandereOutputWrapper.outputMessageInt(R.string.credits_title, R.string.credits_pdesireaudio, activity)
            false
        }
    }
}
