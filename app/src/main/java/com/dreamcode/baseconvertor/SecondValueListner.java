package com.dreamcode.baseconvertor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ADMINIBM on 11/12/2017.
 */

public class SecondValueListner implements TextWatcher {


    EditText first;
    EditText second;
    TextView andvalue;
    TextView orvalue;

    public SecondValueListner(EditText first, EditText second, TextView andvalue, TextView orvalue) {
        this.first = first;
        this.second = second;
        this.andvalue = andvalue;
        this.orvalue = orvalue;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        long l1, l2;
        if(first.isFocused())
            return;
        if(first.getText().toString().equals(""))
            return;
        String s= editable.toString();
        if(second.getText().toString().equals(""))
            l1=0;
        else
            l1= Long.parseLong(s);
        l2= Long.parseLong(first.getText().toString());
        andvalue.setText(String.valueOf(l1+l2));
        orvalue.setText(String.valueOf(l2-l1));

    }
}
