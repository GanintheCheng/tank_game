package IO;

import java.io.*;
import java.util.Scanner;

public class test05 {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out=null;
        String str = "C:\\learnio\\test.txt";
        String str2 = "C:\\learnio\\test2.txt";
        char[] res = new char[100];
        int length = 0;
        StringBuffer RES=new StringBuffer();

        

        try {
            in = new FileReader(str);
            out=new FileWriter(str2,true);
            while ((length = in.read(res)) != -1) {
                RES.append(res,0,length);
                out.write(res,0,length);
            }
            in.close();
            out.close();
        } catch (Exception E) {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("寄");
        }
    }
}
