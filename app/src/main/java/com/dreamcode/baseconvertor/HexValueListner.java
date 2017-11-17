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

public class HexValueListner implements TextWatcher{

    EditText dec;
    EditText bin;
    EditText oct;
    EditText hex;
    String num;
    Context context;

    public HexValueListner(EditText dec, EditText bin, EditText oct, EditText hex, Context context) {
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

        if(bin.isFocused() || dec.isFocused() || oct.isFocused()){
            return;
        }

        String hexvalue= s.toString();
        BigInteger converted= new BigInteger("0");
        for(int i= hexvalue.length()-1; i >=0; i--){
            char c= hexvalue.charAt((hexvalue.length()-i)-1);
            int n;
            if(c=='A' || c=='a')
                n= 10;
            else if(c=='B' || c=='b')
                n=11;
            else if(c=='c' || c=='c')
                n=12;
            else if(c=='D' || c=='d')
                n=13;
            else if(c=='E' || c=='e')
                n=14;
            else if(c=='F' || c=='f')
                n=15;
            else
                n= ((int) c) - 48;
            converted = converted.add(raisedPower(16, i).multiply(new BigInteger(String.valueOf(n))));
        }
        if(converted.compareTo(new BigInteger("9223372036854775807")) ==1){
            Toast toast=Toast.makeText(context,"Number larger than MAX",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 320, -10);
            toast.show();
            hex.setText(num);
            hex.setSelection(hex.getText().length());
            return;
        }
        if(s.toString().equals("")){
            dec.setText("");
            oct.setText("");
            bin.setText("");
            return;
        }
        else {
            bin.setText(Long.toBinaryString(Long.parseLong(converted.toString())));
            oct.setText(Long.toOctalString(Long.parseLong(converted.toString())));
            dec.setText(String.valueOf(converted));
        }

    }
    public BigInteger raisedPower(int base, int exponent){
        int exp= exponent;
        BigInteger result= new BigInteger("1");
        while(exp!=0){
            result =result.multiply(new BigInteger(String.valueOf(base)));
            exp--;
        }

        return result;
    }
}
