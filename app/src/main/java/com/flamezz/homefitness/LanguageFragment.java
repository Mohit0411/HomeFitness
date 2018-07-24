package com.flamezz.homefitness;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;



/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragment extends Fragment {

    public LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loadLocale();
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_language, container, false);
        final String[] listitems = {"English","Hindi","Marathi","French","German","British"};
        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());
        alertdialog.setTitle("Select Preferred Language");
        alertdialog.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    if(i==0)
                    {
                        setLocale("en");
                        getActivity().recreate();
                        Toast.makeText(getContext(),"English Selected",Toast.LENGTH_SHORT).show();
                    }
                    else if(i==1)
                    {
                        setLocale("hi");
                        getActivity().recreate();
                        Toast.makeText(getContext(),"Hindi Selected",Toast.LENGTH_SHORT).show();
                    }
                    else if(i==2)
                    {
                        Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                    }
                    else if(i==3)
                    {
                        Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                    }
                    else if(i==4)
                    {
                        Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                    }
                    else if(i==5) {
                        Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                    }
                    dialogInterface.dismiss();
            }
        });
        alertdialog.create();
        alertdialog.show();
        return view;
    }

    private void setLocale(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getActivity().getResources().updateConfiguration(configuration,getActivity().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = (this.getActivity()).getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }

    private void loadLocale()
    {
        SharedPreferences prefs = (getActivity()).getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

}
