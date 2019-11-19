package com.company;

import java.math.BigInteger;

public class Esignature {
    public static BigInteger getEsignature (int close, int n, int hesh){
        BigInteger closeKey = BigInteger.valueOf(close);
        BigInteger Hesh = BigInteger.valueOf(hesh);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger eSignature = Hesh.modPow(closeKey,N);
        return eSignature;
    }
    public static void checkEsignature(int openKey, int n, BigInteger eSignature, int hesh){
        BigInteger open = BigInteger.valueOf(openKey);
        BigInteger hesH = BigInteger.valueOf(hesh);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger H = eSignature.modPow(open,N);
        if(H.equals(hesH)){
            System.out.println("Проверка пройдена");
        }else {
            System.out.println("Проверка не пройдена");
        }
    }
}
