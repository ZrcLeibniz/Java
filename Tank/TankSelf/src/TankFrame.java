import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private Tank mainTank;

    public TankFrame() {
         this.setTitle("Tank War");
         this.setSize(800, 600);
         this.setLocation(600, 200);
         mainTank = new Tank(100, 100, Dir.STOP, 3);
         this.addKeyListener(new KeyTankListener());
    }

    @Override
    public void paint(Graphics g) {
        mainTank.paint(g);
    }

    private class KeyTankListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            mainTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            mainTank.keyReleased(e);
        }
    }

}
