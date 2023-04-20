package IO;

import java.io.*;

public class test06 {
    public static void main(String[] args) {
        String a = new String("C:\\learnio\\test.txt");
        String b = new String("C:\\learnio\\hello.txt");
        BufferedReader in=null;
        BufferedWriter out=null;
        try {
        in=new BufferedReader(new FileReader(a));
        out=new BufferedWriter(new FileWriter(b));
        String temp="";
        while((temp=in.readLine())!=null){
            out.write(temp);
            out.newLine();
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
