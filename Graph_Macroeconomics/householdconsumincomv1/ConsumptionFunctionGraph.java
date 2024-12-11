import javax.swing.*;
import java.awt.*;

public class ConsumptionFunctionGraph extends JPanel {
    private int[] income = {0, 100, 200, 300, 400, 500};
    private int[] consumption = {225, 300, 375, 450, 525, 600};
    private double[] apc = {Double.NaN, 3.00, 1.88, 1.50, 1.31, 1.20};
    private double[] mpc = {Double.NaN, 0.75, 0.75, 0.75, 0.75, 0.75};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw axes
        g2.drawLine(50, 50, 50, 400); // Y-axis
        g2.drawLine(50, 400, 400, 400); // X-axis

        // Draw labels
        g2.drawString("Disposable Income ($ billions)", 200, 450);
        g2.drawString("Consumption ($ billions)", 10, 30);

        // Draw numbers on axes
        for (int i = 0; i <= 500; i += 100) {
            g2.drawString(String.valueOf(i), 50 + i, 420); // X-axis numbers
        }
        for (int i = 0; i <= 600; i += 100) {
            g2.drawString(String.valueOf(i), 30, 400 - i); // Y-axis numbers
        }

        // Draw data points and lines
        for (int i = 0; i < income.length - 1; i++) {
            int x1 = 50 + income[i];
            int y1 = 400 - consumption[i];
            int x2 = 50 + income[i + 1];
            int y2 = 400 - consumption[i + 1];

            g2.fillOval(x1 - 2, y1 - 2, 4, 4);
            g2.drawLine(x1, y1, x2, y2);
        }

        // Draw labels for data points
        for (int i = 0; i < income.length; i++) {
            int x = 50 + income[i];
            int y = 400 - consumption[i];
            g2.drawString("(" + income[i] + ", " + consumption[i] + ")", x + 5, y - 5);
        }

        // Draw APC and MPC labels
        for (int i = 1; i < income.length; i++) {
            int x = 50 + income[i];
            int y = 400 - consumption[i];
            g2.drawString("APC: " + String.format("%.2f", apc[i]), x + 5, y + 15);
            g2.drawString("MPC: " + String.format("%.2f", mpc[i]), x + 5, y + 30);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Consumption Function Graph");
        ConsumptionFunctionGraph panel = new ConsumptionFunctionGraph();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
