package tankgame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class zidan implements Runnable{
    int x,y,speed=2,dirct;
    boolean cunhuo=true;

    public zidan(int x, int y, int speed,int dirct) {
        this.x = x + 10;
        this.y = y + 20;
        this.speed = speed;
        this.dirct=dirct;
    }

    @Override
    public void run() {
        while(cunhuo){
//            System.out.println("x="+x+" y="+y);
            try {
                Thread.sleep(100);//刷新时间
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (dirct){
                case KeyEvent.VK_RIGHT -> x+=speed;
                case KeyEvent.VK_DOWN -> y+=speed;
                case KeyEvent.VK_LEFT -> x-=speed;
                case KeyEvent.VK_UP -> y-=speed;
            }
            if(x<=0||y<=0||x>=1000||y>=750){
                cunhuo=false;
//                System.out.println("子弹寄");
                break;
            }
        }

    }
}
