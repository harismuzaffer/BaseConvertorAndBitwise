package com.dreamcode.baseconvertor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by harismuzaffer on 11/5/2017.
 */

public class BinValueListner implements TextWatcher {

    EditText dec;
    EditText bin;
    EditText oct;
    EditText hex;
    String num;
    Context context;

    public BinValueListner(EditText dec, EditText bin, EditText oct, EditText hex, Context context) {
        this.dec = dec;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
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
    public void afterTextChanged(Editable s) {

        if(dec.isFocused() || hex.isFocused() || oct.isFocused()){
            return;
        }

        String ss= s.toString();
        if(ss.length()> 63){
            Toast toast=Toast.makeText(context,"MAX 63 bits",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 100, -10);
            toast.show();
            bin.setText(num);
            bin.setSelection(bin.getText().length());
            return;
        }
        if(ss.equals("")){
            dec.setText("");
            hex.setText("");
            oct.setText("");
            return;
        }
        String bin= "";
        long l= ConvertBase.convertToDecimal(ss);
        bin= String.valueOf(l);
        dec.setText(bin);
        hex.setText(Long.toHexString(l).toUpperCase());
        oct.setText(Long.toOctalString(l));
    }
}