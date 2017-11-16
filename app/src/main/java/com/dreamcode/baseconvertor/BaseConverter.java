package com.dreamcode.baseconvertor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by ADMINIBM on 11/12/2017.
 */

public class BaseConverter extends Fragment {

    EditText dec;
    EditText bin;
    EditText hex;
    EditText oct;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.base_converter, null);
        dec= view.findViewById(R.id.decvalue);
        bin= view.findViewById(R.id.binvalue);
        hex= view.findViewById(R.id.hexvalue);
        oct= view.findViewById(R.id.octvalue);
        dec.addTextChangedListener(new DecValueListner(dec, bin, oct, hex));
        bin.addTextChangedListener(new BinValueListner(dec, bin, oct, hex));
        hex.addTextChangedListener(new HexValueListner(dec, bin, oct, hex));
        oct.addTextChangedListener(new OctValueListner(dec, bin, oct, hex));
        return view;


    }
}
