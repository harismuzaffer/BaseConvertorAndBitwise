package com.dreamcode.baseconvertor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by ADMINIBM on 11/12/2017.
 */

public class BaseConverter extends Fragment {

    EditText dec;
    EditText bin;
    EditText hex;
    EditText oct;
    private AdView topAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.base_converter, null);
        topAd = (AdView) view.findViewById(R.id.adViewTop);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        topAd.loadAd(adRequest);

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
