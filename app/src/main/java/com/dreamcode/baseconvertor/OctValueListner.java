package com.dreamcode.baseconvertor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigInteger;

/**
 * Created by harismuzaffer on 11/7/2017.
 */

public class OctValueListner implements TextWatcher {

    EditText dec;
    EditText bin;
    EditText oct;
    EditText hex;
    String num;

    public OctValueListner(EditText dec, EditText bin, EditText oct, EditText hex) {
        this.dec = dec;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        num = charSequence.toString();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if(bin.isFocused() || dec.isFocused() || hex.isFocused()){
            return;
        }

        String octvalue= s.toString();
        BigInteger converted= new BigInteger("0");
        for(int i= octvalue.length()-1; i >=0; i--){
            char c= octvalue.charAt((octvalue.length()-i)-1);
            int n;
            n= ((int) c) - 48;
            converted = converted.add(raisedPower(8, i).multiply(new BigInteger(String.valueOf(n))));
        }

        if(converted.compareTo(new BigInteger("9223372036854775807")) ==1){
            oct.setText(num);
            oct.setSelection(oct.getText().length());
            return;
        }
        if(s.toString().equals("")){
            hex.setText("");
            dec.setText("");
            bin.setText("");
            return;
        }
        else {
            dec.setText(String.valueOf(converted));
            bin.setText(Long.toBinaryString(Long.parseLong(converted.toString())));
            hex.setText(Long.toHexString(Long.parseLong(converted.toString())).toUpperCase());
        }
    }

    public BigInteger raisedPower(int base, int exponent){
        int exp= exponent;
        BigInteger result= new BigInteger("1");
        while(exp!=0){
            result = result.multiply(new BigInteger(String.valueOf(base)));
            exp--;
        }
        return result;
    }
}
