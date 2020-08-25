import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame f = new TankFrame();
        f.setVisible(true);
        for (; ; ) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.repaint();
        }
    }
}
