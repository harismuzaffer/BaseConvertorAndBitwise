package com.dreamcode.baseconvertor;

/**
 * Created by ADMINIBM on 11/16/2017.
 */

public class ConvertBase {

    public static long convertToBinary(String s){
        String num= s;
        long l=0;
        for(int i= num.length()-1; i>=0; i--){
            if(num.charAt(num.length()-i-1)=='1'){
                int j=i;
                long sum=1;
                while(j!=0){
                    sum*= 2;
                    j--;
                }
                l+= sum;
            }
        }
        return l;
    }
}
