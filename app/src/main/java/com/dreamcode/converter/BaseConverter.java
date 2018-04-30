package com.dreamcode.converter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

/**
 * Created by harismuzaffer on 11/12/2017.
 */

public class BaseConverter extends Fragment {

    EditText dec;
    EditText bin;
    EditText hex;
    EditText oct;
    //private AdView bottomAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.base_converter, null);

        //bottomAd = view.findViewById(R.id.adViewBottom);
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//        bottomAd.loadAd(adRequest);
        dec= view.findViewById(R.id.decvalue);
        bin= view.findViewById(R.id.binvalue);
        hex= view.findViewById(R.id.hexvalue);
        oct= view.findViewById(R.id.octvalue);
        dec.addTextChangedListener(new DecValueListner(dec, bin, oct, hex, getContext()));
        bin.addTextChangedListener(new BinValueListner(dec, bin, oct, hex, getContext()));
        hex.addTextChangedListener(new HexValueListner(dec, bin, oct, hex, getContext()));
        oct.addTextChangedListener(new OctValueListner(dec, bin, oct, hex, getContext()));
        return view;

    }
    @Override
    public void onPause() {
//        if (bottomAd != null) {
//            bottomAd.pause();
//        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (bottomAd != null) {
//            bottomAd.resume();
//        }
    }

    @Override
    public void onDestroy() {
//        if (bottomAd != null) {
//            bottomAd.destroy();
//        }
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//        bottomAd.loadAd(adRequest);

    }
}

