package com.company;

public class HESH {
    public static int getHESH (int p, int q, int initialisationVector, String text){
        int n = p*q;
        //System.out.println("N=" + n);
        char[] lettersMas = new char[text.length()];
        text.getChars(0,text.length(),lettersMas,0);
        int[] letterNumbers = lettersIntoNumbers(lettersMas);
        int hesh = heshFunction(letterNumbers,initialisationVector,n);
        return hesh;
    }
    private static int heshFunction (int[] letterNumbers, int initialisationVector, int n){
        int result = initialisationVector;
        for (int letterNumber : letterNumbers) {
            result = (int) (Math.pow(result + letterNumber, 2) % n);
        }
        return result;
    }
    private static int[] lettersIntoNumbers(char[] lettersMas){
        int[] letterNumbers = new int[lettersMas.length];
        for (int i = 0;i<letterNumbers.length;i++){
            letterNumbers[i]= (int) lettersMas[i]-848;
            //if(letterNumbers[i]>=7){
            //    letterNumbers[i]+=1;
            //}
        }
        return letterNumbers;
    }
}
