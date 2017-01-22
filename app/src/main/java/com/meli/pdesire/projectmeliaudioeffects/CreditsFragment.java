package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by PDesire on 31.01.2016.
 */
public class CreditsFragment extends PreferenceFragment {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.pref_other);
        setHasOptionsMenu(true);
        Preference reboot = (Preference) findPreference("credits_click");
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        reboot.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                builder.setTitle(R.string.credits_title);
                builder.setMessage(getString(R.string.credits));
                builder.create();
                builder.show();
                return false;
            }
        });
    }
}
