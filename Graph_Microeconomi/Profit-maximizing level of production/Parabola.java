import java.awt.*;
import javax.swing.*;

public class Parabola extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double SCALE = 50;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw axes
        g.drawLine(0, HEIGHT, WIDTH, HEIGHT);
        g.drawLine(0, HEIGHT, 0, 0);

        // Draw parabola (y^2 = 4ax)
        double a = 1.0;
        for (int y = 0; y < HEIGHT; y++) {
            int x = (int) (SCALE * (4 * a * Math.pow(y / SCALE, 2)));
            if (x >= 0 && x <= WIDTH) {
                g.fillOval(x, HEIGHT - y, 2, 2);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.add(new Parabola());
        frame.setVisible(true);
    }
}
