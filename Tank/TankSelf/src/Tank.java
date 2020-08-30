import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x;
    private int y;
    private Dir dir;
    boolean bL, bR, bU, bD;
    private int speed;

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    public Tank(int x, int y, Dir dir, int speed) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.speed = speed;
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
        }
        setMainDir();
    }

    private void setMainDir() {
        if (bD != true && bU != true && bL != true && bR != true) {
            this.dir = Dir.STOP;
        } else if (bD == true && bU != true && bL != true && bR != true) {
            this.dir = Dir.DOWN;
        } else if (bD != true && bU == true && bL != true && bR != true) {
            this.dir = Dir.UP;
        } else if (bD != true && bU != true && bL == true && bR != true) {
            this.dir = Dir.LEFT;
        } else if (bD != true && bU != true && bL != true && bR == true) {
            this.dir = Dir.Right;
        }
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case Right:
                x+=speed;
                break;
        }
    }

    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
        }
        setMainDir();
    }
}
