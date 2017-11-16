package com.dreamcode.baseconvertor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

/**
 * Created by ADMINIBM on 11/12/2017.
 */

public class SecondValueListner implements TextWatcher {


    EditText first;
    EditText second;
    EditText andvalue;
    EditText orvalue;
    EditText xorvalue;
    String num;

    public SecondValueListner(EditText first, EditText second, EditText andvalue, EditText orvalue, EditText xorvalue) {
        this.first = first;
        this.second = second;
        this.andvalue = andvalue;
        this.orvalue = orvalue;
        this.xorvalue = xorvalue;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        num= charSequence.toString();

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if(first.isFocused() || editable.toString().equals("")){
            andvalue.setText("");
            orvalue.setText("");
            xorvalue.setText("");
            return;
        }
        BigInteger l1, l2;
        String s= editable.toString();
        String ss= first.getText().toString();
        l1= new BigInteger(s);
        if(l1.compareTo(new BigInteger("9223372036854775807"))==1){
            second.setText(num);
            second.setSelection(second.getText().length());
            return;
        }
        if(ss.equals(""))
            return;
        l2= new BigInteger(ss);
        long ll1= Long.parseLong(l1.toString());
        long ll2= Long.parseLong(l2.toString());
        if( ((ll1|ll2) > 9223372036854775807l) || ((ll1^ll2) > 9223372036854775807l)){
            second.setText(num);
            second.setSelection(second.getText().length());
            return;
        }
        andvalue.setText(String.valueOf(ll1&ll2));
        orvalue.setText(String.valueOf(ll1|ll2));
        xorvalue.setText(String.valueOf(ll1^ll2));
    }
}
