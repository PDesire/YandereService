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

import com.meli.pdesire.yandereservice.framework.YandereOutputWrapper
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
class PDesireAudioActivity : PreferenceActivity() {

    fun closedReleaseTest () {
        if (YanderePackageManager.closedReleaseTest(this)) {
                Toast.makeText(this, getString(R.string.security_error),
                        Toast.LENGTH_LONG).show();
                finish()
        }
    }

    var alreadyShown : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        closedReleaseTest()

        if (!alreadyShown) {
            YandereOutputWrapper.outputMessageString(getString(R.string.pdesireaudio_desc),
                                                    getString(R.string.pdesireaudio_description),
                                                    this)
            alreadyShown = true;
        }
    }


    /**
     * {@inheritDoc}
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onBuildHeaders(target: List<PreferenceActivity.Header>) {
        loadHeadersFromResource(R.xml.pref_headers_pdesireaudio, target)
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName
                || PDesireAudioControlFragment::class.java.name == fragmentName
                || PDesireAudioCreditsFragment::class.java.name == fragmentName
    }

    public override fun onStart() {
        super.onStart()// ATTENTION: This was auto-generated to implement the App Indexing API.
        closedReleaseTest()
    }

    public override fun onStop() {
        super.onStop()// ATTENTION: This was auto-generated to implement the App Indexing API.
    }
}
