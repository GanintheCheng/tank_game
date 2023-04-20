package tankgame;

public class tank {
    int x;
    int y;

    int dirct;
    public int type;

    public void setDirct(int dirct) {
        this.dirct = dirct;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public tank(int x, int y, int dirct, int type) {
        this.x = x;
        this.y = y;
        this.dirct = dirct;
        this.type = type;
    }
}
