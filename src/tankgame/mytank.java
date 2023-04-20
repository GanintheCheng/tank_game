package tankgame;

import java.awt.event.KeyEvent;
import java.util.Vector;

public class mytank extends tank {
    int type=0;
    boolean cunhuo=true;
    int speed=10;
    zidan zd;
    Vector<zidan> zds=new Vector<>();
    int zidannums=0;
    public void shot(){
        if(zds.size()==5){
            return;
        }
        switch (dirct){
            case KeyEvent.VK_UP -> {
                zd = new zidan(x+5, y, speed/2, dirct);//x + 20, y
            }
            case KeyEvent.VK_RIGHT -> {
                zd = new zidan(x+50, y+5, speed/2, dirct);//x + 50, y + 30
            }
            case KeyEvent.VK_DOWN -> {
                zd = new zidan(x+5, y+60, speed/2, dirct);//x + 20, y + 60
            }
            case KeyEvent.VK_LEFT -> {
                zd = new zidan(x-10, y+5, speed/2, dirct);//(x + 20, y + 30, x - 10, y + 30)
            }
        }
        zds.add(zd);
        new Thread(zd).start();
    }

    public mytank(int x, int y, int dirct, int type) {
        super(x, y, dirct, type);
    }
}
