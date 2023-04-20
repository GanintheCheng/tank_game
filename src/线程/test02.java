package 线程;

public class test02 {
    public static void main(String[] args) {
        new thread1(1).start();
        new thread1(0).start();
    }
}
class thread1 extends Thread{
    public static Object obj1=new Object();
    public static Object obj2=new Object();
    public int num1;

    public thread1(int num1) {
        this.num1 = num1;
    }
    public void run(){
        if(num1==1){
            synchronized (obj1){
                System.out.println(getName()+"进入到了job的if语句,使用了obj1");
                synchronized (obj2){
                    System.out.println(getName()+"使用了obj2");
                }
            }
        }else{
            synchronized (obj2){
                System.out.println(getName()+"进入到了job的if语句,使用了obj2");
                synchronized (obj1){
                    System.out.println(getName()+"使用了obj1");
                }
            }
        }
    }
}
