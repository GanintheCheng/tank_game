package tankgame;

import java.awt.event.KeyEvent;
import java.util.Vector;

public class othertank extends tank implements Runnable {
    public othertank(int x, int y, int dirct, int type) {
        super(x, y, dirct, type);
    }

    Vector<zidan> zidans = new Vector<>();

    @Override
    public void run() {
        while (cunhuo) {
            int temp = 0;
            do {
                temp = (int) (Math.random() * 5);
            } while (temp == 0);
            if (temp == 1) {
                dirct = KeyEvent.VK_UP;
                for (int i = 0; i < 30; i++) {
                    y -= 1;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            } else if (temp == 2) {
                dirct = KeyEvent.VK_RIGHT;
                for (int i = 0; i < 30; i++) {
                    x += 1;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            } else if (temp == 3) {
                dirct = KeyEvent.VK_DOWN;
                for (int i = 0; i < 30; i++) {
                    y += 1;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            } else if (temp == 4) {
                dirct = KeyEvent.VK_LEFT;
                for (int i = 0; i < 30; i++) {
                    x -= 1;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
            if (x < 50) x = 50;
            if (y < 50) y = 50;
            if (x > 900) x = 900;
            if (y > 600) y = 600;

        }


    }


    boolean cunhuo = true;

    public int type = 1;
    public int speed = 10;

    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }
}
