import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PPCGraph extends JPanel {
    private int[] food = {8, 7, 5, 0};
    private int[] videoGames = {0, 8, 12, 18};
    private String[] labels = {"A", "B", "C", "D"};
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw grid
        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = 50; i <= 350; i += 25) {
            g2d.drawLine(i, 50, i, 250); // Vertical lines
            g2d.drawLine(50, i, 350, i); // Horizontal lines
        }

        // Draw axes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, 250, 350, 250); // X-axis
        g2d.drawLine(50, 250, 50, 50);   // Y-axis

        // Label axes
        g2d.drawString("Video Games", 320, 270);
        g2d.drawString("Food", 10, 60);

        // Plot points and label them with different colors
        for (int i = 0; i < food.length; i++) {
            int x = 50 + videoGames[i] * 15;
            int y = 250 - food[i] * 25;
            g2d.setColor(colors[i]);
            g2d.fillOval(x - 3, y - 3, 6, 6);
            g2d.drawString(labels[i] + " (" + videoGames[i] + ", " + food[i] + ")", x - 10, y - 10);
        }

        // Draw PPC curve using Path2D for smooth curve
        g2d.setColor(Color.BLACK);
        Path2D.Double ppcCurve = new Path2D.Double();
        ppcCurve.moveTo(50 + videoGames[0] * 15, 250 - food[0] * 25);
        for (int i = 1; i < food.length; i++) {
            int ctrlX = (50 + videoGames[i - 1] * 15 + 50 + videoGames[i] * 15) / 2;
            int ctrlY = (250 - food[i - 1] * 25 + 250 - food[i] * 25) / 2;
            ppcCurve.curveTo(ctrlX, ctrlY, ctrlX, ctrlY, 50 + videoGames[i] * 15, 250 - food[i] * 25);
        }
        g2d.draw(ppcCurve);

        // Label the curve
        g2d.drawString("PPC", 200, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PPC Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new PPCGraph());
        frame.setVisible(true);
    }
}
