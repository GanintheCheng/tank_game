package 线程;

import java.util.Comparator;
import java.util.Scanner;

/*(1)有2个用户分别从同一个卡上取钱(总额:10000)(2)每次都取1000,当余额不足时,就不能取款了(3)不能出现超取现象=》线程同步问题.
*/
public class test05 {
    public static void main(String[] args) {
        new Yonghu().start();
        new Yonghu().start();
    }
}
class Yonghu extends Thread{
    static int amount=100000;

    @Override
    public void run() {
        System.out.println(getName()+"进入银行");
        while(true){
            synchronized ("SUO"){if(amount<=0)break;}
            while (true) {
                int temp=(int)(Math.random()*1000);
                if(temp>amount)continue;
                System.out.println(getName()+"取钱,还剩下"+(amount-=temp));
                break;
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName()+"走了");
    }
}