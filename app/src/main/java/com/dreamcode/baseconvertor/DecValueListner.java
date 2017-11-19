package com.dreamcode.baseconvertor;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

import static com.dreamcode.baseconvertor.R.id.dec;

/**
 * Created by harismuzaffer on 11/5/2017.
 */


public class DecValueListner implements TextWatcher {

    EditText dec;
    EditText bin;
    EditText oct;
    EditText hex;
    String num;
    Context context;

    public DecValueListner(EditText dec, EditText bin, EditText oct, EditText hex, Context context) {
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

        if (bin.isFocused() || hex.isFocused() || oct.isFocused()) {
            return;
        }
        BigInteger d;
        String temp = s.toString();
        if (!temp.equals(""))
            d = new BigInteger(s.toString());
        else
            d = new BigInteger("0");
        String ss = "";
        if (d.compareTo(new BigInteger("9223372036854775807"))==1) {
            dec.setText(num);
            dec.setSelection(dec.getText().length());
            Toast toast=Toast.makeText(context,"Number larger than MAX",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 100, -10);
            toast.show();
            Snackbar snackbar = Snackbar
                    .make(new CoordinatorLayout(context), "MAX Number!!!", Snackbar.LENGTH_LONG);
            snackbar.show();
            return;
        }
        long dd = Long.parseLong(d.toString());
        long ddd = dd;
        while (dd > 0) {
            ss += String.valueOf(dd & 1);
            dd = dd >> 1;
        }
        if (temp.equals(""))
            ss = "";
        else if (d.compareTo(new BigInteger("0")) == 0)
            ss = "0";
        StringBuilder sss = new StringBuilder(ss);
        sss.reverse();
        bin.setText(sss.toString());
        if(s.toString().equals("")){
            hex.setText("");
            oct.setText("");
        }
        else {
            hex.setText(Long.toHexString(ddd).toUpperCase());
            oct.setText(Long.toOctalString(ddd));
        }
    }
}
