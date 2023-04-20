package tankgame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Gogame extends JFrame {
    mypanel panel=null;
    public void init() throws IOException {
        panel=new mypanel();
        new Thread(panel).start();
        this.add(panel);
        this.addKeyListener(panel);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Gogame(String name) throws HeadlessException, IOException {
        super(name);
        init();

    }

    public static void main(String[] args) throws IOException {
        new Gogame("坦克大战");

    }
}
