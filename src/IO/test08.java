package IO;

import java.io.*;
import java.util.Scanner;

public class test08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String a = new String("C:\\learnio\\tttt.dat");
//        String b = new String("C:\\learnio\\test3.txt");

        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(a,true));
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(a));
//        out.writeInt(100);
//        out.writeObject(new aa());
        System.out.println(in.readInt());
        System.out.println(in.readObject());
        out.close();
        in.close();
    }
}

class aa implements Serializable{
    @Override
    public String toString() {
        return "感觉不如原神";
    }
}