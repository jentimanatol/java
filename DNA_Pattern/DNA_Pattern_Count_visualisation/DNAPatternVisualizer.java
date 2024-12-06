import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DNAPatternVisualizer {
    private static JTextField dnaInput;
    private static JTextField kInput;
    private static JTextField thresholdInput;
    private static JTextArea resultArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DNA Pattern Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("DNA Sequence:"));
        dnaInput = new JTextField("ACGTACGTACGTACGAA");
        panel.add(dnaInput);

        panel.add(new JLabel("Pattern Length (k):"));
        kInput = new JTextField("3");
        panel.add(kInput);

        panel.add(new JLabel("Threshold:"));
        thresholdInput = new JTextField("2");
        panel.add(thresholdInput);

        JButton visualizeButton = new JButton("Visualize Patterns");
        visualizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizePatterns();
            }
        });
        panel.add(visualizeButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(resultArea));
        frame.getContentPane().add(BorderLayout.NORTH, panel);

        frame.setVisible(true);
    }

    private static void visualizePatterns() {
        String dnaSequence = dnaInput.getText();
        int k = Integer.parseInt(kInput.getText());
        int threshold = Integer.parseInt(thresholdInput.getText());

        LinkedList linkedList = new LinkedList();
        for (char c : dnaSequence.toCharArray()) {
            linkedList.add(c);
        }

        DNAPatternCounter patternCounter = new DNAPatternCounter();
        patternCounter.countPatterns(linkedList.getHead());

        HashMap<String, Integer> patternMap = patternCounter.getPatternMap();
        resultArea.setText("");

        for (Map.Entry<String, Integer> entry : patternMap.entrySet()) {
            if (entry.getValue() > threshold) {
                resultArea.append("Pattern DNA " + entry.getKey() + " : " + entry.getValue() + " times\n");
            }
        }
    }
}
