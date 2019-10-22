package com.company;

import java.util.Arrays;

// task 4
public class Poligrammnii {
    public static void useRun(){
        System.out.println("\nРеализация полиграммного шифра");
        String inputtxt = "easylemon";
        int[][]alb = matrix();
        System.out.println(Arrays.deepToString(alb));
        int[] crypto = enCrypto(inputtxt,alb);
        System.out.print("\nШифротекст:");
        for(int x=0;x<crypto.length;x++){
            System.out.print(crypto[x]+" ");
        }
        String deCrypttxt = deCrypto(crypto,alb);
        System.out.println("\nДешифрованный текст:"+deCrypttxt);
    }
    public static int[] enCrypto(String inputtxt,int[][] alb){
        int len = inputtxt.length();
        if(len%2!=0){
            inputtxt=inputtxt+"z";
            len+=1;
        }
        char[] ch = new char[len];
        inputtxt.getChars(0, len, ch, 0);
        int[] crypto= new int[len/2];
        int p = 0;
        for(int sh=0;sh<ch.length;sh++){
            if (sh%2!=0){
                continue;
            }
            int cha1 = (int) ch[sh]-96;
            int sh1 = sh+1;
            int cha2 = (int) ch[sh1]-96;
            crypto[p]=alb[cha1][cha2];
            p++;
        }
        return crypto;
    }
    private static String deCrypto(int[] crypto,int[][] alb){
        String deCrypt = "";
        for(int element:crypto) {
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (element == alb[i][j]) {
                        char First = (char) (i + 96);
                        char Sec = (char) (j + 96);
                        deCrypt += Character.toString(First) + Character.toString(Sec);
                    }
                }
            }
        }
        return deCrypt;
    }
    private static int[][] matrix(){
        int[][] alb=new int[27][27];
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i =0;i<27;i++){
            for (int j=0;j<27;j++){
                if(i==0){
                    alb[i][j]=a;
                    a++;
                }else if(j==0){
                    alb[i][j]=b;
                    b++;
                }else{
                    alb[i][j]=c;
                    c++;
                }
             /* alb[i][j]=c;
              c++;*/
            }
        }
        return alb;
    }
}
