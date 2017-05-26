package com.meli.pdesire.projectmeliaudioeffects

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

import com.google.android.gms.appindexing.Action
import com.google.android.gms.appindexing.AppIndex
import com.google.android.gms.appindexing.Thing
import com.google.android.gms.common.api.GoogleApiClient

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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private var client: GoogleApiClient? = null

    private fun checkLuckyPatcher(): Boolean {
        if (packageExists("com.dimonvideo.luckypatcher")) {
            return true
        }

        if (packageExists("com.chelpus.lackypatch")) {
            return true
        }

        if (packageExists("com.android.vending.billing.InAppBillingService.LACK")) {
            return true
        }

        if (packageExists("com.android.vending.billing.InAppBillingService.LOCK")) {
            return true
        }

        return false
    }

    private fun packageExists(packageName: String): Boolean {
        try {
            val info = this.packageManager.getApplicationInfo(packageName, 0) ?: // No need really to test for null, if the package does not
                    // exist it will really rise an exception. but in case Google
                    // changes the API in the future lets be safe and test it
                    return false

            return true
        } catch (ex: Exception) {
            // If we get here only means the Package does not exist
        }

        return false
    }

    fun deviceLaggerCheck () {
        if (checkLuckyPatcher()) {
            val fuckyou : Int = 1;
            while (fuckyou == 1) {
                Toast.makeText(this, "Haha try to start it now :P",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = GoogleApiClient.Builder(this).addApi(AppIndex.API).build()
        deviceLaggerCheck()
    }


    /**
     * {@inheritDoc}
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onBuildHeaders(target: List<PreferenceActivity.Header>) {
        loadHeadersFromResource(R.xml.pref_headers_pdesireaudio, target)
        deviceLaggerCheck()
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
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client!!.connect()
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, indexApiAction)
        deviceLaggerCheck()
    }

    public override fun onStop() {
        deviceLaggerCheck()
        super.onStop()// ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, indexApiAction)
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client!!.disconnect()
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // TODO: Define a title for the content shown.
    // TODO: Make sure this auto-generated URL is correct.
    val indexApiAction: Action
        get() {
            val `object` = Thing.Builder()
                    .setName("Settings Page")
                    .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                    .build()
            return Action.Builder(Action.TYPE_VIEW)
                    .setObject(`object`)
                    .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                    .build()
        }
}
