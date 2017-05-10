package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import java.io.IOException;

/**
 * Created by PDesire on 18.01.2016.
 */
public class AudioSettingsFragment extends PreferenceFragment {

    private boolean isAppInstalled(String uri) {
        Context context = getActivity();
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);
        setHasOptionsMenu(true);

        boolean isAM3DInstalled = isAppInstalled("com.fihtdc.am3dfx");
        boolean isDolbyInstalled = isAppInstalled("com.dolby.ds1appUI");
        boolean isV4AInstalled = isAppInstalled("com.audlabs.viperfx");

        PreferenceScreen screen = getPreferenceScreen();
        PreferenceScreen am3d = (PreferenceScreen) findPreference("am3d");
        PreferenceScreen dolby = (PreferenceScreen) findPreference("dolby");
        PreferenceScreen v4a = (PreferenceScreen) findPreference("v4a");
        if (!isAM3DInstalled) {
            screen.removePreference(am3d);
        }

        if (!isDolbyInstalled) {
            screen.removePreference(dolby);
        }

        if (!isV4AInstalled) {
            screen.removePreference(v4a);
        }

        Preference heavybass = findPreference("heavybass_switch");

        heavybass.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener () {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean switched = ((SwitchPreference) preference)
                        .isChecked ();
                if (!switched) try {
                    String command = "su -c sh /system/Desire/Shells/Heavybass_Enable.sh";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                else try {
                    String command = "su -c sh /system/Desire/Shells/Heavybass_Disable.sh";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                return true;
            }
        });


        Preference reboot = findPreference("reboot_click");

        reboot.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener () {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c reboot";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                return false;
            }
        });
    }
}
