package com.meli.pdesire.yandereservice

/**
 * Created by PDesire on 20.05.2017.
 */


import android.annotation.TargetApi
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment

import android.widget.Toast
import com.meli.pdesire.yandereservice.framework.YanderePackageManager


/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 *
 * See [
   * Android Design: Settings](http://developer.android.com/design/patterns/settings.html) for design guidelines and the [Settings
   * API Guide](http://developer.android.com/guide/topics/ui/settings.html) for more information on developing a Settings UI.
 */
class SettingsActivity : PreferenceActivity() {

    fun closedReleaseTest () {
        if (YanderePackageManager.closedReleaseTest(this)) {
            Toast.makeText(this, getString(R.string.security_error),
                    Toast.LENGTH_LONG).show();
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        closedReleaseTest()
    }


    /**
     * {@inheritDoc}
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onBuildHeaders(target: List<PreferenceActivity.Header>) {
        loadHeadersFromResource(R.xml.pref_headers, target)
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName
                || AudioSettingsFragment::class.java.name == fragmentName
                || EngineFragment::class.java.name == fragmentName
                || CreditsFragment::class.java.name == fragmentName
    }

    public override fun onStart() {
        super.onStart()
        closedReleaseTest()
    }

    public override fun onStop() {
        super.onStop()
    }
}