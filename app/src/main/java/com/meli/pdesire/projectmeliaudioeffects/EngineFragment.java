package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by PDesire on 18.01.2016.
 */
public class EngineFragment extends PreferenceFragment {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        addPreferencesFromResource (R.xml.pref_engines);
        setHasOptionsMenu (true);

        Preference yume = findPreference("Yume");
        Preference meli = findPreference("Meli");


        yume.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener () {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Yume/Final/Final.sh";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                return false;
            }
        });

        meli.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener () {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Rage_Enable.sh";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                return false;
            }
        });
    }
}
