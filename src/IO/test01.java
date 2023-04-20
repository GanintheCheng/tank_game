package IO;

import java.io.*;
import java.util.HashMap;

public class test01 {
    public static void main(String[] args) {
        String a = new String("C:\\迅雷下载\\");
        File test=new File(a,"hello.text");
        FileInputStream fileInputStream = null;
        int temp=0;
        byte[] A=new byte[8];
        try {
//            test.createNewFile();
            fileInputStream=new FileInputStream("C:\\迅雷下载\\hello.text");
            while ((temp=fileInputStream.read(A))!=-1) {
                System.out.print(new String(A,0,temp));
            }
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("寄");
            throw new RuntimeException(e);
        }

        System.out.println(test.length());
    }
}
