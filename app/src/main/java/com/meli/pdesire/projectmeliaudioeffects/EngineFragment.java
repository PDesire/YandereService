package com.meli.pdesire.projectmeliaudioeffects;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
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

        /* find preferences */

        Preference onezero = (Preference) findPreference("1.0");
        Preference twofiveone = (Preference) findPreference("2.5.1");
        Preference threezero = (Preference) findPreference("3.0");
        Preference fivezero = (Preference) findPreference("5.0");
        Preference twentyzero = (Preference) findPreference("20.0");
        Preference thirtyfivesixone = (Preference) findPreference("35.6.1");
        Preference two = (Preference) findPreference("Two");
        Preference three = (Preference) findPreference("Three");
        Preference four = (Preference) findPreference("Four");
        Preference five = (Preference) findPreference("Five");

        Preference yumefinal = (Preference) findPreference("Final");

        Preference beta = (Preference) findPreference("Beta");

        Preference believeness = (Preference) findPreference("Believeness");
        Preference loveness = (Preference) findPreference("Loveness");
        Preference fortune = (Preference) findPreference("Fortune");

        Preference melione = (Preference) findPreference("Meli_One");
        Preference melifive = (Preference) findPreference("Meli_Five");

        Preference meliten = (Preference) findPreference("Ten");
        Preference melitenrage = (Preference) findPreference("Ragemode");

        onezero.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/1.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        twofiveone.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/2.5.1.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        threezero.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint ("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/3.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        fivezero.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/5.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        twentyzero.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/20.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        thirtyfivesixone.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/35.6.1.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        two.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Two.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        three.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Three.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        four.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/4.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        five.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Five.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        yumefinal.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Final.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        beta.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Beta.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        believeness.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Believeness.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        loveness.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Loveness.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        fortune.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/Fortune.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        melione.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/One.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        melifive.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/MeliFive.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        onezero.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Engines/1.0.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        meliten.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    String command = "su -c sh /system/Desire/Shells/Rage_Disable.sh";
                    Process p;
                    p = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        melitenrage.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    AlertDialog.Builder ragemode = new AlertDialog.Builder(getActivity ());
                    ragemode.setTitle("Rage Mode Warning");
                    ragemode.setMessage(getString(R.string.ragemode_warning));
                    ragemode.create();
                    ragemode.show();
                    String command = "su -c sh /system/Desire/Shells/Rage_Enable.sh";
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
