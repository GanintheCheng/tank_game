package tankgame;

import java.io.*;

public class Chucun {
    File file=new File("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt");
    BufferedReader in;//=new BufferedReader(new FileReader("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
    BufferedWriter out;//=new BufferedWriter(new FileWriter("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));

    int grade=0;

    public void record(int res) throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
        String temp=in.readLine();
        if(temp.equals(""))grade=0;else grade=Integer.parseInt(temp);
        if(res>grade){
            grade=res;
            out.write(res);
        }
    }

    public void duqu() throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
        String temp=in.readLine();
        if(temp==null)grade=0;else grade=Integer.parseInt(temp);
        System.out.println("当前最高分为"+grade);
    }
    public Chucun() throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
        in=new BufferedReader(new FileReader("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
        out=new BufferedWriter(new FileWriter("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
    }
}
