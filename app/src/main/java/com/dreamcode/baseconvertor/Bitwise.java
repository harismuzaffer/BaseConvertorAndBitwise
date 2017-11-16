package com.dreamcode.baseconvertor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ADMINIBM on 11/12/2017.
 */

public class Bitwise extends Fragment {

    EditText first;
    EditText second;
    EditText andvalue;
    EditText orvalue;
    EditText xorvalue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.bitwise, null);
        first= view.findViewById(R.id.first);
        second= view.findViewById(R.id.second);
        andvalue = view.findViewById(R.id.andvalue);
        orvalue = view.findViewById(R.id.orvalue);
        xorvalue = view.findViewById(R.id.xorvalue);
        andvalue.setKeyListener(null);
        orvalue.setKeyListener(null);
        xorvalue.setKeyListener(null);

        first.addTextChangedListener(new FirstValueListner(first, second, andvalue, orvalue, xorvalue));
        second.addTextChangedListener(new SecondValueListner(first, second, andvalue, orvalue, xorvalue));

        return view;
    }
}
