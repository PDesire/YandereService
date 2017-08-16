package com.meli.pdesire.yandereservice.framework

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.preference.PreferenceActivity

@SuppressLint("Registered")
/**
 * Created by PDesire on 8/16/17.
 */


object YanderePackageManager : PreferenceActivity() {

    // Check if app is installed, this just count for apps which are installed and not their subclasses
    fun isAppInstalled(packageName : String, contexts : Context): Boolean {
        val context = contexts
        val pm = context.packageManager
        var installed: Boolean
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            installed = true
        } catch (e: PackageManager.NameNotFoundException) {
            installed = false
        }

        return installed
    }

    // Check if classes and subclasses exist
    fun packageExists(packageName: String, context: Context): Boolean {
        try {
            val info = context.packageManager.getApplicationInfo(packageName, 0) ?: // No need really to test for null, if the package does not
                    // exist it will really rise an exception. but in case Google
                    // changes the API in the future lets be safe and test it
                    return false

            return true
        } catch (ex: Exception) {
            // If we get here only means the Package does not exist
        }

        return false
    }

    val closedRelease : Boolean = false;

    fun closedReleaseTest(context: Context) : Boolean {
        if (!closedRelease)
            return false

        var blockedClassesValue : Int = 4;
        var blockedClasses = arrayOf("com.dimonvideo.luckypatcher",
                                            "com.chelpus.lackypatch",
                                            "com.android.vending.billing.InAppBillingService.LACK",
                                            "com.android.vending.billing.InAppBillingService.LOCK")

        var count : Int = 0;

        while (count != blockedClassesValue) {
            if (packageExists(blockedClasses[count], context))
                return true

            count++;
        }

        return false
    }
}