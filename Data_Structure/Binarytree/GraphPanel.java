import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;

public class GraphPanel extends JPanel {
    private Map<String, Point> nodes;
    private Map<String, String[]> edges;

    public GraphPanel() {
        nodes = new HashMap<>();
        edges = new HashMap<>();

        // Define node positions
        nodes.put("X", new Point(100, 100));
        nodes.put("L", new Point(200, 200));
        nodes.put("P", new Point(300, 100));
        nodes.put("K", new Point(400, 200));
        nodes.put("B", new Point(500, 100));
        nodes.put("A", new Point(600, 200));
        nodes.put("Q", new Point(700, 100));
        nodes.put("T", new Point(800, 200));
        nodes.put("M", new Point(900, 100));
        nodes.put("R", new Point(1000, 200));

        // Define edges with weights
        edges.put("X-L", new String[]{"X", "L", "0"});
        edges.put("X-P", new String[]{"X", "P", "0"});
        edges.put("X-K", new String[]{"X", "K", "0"});
        edges.put("X-B", new String[]{"X", "B", "0"});
        edges.put("L-A", new String[]{"L", "A", "1"});
        edges.put("P-Q", new String[]{"P", "Q", "2"});
        edges.put("B-T", new String[]{"B", "T", "9"});
        edges.put("A-M", new String[]{"A", "M", "5"});
        edges.put("Q-R", new String[]{"Q", "R", "6"});
        edges.put("M-R", new String[]{"M", "R", "7"});
        edges.put("R-T", new String[]{"R", "T", "8"});
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw edges
        for (String edge : edges.keySet()) {
            String[] details = edges.get(edge);
            Point from = nodes.get(details[0]);
            Point to = nodes.get(details[1]);
            g2d.draw(new Line2D.Double(from.x, from.y, to.x, to.y));
            g2d.drawString(details[2], (from.x + to.x) / 2, (from.y + to.y) / 2);
        }

        // Draw nodes
        for (String node : nodes.keySet()) {
            Point p = nodes.get(node);
            g2d.setColor(Color.LIGHT_GRAY); // Set circle color to light gray
            g2d.fillOval(p.x - 15, p.y - 15, 30, 30);
            g2d.setColor(Color.BLACK); // Set text color to black
            g2d.drawString(node, p.x - 5, p.y + 5);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Directed Graph");
        GraphPanel panel = new GraphPanel();
        frame.add(panel);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
