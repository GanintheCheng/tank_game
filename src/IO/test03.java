package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class test03 {
    public static void main(String[] args) {
        String a = new String("C:\\迅雷下载\\hello.text");
        File file = new File(a);
        String b = new String("C:\\迅雷下载\\hello2.text");
        byte[] data = new byte[20];
        int length = 0;
        FileInputStream in = null;
        FileOutputStream out =null;
        try {
            in=new FileInputStream(a);
            out=new FileOutputStream(b,true);
            while((length=in.read(data))!=-1){
                out.write(data,0,length);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
