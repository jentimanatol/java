import java.awt.*;
import javax.swing.*;

public class InvestmentGraph extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the original investment function (example line)
        g2d.drawLine(100, 500, 500, 100);
        g2d.drawString("Original Investment Function", 510, 110);

        // Draw the new investment function (shifted line)
        g2d.drawLine(100, 550, 500, 150);
        g2d.drawString("New Investment Function", 510, 160);

        // Draw axes
        g2d.drawLine(100, 600, 100, 0); // Y-axis
        g2d.drawLine(100, 600, 600, 600); // X-axis

        // Label axes
        g2d.drawString("Interest Rate (%)", 300, 630);
        g2d.drawString("Planned Real Investment ($ Trillion)", 10, 20);

        // Draw numerical scale for Y-axis (Interest Rate)
        for (int i = 0; i <= 10; i++) {
            int y = 600 - (i * 50);
            g2d.drawLine(95, y, 100, y);
            g2d.drawString(i * 1 + "%", 60, y + 5);
        }

        // Draw numerical scale for X-axis (Planned Real Investment)
        for (int i = 0; i <= 10; i++) {
            int x = 100 + (i * 50);
            g2d.drawLine(x, 600, x, 605);
            g2d.drawString(i * 0.5 + "T", x - 10, 620);
        }

        // Draw legend
        g2d.drawString("Legend:", 10, 650);
        g2d.drawString("Original Investment Function", 10, 665);
        g2d.drawString("New Investment Function", 10, 680);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Investment Function");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.add(new InvestmentGraph());
        frame.setVisible(true);
    }
}
