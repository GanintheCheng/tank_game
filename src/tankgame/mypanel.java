package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

public class mypanel extends JPanel implements KeyListener, Runnable {
    mytank hero;
    Chucun chucun = new Chucun();
    Vector<tank> tanks;
    static Vector<Boom> booms = new Vector<>();
    Image image = null;

    @Override
    public void run() {
        Vector<zidan> zds = hero.zds;

        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();
            for (zidan zd : zds) {
                for (tank othertank : tanks) {
                    othertank othertank1 = (othertank) othertank;
                    yesattackothertank(zd, othertank1);
                }
            }
            for (int i = 0; i < tanks.size(); i++) {
                othertank othertank = (othertank) tanks.get(i);
                for (int j = 0; j < othertank.zidans.size(); j++) {
                    yesattackmytank(othertank.zidans.get(j));
                }
            }

            over();
            if (hero.x > 900) hero.x = 900;
            if (hero.x < 70) hero.x = 70;
            if (hero.y > 650) hero.y = 650;
            if (hero.y < 70) hero.y = 70;
        }
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    int nums = 5;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int choice = e.getKeyCode();
        switch (choice) {
            case KeyEvent.VK_DOWN, 'S', 's' -> {
                hero.y += hero.speed;
                hero.dirct = KeyEvent.VK_DOWN;
            }
            case KeyEvent.VK_UP, 'W', 'w' -> {
                hero.y -= hero.speed;
                hero.dirct = KeyEvent.VK_UP;
            }
            case KeyEvent.VK_LEFT, 'A', 'a' -> {
                hero.x -= hero.speed;
                hero.dirct = KeyEvent.VK_LEFT;
            }
            case KeyEvent.VK_RIGHT, 'd', 'D' -> {
                hero.x += hero.speed;
                hero.dirct = KeyEvent.VK_RIGHT;
            }
            case 'j', 'J' -> {
                hero.shot();
            }
        }
        System.out.println((char) choice);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public mypanel() throws IOException {

        chucun.duqu();
        image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\out\\production\\tank_game\\img.gif");
        hero = new mytank(100, 100, 38, 0);
        tanks = new Vector<>();
        for (int i = 0; i < nums; i++) {
            int temp = 0;
            do {
                temp = (int) (Math.random() * 5);
            } while (temp == 0);
            if (temp == 1) temp = KeyEvent.VK_UP;
            else if (temp == 2) temp = KeyEvent.VK_RIGHT;
            else if (temp == 3) temp = KeyEvent.VK_DOWN;
            else if (temp == 4) temp = KeyEvent.VK_LEFT;
            othertank othertank = new othertank(200 + 100 * i, 100, temp, 1);
            tanks.add(othertank);
            new Thread(othertank).start();
            zidan zd = null;
            switch (temp) {
                case KeyEvent.VK_UP -> {
                    zd = new zidan(othertank.x + 5, othertank.y, othertank.speed / 2, temp);//x + 20, y
                }
                case KeyEvent.VK_RIGHT -> {
                    zd = new zidan(othertank.x + 50, othertank.y + 5, othertank.speed / 2, temp);//x + 50, y + 30
                }
                case KeyEvent.VK_DOWN -> {
                    zd = new zidan(othertank.x + 5, othertank.y + 60, othertank.speed / 2, temp);//x + 20, y + 60
                }
                case KeyEvent.VK_LEFT -> {
                    zd = new zidan(othertank.x - 10, othertank.y + 5, othertank.speed / 2, temp);//(x + 20, y + 30, x - 10, y + 30)
                }
            }
            othertank.zidans.add(zd);
            new Thread(zd).start();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        g.drawImage(image, 1, 1, 1, 1, this);
        if (hero.cunhuo) drawtank(hero.x, hero.y, hero.dirct, hero.type, g);
        for (int i = 0; i < hero.zds.size(); i++) {
            zidan ZD = hero.zds.get(i);
            if (ZD != null && ZD.cunhuo) {
                g.setColor(Color.cyan);
                drawzd(g, ZD);
            } else {
                hero.zds.remove(ZD);
            }
        }

        for (int j = 0; j < tanks.size(); j++) {
            othertank nowtank = (othertank) tanks.get(j);
            if (nowtank.cunhuo) drawtank(nowtank.x, nowtank.y, nowtank.dirct, nowtank.type, g);
            else if (nowtank.zidans.size() == 0) {
                tanks.remove(nowtank);
            }else{
                tanks.remove(nowtank);
            }
            for (int i = 0; i < nowtank.zidans.size(); i++) {
                if (nowtank.zidans.get(i).cunhuo) {
                    g.setColor(Color.yellow);
                    drawzd(g, nowtank.zidans.get(i));
                } else {
                    nowtank.zidans.remove(nowtank.zidans.get(i));
                }
            }
            if (nowtank.zidans.size() == 0) {
                int temp = nowtank.dirct;
                zidan zd = null;
                switch (temp) {
                    case KeyEvent.VK_UP -> {
                        zd = new zidan(nowtank.x + 5, nowtank.y, nowtank.speed / 2, temp);//x + 20, y
                    }
                    case KeyEvent.VK_RIGHT -> {
                        zd = new zidan(nowtank.x + 50, nowtank.y + 5, nowtank.speed / 2, temp);//x + 50, y + 30
                    }
                    case KeyEvent.VK_DOWN -> {
                        zd = new zidan(nowtank.x + 5, nowtank.y + 60, nowtank.speed / 2, temp);//x + 20, y + 60
                    }
                    case KeyEvent.VK_LEFT -> {
                        zd = new zidan(nowtank.x - 10, nowtank.y + 5, nowtank.speed / 2, temp);//(x + 20, y + 30, x - 10, y + 30)
                    }
                }
                new Thread(zd).start();
                nowtank.zidans.add(zd);
            }
        }

        for (int i = 0; i < booms.size(); i++) {
            Boom boom = booms.get(i);
            drawboom(g, boom);
            boom.life--;
            if (boom.life == 0) boom.cunhuo = false;
            if (!(boom.cunhuo)) booms.remove(boom);
        }

    }

    /*
    @param type 1:敌人 0：自己
     */
    public void drawtank(int x, int y, int dirct, int type, Graphics g) {
        if (type == 0) {
            g.setColor(Color.cyan);
        } else if (type == 1) {
            g.setColor(Color.yellow);
        }
        switch (dirct) {
            case KeyEvent.VK_UP -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.drawRect(x + 10, y + 10, 20, 40);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawLine(x + 20, y + 30, x + 20, y);
            }
            case KeyEvent.VK_RIGHT -> {
                g.fill3DRect(x - 10, y + 10, 60, 10, false);
                g.drawRect(x, y + 20, 40, 20);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.drawLine(x + 20, y + 30, x + 50, y + 30);
            }
            case KeyEvent.VK_DOWN -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.drawRect(x + 10, y + 10, 20, 40);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
            }
            case KeyEvent.VK_LEFT -> {
                g.fill3DRect(x - 10, y + 10, 60, 10, false);
                g.drawRect(x, y + 20, 40, 20);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.drawLine(x + 20, y + 30, x - 10, y + 30);
            }
            default -> {
            }
        }
//        repaint();
    }

    public void drawboom(Graphics g, Boom boom) {
        g.drawImage(image, boom.x, boom.y, 30, 30, this);
    }

    public void drawzd(Graphics g, zidan zd) {
        g.draw3DRect(zd.x, zd.y, 10, 10, false);
    }

    public static void yesattackothertank(zidan zd, othertank tank) {
        int dirct = tank.dirct;
        int x = zd.x;
        int y = zd.y;
        boolean yes = tank.cunhuo;
        Boom boom = null;
        switch (dirct) {
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> {
                if (tank.x < x && x < tank.x + 40 && y > tank.y && y < tank.y + 60 && yes) {
                    tank.cunhuo = false;
                    zd.cunhuo = false;
                    boom = new Boom(x, y);
                    booms.add(boom);
                }
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> {
                if (tank.x < x && x < tank.x + 60 && y > tank.y && y < tank.y + 40 && yes) {
                    tank.cunhuo = false;
                    zd.cunhuo = false;
                    boom = new Boom(x, y);
                    booms.add(boom);
                }
            }
        }
    }

    public void yesattackmytank(zidan zd) {
        int dirct = hero.dirct;
        int x = zd.x;
        int y = zd.y;
        boolean yes = hero.cunhuo;
        Boom boom = null;
        switch (dirct) {
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> {
                if (hero.x < x && x < hero.x + 40 && y > hero.y && y < hero.y + 60 && hero.cunhuo) {
                    hero.cunhuo = false;
                    zd.cunhuo = false;
                    boom = new Boom(x, y);
                    booms.add(boom);
                }
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> {
                if (hero.x < x && x < hero.x + 60 && y > hero.y && y < hero.y + 40 && hero.cunhuo) {
                    hero.cunhuo = false;
                    zd.cunhuo = false;
                    boom = new Boom(x, y);
                    booms.add(boom);
                }
            }
        }
    }

    public void over(){
        if(!hero.cunhuo){
            System.out.println("您寄了");
            chucun.record(othertank);
            System.exit(0);
        }
        if(tanks.size()==0){
            System.out.println("您win麻了");
            System.exit(0);
        }
    }
}
