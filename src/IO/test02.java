package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test02 {
    public static void main(String[] args) {
        String a = new String("C:\\迅雷下载\\hello.text");
        File file = new File(a);
        int counts=0;
        FileOutputStream out=null;
        try {
            out=new FileOutputStream(a);
            while (counts<500) {
                out.write("da ge jiao xian".getBytes());
                counts++;
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("final语句");
        }
    }
}
