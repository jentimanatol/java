import javax.swing.*;
import java.awt.*;

public class PPCGraphblackwhite extends JPanel {
    private int[] food = {8, 7, 5, 0};
    private int[] videoGames = {0, 8, 12, 18};
    private String[] labels = {"A", "B", "C", "D"};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw axes
        g2d.drawLine(50, 250, 350, 250); // X-axis
        g2d.drawLine(50, 250, 50, 50);   // Y-axis

        // Plot points and label them
        for (int i = 0; i < food.length; i++) {
            int x = 50 + videoGames[i] * 15;
            int y = 250 - food[i] * 25;
            g2d.fillOval(x - 3, y - 3, 6, 6);
            g2d.drawString(labels[i], x - 10, y - 10);
        }

        // Draw PPC curve
        g2d.drawLine(50, 250, 170, 75); // A to B
        g2d.drawLine(170, 75, 230, 150); // B to C
        g2d.drawLine(230, 150, 320, 250); // C to D

        // Label the curve
        g2d.drawString("PPC", 200, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PPC Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new PPCGraphblackwhite());
        frame.setVisible(true);
    }
}
