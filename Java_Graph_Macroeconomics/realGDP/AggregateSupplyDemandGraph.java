import javax.swing.*;
import java.awt.*;

public class AggregateSupplyDemandGraph extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw axes
        g2d.drawLine(50, 50, 50, 400); // Y-axis
        g2d.drawLine(50, 400, 400, 400); // X-axis

        // Draw LRAS curve (vertical line at $9 trillion)
        g2d.setColor(Color.RED);
        g2d.drawLine(200, 50, 200, 400);
        g2d.drawString("LRAS", 210, 60);

        // Draw AD curve (downward sloping)
        g2d.setColor(Color.BLUE);
        g2d.drawLine(50, 100, 350, 400);
        g2d.drawString("AD", 360, 410);

        // Labels
        g2d.setColor(Color.BLACK);
        g2d.drawString("Real GDP ($ trillions)", 200, 420);
        g2d.drawString("Price Level", 10, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aggregate Supply and Demand Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new AggregateSupplyDemandGraph());
        frame.setVisible(true);
    }
}
