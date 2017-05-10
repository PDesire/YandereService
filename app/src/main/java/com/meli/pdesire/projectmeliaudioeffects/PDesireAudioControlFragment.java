package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

import java.io.IOException;

/**
 * Created by PDesire on 18.01.2016.
 */
public class PDesireAudioControlFragment extends PreferenceFragment {
    

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_pdesireaudio_control);
        setHasOptionsMenu(true);
    
    
        Preference pdesireaudio_uhqa = findPreference("pdesireaudio_uhqa_switch");
    
        pdesireaudio_uhqa.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener () {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean switched = ((SwitchPreference) preference)
                        .isChecked ();
                if (!switched) try {
                    String command = "su -c echo 1 /sys/module/snd_soc_wcd93*/uhqa_mode_pdesireaudio";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                else try {
                    String command = "su -c echo 0 /sys/module/snd_soc_wcd93*/uhqa_mode_pdesireaudio";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                return true;
            }
        });
        

        Preference pdesireaudio_static = findPreference("pdesireaudio_static_switch");
    
        pdesireaudio_static.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener () {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean switched = ((SwitchPreference) preference)
                        .isChecked ();
                if (!switched) try {
                    String command = "su -c echo 1 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                else try {
                    String command = "su -c echo 0 /sys/module/snd_soc_wcd93*/pdesireaudio_static_mode";
                    Process p = Runtime.getRuntime ().exec (command);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                return true;
            }
        });
    }
}
