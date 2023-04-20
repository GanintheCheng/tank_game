import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main extends JFrame implements Runnable {//画框
    private final myPanel panel=new myPanel();

    @Override
    public void run() {
        this.add(panel);
        this.addKeyListener(panel);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public Main(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        Main main1 = new Main("睡觉");
        main1.setSize(400,300);
        new Thread(main1).start();
//        Main main2 = new Main("2");
//        new Thread(main2).start();
    }
}




class myPanel extends JPanel implements KeyListener {//画板
    public int x=10;
    public int y=10;



    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int choice=e.getKeyCode();
        switch (choice) {
            case KeyEvent.VK_DOWN -> y += 10;
            case KeyEvent.VK_UP -> y -= 10;
            case KeyEvent.VK_LEFT -> x -= 10;
            case KeyEvent.VK_RIGHT -> x += 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    @Override
    public void paint(Graphics g) {//画笔
        super.paint(g);//加载
        g.setColor(Color.blue);
//        g.drawRect(x,y,10,40);
//        g.drawRect(x+10,y+10,14,20);
//        g.drawOval(x+10,y+13,14,14);
//        g.drawRect(x+24,y,10,40);
//        g.drawLine(x+17,y+20,x+17,y);
//        g.fillRect(x+50,y+50,10,40);
//        g.drawRect(x+10+50,y+10+50,14,20);
//        g.fillOval(x+10+50,y+13+50,14,14);
//        g.fillRect(x+24+50,y+50,10,40);
//        g.drawLine(x+17+50,y+20+50,x+17+50,y+50);
        g.drawRect(x,y,10,60);
        g.drawRect(x+10,y+10,20,40);
        g.drawOval(x+10,y+20,20,20);
        g.drawRect(x+30,y,10,60);
        g.drawLine(x+20,y+30,x+20,y);
        g.drawRect(x+50,y+50,10,40);
        g.drawRect(x+10+50,y+10+50,14,20);
        g.drawOval(x+10+50,y+13+50,14,14);
        g.drawRect(x+24+50,y+50,10,40);
        g.drawLine(x+17+50,y+20+50,x+17+50,y+50);
    }
}
