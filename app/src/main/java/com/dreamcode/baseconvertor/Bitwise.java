package com.dreamcode.baseconvertor;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by harismuzaffer on 11/12/2017.
 */

public class Bitwise extends Fragment {

    EditText first;
    EditText second;
    EditText andvalue;
    EditText orvalue;
    EditText xorvalue;
    RadioGroup format;
    RadioButton decradio;
    RadioButton binradio;
    private AdView topAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.bitwise, null);
        topAd = view.findViewById(R.id.adViewTop);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        topAd.loadAd(adRequest);
        first= view.findViewById(R.id.first);
        second= view.findViewById(R.id.second);
        andvalue = view.findViewById(R.id.andvalue);
        orvalue = view.findViewById(R.id.orvalue);
        xorvalue = view.findViewById(R.id.xorvalue);
        andvalue.setKeyListener(null);
        orvalue.setKeyListener(null);
        xorvalue.setKeyListener(null);
        format= view.findViewById(R.id.radioGroup);
        binradio = format.findViewById(R.id.binradio);
        binradio.setChecked(true);
        Flag.f= "binary";
        first.setKeyListener(DigitsKeyListener.getInstance("01"));
        second.setKeyListener(DigitsKeyListener.getInstance("01"));

        format.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId() == radioGroup.getChildAt(0).getId()){
                    Flag.f= "binary";
                    first.setHint("First Binary");
                    second.setHint("Second Binary");
                    first.setText("");
                    second.setText("");
                    first.setKeyListener(DigitsKeyListener.getInstance("01"));
                    second.setKeyListener(DigitsKeyListener.getInstance("01"));
                }
                else{
                    Flag.f= "decimal";
                    first.setHint("First Decimal");
                    second.setHint("Second Decimal");
                    first.setText("");
                    second.setText("");
                    first.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                    second.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                }
            }
        });
        first.addTextChangedListener(new FirstValueListner(first, second, andvalue, orvalue, xorvalue, getContext()));
        second.addTextChangedListener(new SecondValueListner(first, second, andvalue, orvalue, xorvalue, getContext()));

        return view;
    }
    @Override
    public void onPause() {
        if (topAd != null) {
            topAd.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (topAd != null) {
            topAd.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (topAd != null) {
            topAd.destroy();
        }
        super.onDestroy();
    }

}
