package IO;


import java.io.*;

/*
1.编程题Homework01.java 5min一定要自己做.
(1)在判断C:\learnio盘下是否有文件夹mytemp,如果没有就创建mytemp
(2)在C:\learnio\mytemp目录下,创建文件 hello.txt
(3)如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了(4)并且在hello.txt文件中，写入hello,world

 */
public class exam01 {
    public static void main(String[] args) throws IOException {
        String str1="C:\\learnio\\mytemp";
        File file = new File(str1);
        if(!file.exists()){
            if(file.mkdirs()){
                System.out.println("成功创建");
            }
        }else{
            System.out.println("文件夹已存在");
        }
        String str2=str1+"\\hello.txt";
        File file1 = new File(str2);
        BufferedOutputStream out=null;
        if(!file1.exists()){
            out=new BufferedOutputStream(new FileOutputStream(str2));
            out.write("hello,world".getBytes());
        }else{
            System.out.println("hello.txt已存在");
        }

        BufferedReader in=new BufferedReader(new FileReader(str2));
        if(out!=null)out.close();
        String temp="";
        System.out.println("读取后");
        while((temp=in.readLine())!=null){
            System.out.println(temp);
        }


        in.close();
    }
}
