package com.dreamcode.baseconvertor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

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
    Context context;

    public OctValueListner(EditText dec, EditText bin, EditText oct, EditText hex, Context context) {
        this.dec = dec;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
        this.context = context;
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
            Toast toast=Toast.makeText(context,"Number larger than MAX",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 320, -10);
            toast.show();
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
