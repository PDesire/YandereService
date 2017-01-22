package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

/**
 * Created by PDesire on 18.01.2016.
 */
public class AudioSettingsFragment extends PreferenceFragment {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);
        setHasOptionsMenu(true);

        //DTS Section
        Preference dts = findPreference("dts_switch");

        dts.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean switched = ((SwitchPreference) preference)
                        .isChecked();
                if (switched == false) {
                    try {
                        String command = "su -c sh /system/Desire/Shells/DTS_Enable.sh";
                        Process p;
                        p = Runtime.getRuntime().exec(command);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        String command = "su -c sh /system/Desire/Shells/DTS_Disable.sh";
                        Process p;
                        p = Runtime.getRuntime().exec(command);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });

        //DTS Section
        Preference heavybass = findPreference("heavybass_switch");

        heavybass.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean switched = ((SwitchPreference) preference)
                        .isChecked();
                if (switched == false) {
                    try {
                        String command = "su -c sh /system/Desire/Shells/Heavybass_Enable.sh";
                        Process p;
                        p = Runtime.getRuntime().exec(command);
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }

                } else {
                    try {
                        String command = "su -c sh /system/Desire/Shells/Heavybass_Disable.sh";
                        Process p;
                        p = Runtime.getRuntime().exec(command);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });

        Preference reboot = (Preference) findPreference("reboot_click");

        reboot.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c reboot";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }
}
