import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DNAPatternVisualizer extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BASE_PAIR_SPACING = 30;
    private static final int HELIX_RADIUS = 100;
    private static final int NUM_TURNS = 10;
    private static final int K = 3; // Interval for marking points
    private static final String DNA_SEQUENCE = "ACGTACGTACGTACGAA"; // Example DNA sequence
    private static final Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

    public static void main(String[] args) {
        JFrame frame = new JFrame("DNA Helix Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(new DNAPatternVisualizer());
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDNAHelix(g);
    }

    private void drawDNAHelix(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
        int baseY = centerY - (NUM_TURNS * BASE_PAIR_SPACING / 2);

        // Draw the DNA spiral with color and marks
        for (int i = 0; i < NUM_TURNS; i++) {
            int offset = i * BASE_PAIR_SPACING;
            int y = baseY + offset;
            int nextY = baseY + offset + BASE_PAIR_SPACING;
            Color color = COLORS[i % COLORS.length];

            g2d.setColor(color);
            // Draw the left helix
            g2d.drawArc(centerX - HELIX_RADIUS, y, HELIX_RADIUS * 2, BASE_PAIR_SPACING, 0, 180);

            // Draw the right helix
            g2d.drawArc(centerX - HELIX_RADIUS, nextY, HELIX_RADIUS * 2, BASE_PAIR_SPACING, 180, 180);

            // Draw the connecting lines (base pairs)
            g2d.drawLine(centerX - HELIX_RADIUS, y + BASE_PAIR_SPACING / 2, centerX + HELIX_RADIUS, nextY + BASE_PAIR_SPACING / 2);
            g2d.drawLine(centerX - HELIX_RADIUS, nextY + BASE_PAIR_SPACING / 2, centerX + HELIX_RADIUS, y + BASE_PAIR_SPACING / 2);

            // Add points every K base pairs
            if (i % K == 0) {
                g2d.fillOval(centerX - HELIX_RADIUS - 5, y + BASE_PAIR_SPACING / 2 - 5, 10, 10);
                g2d.fillOval(centerX + HELIX_RADIUS - 5, nextY + BASE_PAIR_SPACING / 2 - 5, 10, 10);
            }
        }
    }
}
