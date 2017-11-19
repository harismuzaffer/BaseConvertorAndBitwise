package com.dreamcode.baseconvertor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    Context context;

    public SecondValueListner(EditText first, EditText second, EditText andvalue, EditText orvalue, EditText xorvalue, Context context) {
        this.first = first;
        this.second = second;
        this.andvalue = andvalue;
        this.orvalue = orvalue;
        this.xorvalue = xorvalue;
        this.context = context;
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

        long ll1;
        long ll2;

        if(first.isFocused() || editable.toString().equals("")){
            andvalue.setText("");
            orvalue.setText("");
            xorvalue.setText("");
            return;
        }

        if(Flag.f.equals("binary")){
            if(editable.toString().length() > 32){
                Toast toast=Toast.makeText(context,"MAX VALUE",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.LEFT, 450, -10);
                toast.show();
                second.setText(num);
                second.setSelection(second.getText().length());
                return;
            }
            else {
                ll1= ConvertBase.convertToDecimal(editable.toString());
                ll2= ConvertBase.convertToDecimal(first.getText().toString());
                if(first.getText().toString().equals(""))
                    return;
                andvalue.setText(Long.toBinaryString(ll1&ll2));
                orvalue.setText(Long.toBinaryString(ll1|ll2));
                xorvalue.setText(Long.toBinaryString(ll1^ll2));
                return;
            }
        }

        BigInteger l1, l2;
        String s= editable.toString();
        String ss= first.getText().toString();
        l1= new BigInteger(s);
        if(l1.compareTo(new BigInteger("9223372036854775807"))==1){
            Toast toast=Toast.makeText(context,"MAX VALUE",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 100, -10);
            toast.show();
            second.setText(num);
            second.setSelection(second.getText().length());
            return;
        }
        if(ss.equals(""))
            return;
        l2= new BigInteger(ss);
        ll1= Long.parseLong(l1.toString());
        ll2= Long.parseLong(l2.toString());
        if( ((ll1|ll2) > 9223372036854775807l) || ((ll1^ll2) > 9223372036854775807l)){
            second.setText(num);
            second.setSelection(second.getText().length());
            return;
        }
        andvalue.setText(String.valueOf(ll1 & ll2));
        orvalue.setText(String.valueOf(ll1 | ll2));
        xorvalue.setText(String.valueOf(ll1 ^ ll2));
    }
}
