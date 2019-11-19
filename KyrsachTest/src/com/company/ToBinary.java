package com.company;
import java.io.UnsupportedEncodingException;
//Данный класс нужен для получения бит в соответствии с таблицей задания
public class ToBinary {
    public static byte[] toBi(String str) throws UnsupportedEncodingException {
        int len = str.length();
        char[] ch = new char[len];
        byte[] textByte = new byte[len];
        str.getChars(0, len, ch, 0);
        for (int i=0;i<len;i++) {
            int number = (int) ch[i];
            //System.out.print(number+" ");
            if (number >= 1040 && number <= 1103) {
                int newnumber = number - 848;
                textByte[i]=(byte) newnumber;
            }else {
            textByte[i]=(byte) number;
            }
        }
        return textByte;
    }
}
