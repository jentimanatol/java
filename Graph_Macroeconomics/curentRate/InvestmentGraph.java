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

        // Draw points on the original investment function
        g2d.fillOval(200, 400, 10, 10);
        g2d.drawString("(2%, 4T)", 210, 410);
        g2d.fillOval(300, 300, 10, 10);
        g2d.drawString("(4%, 3T)", 310, 310);

        // Draw the new investment function (shifted line)
        g2d.drawLine(100, 400, 500, 0);
        g2d.drawString("I_D", 510, 10);

        // Draw points on the new investment function
        g2d.fillOval(200, 300, 10, 10);
        g2d.drawString("(2%, 3T)", 210, 310);
        g2d.fillOval(300, 200, 10, 10);
        g2d.drawString("(4%, 2T)", 310, 210);

        // Draw axes
        g2d.drawLine(100, 500, 100, 0); // Y-axis
        g2d.drawLine(100, 500, 600, 500); // X-axis

        // Label axes
        g2d.drawString("Interest Rate (%)", 300, 530);
        g2d.drawString("Planned Real Investment ($ Trillion)", 10, 20);

        // Draw numerical scale for Y-axis (Interest Rate)
        for (int i = 0; i <= 10; i++) {
            int y = 500 - (i * 50);
            g2d.drawLine(95, y, 100, y);
            g2d.drawString(i * 1 + "%", 60, y + 5);
        }

        // Draw numerical scale for X-axis (Planned Real Investment)
        for (int i = 0; i <= 10; i++) {
            int x = 100 + (i * 50);
            g2d.drawLine(x, 500, x, 505);
            g2d.drawString(i * 0.5 + "T", x - 10, 520);
        }

        // Draw legend
        g2d.drawString("Legend:", 10, 550);
        g2d.drawString("Original Investment Function", 10, 565);
        g2d.drawString("I_D (New Investment Function)", 10, 580);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Investment Function");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.add(new InvestmentGraph());
        frame.setVisible(true);
    }
}
