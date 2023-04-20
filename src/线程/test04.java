package 线程;


import java.util.Scanner;

/*(1)在main方法中启动两个线程
(2)第1个线程循环随机打印100以内的整数(3)直到第2个线程从键盘读取了
'Q”命令。
 */
public class test04 {
    public static void main(String[] args)  {
        Thread01 thread01 = new Thread01();
        thread01.setDaemon(true);
        thread01.start();
        new Thread02(thread01).start();
    }
}

class Thread01 extends Thread{
    int counts=0;
    boolean yes=true;
    @Override
    public void run() {
        while (++counts<=100&&yes){
            System.out.println("counts="+counts);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Thread02 extends Thread{
    Thread01 ot;

    public Thread02(Thread01 ot) {
        this.ot = ot;
    }

    @Override
    public void run() {
        System.out.println("请输入字符");
        Scanner in = new Scanner(System.in);
        while (ot.yes){
            String temp=in.next();
            if(temp!=null&&temp.equals("Q")) break;
            System.out.println("输入错误继续");
        }
        ot.yes=false;
        System.out.println("02退出~");
    }
}