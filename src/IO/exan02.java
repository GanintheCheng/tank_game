package IO;

import java.io.*;

/*
2.编程题Homework02.java
要求:使用BufferedReader读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上。
//如果老韩把文件的编码改成了 gbk,出现中文乱码,大家思考如何解决/1.默认是按照utf-8处理,开始没有乱码
//2.提示:使用我们的转换流，将FilelnputStream -> InputStreamReader[可以指定编码-> BufferedReader ...

 */
public class exan02 {
    public static void main(String[] args)throws IOException {
        String a= new String("C:\\learnio\\mytemp\\hello.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(a));
        String temp="";
//        while((temp=bufferedReader.readLine())!=null){
//            System.out.println(temp);
//        }
        InputStreamReader inn = new InputStreamReader(new FileInputStream(a),"gbk");
        BufferedReader in = new BufferedReader(inn);
        while ((temp=in.readLine())!=null){
            System.out.println(temp);
        }
    }
}
