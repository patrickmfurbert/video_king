package com.paychex.moviemetadataservicepyx.utils;

// returns int with One's digit to zero if greater than 0, else return -1
public class ConvertToDecade {
    public static int LastDigitToZero(int num){
        if(num >= 0){
            return num - num%10;
        }
        return -1;
    }
}
