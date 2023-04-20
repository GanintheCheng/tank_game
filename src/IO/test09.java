package IO;

import java.io.*;

public class test09 {
    public static void main(String[] args) throws IOException {
        String a= new String("C:\\learnio\\test.txt");
        BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(a)));
        String line="";
        while((line=in.readLine())!=null){
            System.out.println(line);
        }
        in.close();
    }
}
