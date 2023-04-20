package IO;

import java.io.*;
import java.util.Properties;

/*
3.编程题HomeworkO3.java 5min(1)要编写一个dog.properties
name=tom
age=5
color=red
(2)编写Dog 类(name,age,color)创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化，并输出
(3)将创建的Dog对象，序列化到文件dog.dat文件


 */

public class exam03 {
    public static void main(String[] args)throws Exception {
        String a="src\\\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(a));

        String name=properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));

        dog dog = new dog(age,name);

        ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("C:\\learnio\\mytemp\\dog.dat"));
        obj.writeObject(dog);
        System.out.println("序列化~");
        obj.close();

        ObjectInputStream objin=new ObjectInputStream(new FileInputStream("C:\\learnio\\mytemp\\dog.dat"));
        System.out.println("反序列化~");
        System.out.println(objin.readObject());
        objin.close();
    }
}
class dog implements Serializable{
    int age;
    String name;

    public dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}