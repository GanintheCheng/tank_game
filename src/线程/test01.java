package 线程;

import java.util.LinkedList;

public class test01 {
    public static void main(String[] args) {
//        Sell01 sell01 = new Sell01();
//        new Thread(sell01).start();
//        new Thread(sell01).start();
//        new Thread(sell01).start();
        new Sell02().start();
        new Sell02().start();
        new Sell02().start();
    }
}

class Sell01 implements Runnable {
    private int nums = 100;

    @Override
    public void run() {
        while (true) {
          synchronized (this) {
                if (nums <= 0) {
                    System.out.println("卖完了");
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "卖了一张，还剩下" + --nums);
            }
        }
    }

    public void sell() {
        System.out.println("卖了一张票");
        nums--;
    }
}

class Sell02 extends Thread{
    private static int nums=100;
    boolean bool =true;
    synchronized public static void sell(){
        System.out.println(Thread.currentThread().getName()+"卖出一张，还剩下"+--nums);
    }

    @Override
    public void run() {
        while (bool){
            synchronized ("hi"){if(nums<=0)break;}
            sell();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println("休眠时程序出错");
            }
        }
        System.out.println(Thread.currentThread().getName()+"卖完了");
    }
}