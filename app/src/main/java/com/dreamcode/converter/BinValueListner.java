package com.dreamcode.converter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
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
    String flag;

    public BinValueListner(EditText dec, EditText bin, EditText oct, EditText hex, Context context) {
        this.dec = dec;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
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
    public void afterTextChanged(Editable s) {

        if(dec.isFocused() || hex.isFocused() || oct.isFocused()){
            return;
        }

        String ss= s.toString().replaceAll(",", "");
        if(ss.length()> 63){
            bin.setText(num);
            bin.setSelection(bin.getText().length());
            return;
        }
        if(flag == "ndone"){
            flag = "done";
            bin.setText(StringUtility.insertCommas(new StringBuilder(s.toString().replaceAll(",", ""))));
            bin.setSelection(bin.getText().length());
            return;
        }
        flag = "ndone";
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