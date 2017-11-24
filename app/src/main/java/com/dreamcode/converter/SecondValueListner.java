package com.dreamcode.converter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
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
    String flag;

    public SecondValueListner(EditText first, EditText second, EditText andvalue, EditText orvalue, EditText xorvalue, Context context) {
        this.first = first;
        this.second = second;
        this.andvalue = andvalue;
        this.orvalue = orvalue;
        this.xorvalue = xorvalue;
        this.context = context;
        flag = "ndone";
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
            if(editable.toString().replaceAll(",", "").length() > 63){
                second.setText(num);
                second.setSelection(second.getText().length());
                return;
            }
            else {
                if(flag == "ndone"){
                    flag = "done";
                    second.setText(StringUtility.insertCommas(new StringBuilder(editable.toString().replaceAll(",", ""))));
                    second.setSelection(second.getText().length());
                    return;
                }
                flag = "ndone";
                ll1= ConvertBase.convertToDecimal(editable.toString().replaceAll(",", ""));
                ll2= ConvertBase.convertToDecimal(first.getText().toString().replaceAll(",", ""));
                if(first.getText().toString().equals(""))
                    return;
                andvalue.setText(StringUtility.insertCommas(new StringBuilder(Long.toBinaryString(ll1 & ll2))));
                orvalue.setText(StringUtility.insertCommas(new StringBuilder(Long.toBinaryString(ll1 | ll2))));
                xorvalue.setText(StringUtility.insertCommas(new StringBuilder(Long.toBinaryString(ll1 ^ ll2))));
                return;
            }
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
        ll1= Long.parseLong(l1.toString());
        ll2= Long.parseLong(l2.toString());
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
