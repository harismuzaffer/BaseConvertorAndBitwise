package com.dreamcode.converter;

/**
 * Created by ADMINIBM on 11/22/2017.
 */

public class StringUtility {


    public static String insertCommas(StringBuilder s){

        StringBuilder withCommas = s;
        if(withCommas.length() > 4){
            withCommas.insert(4, ',');
            for(int i= 6; i< withCommas.length(); i++){
                if((i+1) % 5 ==0)
                withCommas.insert(i, ',');
            }
        }
        return withCommas.toString();

    }
}
