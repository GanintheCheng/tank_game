package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test04 {
    public static void main(String[] args) {
        FileInputStream in=null;
        FileOutputStream out=null;
        String str_in="C:\\learnio\\视频1.mp4";
        String str_out="C:\\learnio\\视频2.mp4";
        byte[] a=new byte[1024];

        try {
            in=new FileInputStream(str_in);
            out=new FileOutputStream(str_out);
            int length=0;

            while((length=in.read(a))!=-1){
                out.write(a,0,length);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束~");
    }
}
