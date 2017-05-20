package com.meli.pdesire.projectmeliaudioeffects

/**
 * Created by PDesire on 20.05.2017.
 */


import android.annotation.TargetApi
import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment

class PDesireAudioCreditsFragment : PreferenceFragment() {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        addPreferencesFromResource(R.xml.pref_other_pdesireaudio)
        setHasOptionsMenu(true)
        val reboot = findPreference("credits_click")
        val builder = AlertDialog.Builder(activity)
        reboot.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            builder.setTitle(R.string.credits_title)
            builder.setMessage(this@PDesireAudioCreditsFragment.getString(R.string.credits_pdesireaudio))
            builder.create()
            builder.show()
            false
        }
    }
}
