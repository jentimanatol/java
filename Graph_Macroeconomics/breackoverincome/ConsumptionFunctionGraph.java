import javax.swing.*;
import java.awt.*;

public class ConsumptionFunctionGraph extends JPanel {
    private int[] income = {0, 1000, 2000, 3000, 4000};
    private int[] consumption = {400, 1200, 2000, 2800, 3600};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw axes
        g2.drawLine(50, 50, 50, 400); // Y-axis
        g2.drawLine(50, 400, 400, 400); // X-axis

        // Draw labels
        g2.drawString("Disposable Income ($)", 200, 450);
        g2.drawString("Consumption ($)", 10, 30);

        // Draw numbers on axes
        for (int i = 0; i <= 4000; i += 1000) {
            g2.drawString(String.valueOf(i), 50 + i / 10, 420); // X-axis numbers
        }
        for (int i = 0; i <= 4000; i += 1000) {
            g2.drawString(String.valueOf(i), 30, 400 - i / 10); // Y-axis numbers
        }

        // Draw data points and lines
        for (int i = 0; i < income.length - 1; i++) {
            int x1 = 50 + income[i] / 10;
            int y1 = 400 - consumption[i] / 10;
            int x2 = 50 + income[i + 1] / 10;
            int y2 = 400 - consumption[i + 1] / 10;

            g2.fillOval(x1 - 2, y1 - 2, 4, 4);
            g2.drawLine(x1, y1, x2, y2);
        }

        // Draw labels for data points
        for (int i = 0; i < income.length; i++) {
            int x = 50 + income[i] / 10;
            int y = 400 - consumption[i] / 10;
            g2.drawString("(" + income[i] + ", " + consumption[i] + ")", x + 5, y - 5);
        }

        // Draw breakeven point
        int breakevenX = 50 + 2000 / 10;
        int breakevenY = 400 - 2000 / 10;
        g2.setColor(Color.RED);
        g2.fillOval(breakevenX - 4, breakevenY - 4, 8, 8);
        g2.drawString(" .    Breakeven (2000, 2000)", breakevenX + 20, breakevenY - 30);
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
