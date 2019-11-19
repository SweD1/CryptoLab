package com.company;

import java.io.UnsupportedEncodingException;

public class GOST {
    private static int[][] substituationBlock = {{4,14,5,7,6,4,13,1},
                                            {10,11,8,13,12,11,11,15},
                                             {9,4,1,10,7,10,4,13},
                                             {2,12,13,1,1,0,1,0},
                                             {13,6, 10,0,5,7,3,5},
                                             {8,13,3,8,15,2,15,7},
                                             {0,15,4,9,13,1,5,10},
                                             {14,10,2,15,8,13,9,4},
                                             {6,2,14,14,4,3,0,9},
                                             {11,3,15,4,10,6,10,2},
                                             {1,8,12,6,9,8,14,3},
                                             {12,1,7,12,14,5,7,14},
                                             {7,0,6,11,0,9,6,6},
                                             {15,7,0,2,3,12,8,11},
                                             {5,5,9,5,11,15,2,8},
                                             {3,9,11,3,2,14,12,12}};
    public void run(String text,String key) throws UnsupportedEncodingException {
        ToBinary toBinary=new  ToBinary();
        byte[] inputByte= toBinary.toBi(text);
        byte[] inputByteKey = toBinary.toBi(key);
        String inputTextByte =outputByteArray(inputByte);
        String X0 = outputByteArray(inputByteKey);
        String L0 = inputTextByte.substring(0,32);
        String R0 = inputTextByte.substring(32);
        System.out.println("L0 "+L0);
        System.out.println("R0 "+R0);
        System.out.println("X0 "+X0);
        long summaryR0X0 =(Long.parseLong(R0,2)+Long.parseLong(X0,2));
        String sum = (Long.toBinaryString(summaryR0X0)).substring(1);
        System.out.println("X0+R0="+sum);
        String afterSwap = swapAlgotithm(sum);
        //System.out.println(" "+afterSwap);
        String shift = afterSwap.substring(11)+afterSwap.substring(0,11);
        //System.out.println(shift);
        String cryptoText = moduloAdditionTwo(L0,shift);
        System.out.println("Шифротекст: " + cryptoText);
    }
    private static String outputByteArray(byte[] array){
        String s = "";
        for(byte x:array){
             s += String.format("%8s",Integer.toBinaryString((x&0xFF)+0x100).substring(1));
        }
        return s;
    }
    private static String swapAlgotithm(String summary){
        String result = "";
        for (int i=7,c=0,k=4;i>=0;i--,k+=4,c+=4){
           String s= summary.substring(c,k);
           String intermediate = Integer.toBinaryString(substituationBlock[Integer.parseInt(s,2)][i]);
           for(;intermediate.length()<4;) {
               intermediate="0"+intermediate;
           }
           result+=intermediate;
        }
        return result;
    }
    private static String moduloAdditionTwo(String L0,String R0X0){
        String result = "";
        for (int i =0,c=0,k=1;i<L0.length();i++,k+=1,c+=1){
            int a = Integer.parseInt(L0.substring(c,k),2);
            int b = Integer.parseInt(R0X0.substring(c,k));
            int mod = (a+b)%2;
            result+= mod;
        }
        return result;
    }
}
