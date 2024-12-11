import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DNAPatternVisualizer extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static final int BASE_PAIR_SPACING = 30;
    private static final int HELIX_RADIUS = 50;

    private static String dnaSequence = "ACGTACGTACGTACG";
    private static int k = 3;
    private static int threshold = 2;
    private static JTextField dnaInput;
    private static JTextField kInput;
    private static JTextField thresholdInput;
    private static JTextArea resultArea;
    private static HashMap<String, Integer> patternMap = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("DNA Pattern Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        DNAPatternVisualizer visualizer = new DNAPatternVisualizer();
        frame.add(visualizer);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("DNA Sequence:"));
        dnaInput = new JTextField(dnaSequence);
        panel.add(dnaInput);

        panel.add(new JLabel("Pattern Length (k):"));
        kInput = new JTextField(String.valueOf(k));
        panel.add(kInput);

        panel.add(new JLabel("Threshold:"));
        thresholdInput = new JTextField(String.valueOf(threshold));
        panel.add(thresholdInput);

        JButton visualizeButton = new JButton("Visualize Patterns");
        visualizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizePatterns();
                visualizer.repaint();
            }
        });
        panel.add(visualizeButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.getContentPane().add(BorderLayout.SOUTH, new JScrollPane(resultArea));
        frame.getContentPane().add(BorderLayout.NORTH, panel);

        frame.setVisible(true);
    }

    private static void visualizePatterns() {
        dnaSequence = dnaInput.getText();
        k = Integer.parseInt(kInput.getText());
        threshold = Integer.parseInt(thresholdInput.getText());

        LinkedList linkedList = new LinkedList();
        for (char c : dnaSequence.toCharArray()) {
            linkedList.add(c);
        }

        DNAPatternCounter.countPatterns(linkedList.getHead(), k);
        patternMap = DNAPatternCounter.getPatternMap();

        resultArea.setText("");

        for (Map.Entry<String, Integer> entry : patternMap.entrySet()) {
            if (entry.getValue() >= threshold) {
                resultArea.append("Pattern DNA " + entry.getKey() + " : " + entry.getValue() + " times\n");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDNAHelix(g, dnaSequence);
    }

    private void drawDNAHelix(Graphics g, String dnaSequence) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int baseY = 100;

        for (int i = 0; i < dnaSequence.length(); i++) {
            int offset = i * BASE_PAIR_SPACING;
            int y = baseY + offset;
            int nextY = baseY + offset + BASE_PAIR_SPACING / 2;

            // Draw the left helix
            g2d.setColor(getNucleotideColor(dnaSequence.charAt(i)));
            drawNucleotide(g2d, centerX - HELIX_RADIUS, y, dnaSequence.charAt(i));

            // Draw the right helix
            if (i + 1 < dnaSequence.length()) {
                g2d.setColor(getNucleotideColor(dnaSequence.charAt(i + 1)));
                drawNucleotide(g2d, centerX + HELIX_RADIUS, nextY, dnaSequence.charAt(i + 1));

                // Draw the connecting lines (base pairs)
                g2d.setColor(Color.BLACK);
                g2d.drawLine(centerX - HELIX_RADIUS, y + BASE_PAIR_SPACING / 2, centerX + HELIX_RADIUS, nextY + BASE_PAIR_SPACING / 2);
                g2d.drawLine(centerX - HELIX_RADIUS, nextY + BASE_PAIR_SPACING / 2, centerX + HELIX_RADIUS, y + BASE_PAIR_SPACING / 2);
            }
        }
    }

    private void drawNucleotide(Graphics2D g2d, int x, int y, char nucleotide) {
        int ovalSize = 20;
        g2d.fillOval(x - ovalSize / 2, y - ovalSize / 2, ovalSize, ovalSize);
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(nucleotide), x - 5, y + 5);
    }

    private Color getNucleotideColor(char nucleotide) {
        switch (nucleotide) {
            case 'A':
                return Color.RED;
            case 'T':
                return Color.BLUE;
            case 'C':
                return Color.GREEN;
            case 'G':
                return Color.ORANGE;
            default:
                return Color.BLACK;
        }
    }
}
