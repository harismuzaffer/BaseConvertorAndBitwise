package com.dreamcode.baseconvertor;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    public BinValueListner(EditText dec, EditText bin, EditText oct, EditText hex) {
        this.dec = dec;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
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
        long l=0;
        for(int i= ss.length()-1; i>=0; i--){
            if(ss.charAt(ss.length()-i-1)=='1'){
                int j=i;
                long sum=1;
                while(j!=0){
                    sum*= 2;
                    j--;
                }
                l+= sum;
            }
        }
        bin= String.valueOf(l);
        dec.setText(bin);
        hex.setText(Long.toHexString(l));
        oct.setText(Long.toOctalString(l));
    }
}