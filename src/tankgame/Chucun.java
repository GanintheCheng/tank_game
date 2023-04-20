package tankgame;

import java.io.*;

public class Chucun {
    File file = new File("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt");
    BufferedReader in;//=new BufferedReader(new FileReader("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
    BufferedWriter out;//=new BufferedWriter(new FileWriter("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));

    int grade = 0;
    static int times = 0;

    public void record(int res) throws IOException {
        if (res > grade) {
            grade = res;
            out.write(res + "");
        } else {
            out.write(grade + "");
        }
    }

    public int duqu() throws IOException {
        System.out.println("当前最高分为" + grade);
        return grade;
    }

    public void close() {
        try {
            out.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Chucun() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        in = new BufferedReader(new FileReader("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
        String temp = in.readLine();
        if (temp == null) grade = 0;
        else grade = Integer.parseInt(temp);
        out = new BufferedWriter(new FileWriter("C:\\Users\\~Ganinthe.Cheng\\IdeaProjects\\tank_game\\grade.txt"));
    }
}
