package IO;

import java.io.*;

public class test07 {
    public static void main(String[] args) {
        String a = new String("C:\\learnio\\test.txt");
        String b = new String("C:\\learnio\\test3.txt");
        BufferedInputStream in=null;
        BufferedOutputStream out=null;
        try {
            in=new BufferedInputStream(new FileInputStream(a));
            out=new BufferedOutputStream(new FileOutputStream(b,false));
            byte []res=new byte[1024];
            int length=0;
            while((length=in.read(res))!=-1){
                out.write(res,0,length);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

