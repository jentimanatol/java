//by Anatolie Jentimir fell free to public where neded 
// need more worck : last swap 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickSortVisualization extends JPanel {
    private int[] numbers = {40, 10, 100, 90, 20, 25};
    private static final int circleRadius = 50;
    private static int delayMillis = 1000; // Default 1 second
    private int pivotIndex = -1;
    private int compareIndex1 = -1;
    private int compareIndex2 = -1;
    private JTextArea stepTextArea;
    private JTextField inputTextField;
    private JLabel speedLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton speedUpButton;
    private JButton speedDownButton;
    private JButton resetButton;
    private JButton setArrayButton;
    private boolean running = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("QuickSort Visualization");
        QuickSortVisualization panel = new QuickSortVisualization();
        frame.add(panel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public QuickSortVisualization() {
        stepTextArea = new JTextArea();
        stepTextArea.setEditable(false);
        stepTextArea.setLineWrap(true);
        stepTextArea.setWrapStyleWord(true);
        stepTextArea.setPreferredSize(new Dimension(780, 100));

        inputTextField = new JTextField();
        inputTextField.setPreferredSize(new Dimension(200, 30));

        speedLabel = new JLabel("Speed: " + delayMillis + " ms");

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        speedUpButton = new JButton("Speed +");
        speedDownButton = new JButton("Speed -");
        resetButton = new JButton("Reset");
        setArrayButton = new JButton("Set Array");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = true;
                new Thread(() -> sort()).start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
            }
        });

        speedUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delayMillis = Math.max(50, delayMillis - 50);
                speedLabel.setText("Speed: " + delayMillis + " ms");
            }
        });

        speedDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delayMillis += 50;
                speedLabel.setText("Speed: " + delayMillis + " ms");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                numbers = new int[]{40, 10, 100, 90, 20, 25};
                pivotIndex = -1;
                compareIndex1 = -1;
                compareIndex2 = -1;
                updateStepText("");
                repaint();
            }
        });

        setArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                numbers = parseInputArray(input);
                pivotIndex = -1;
                compareIndex1 = -1;
                compareIndex2 = -1;
                updateStepText("");
                repaint();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Initial Array:"));
        controlPanel.add(inputTextField);
        controlPanel.add(setArrayButton);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(speedUpButton);
        controlPanel.add(speedDownButton);
        controlPanel.add(resetButton);
        controlPanel.add(speedLabel);

        this.setLayout(new BorderLayout());
        this.add(stepTextArea, BorderLayout.SOUTH);
        this.add(controlPanel, BorderLayout.NORTH);
    }

    private void sort() {
        updateStepText("Step-by-Step QuickSort\nInitial Array: " + arrayToString(numbers));
        quickSort(numbers, 0, numbers.length - 1);
        if (running) {
            updateStepText("Final Sorted Array: " + arrayToString(numbers));
        }
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high && running) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        pivotIndex = high;
        updateStepText("Choose Pivot: Let's choose the last element as the pivot (" + pivot + ").");
        int i = (low - 1);
        for (int j = low; j < high && running; j++) {
            compareIndex1 = j;
            compareIndex2 = high;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (array[i] != array[j]) {
                    updateStepText("Partitioning:\nCompare " + array[j] + " with " + pivot + ": " + array[j] + " < " + pivot + ", swap " + array[j] + " with " + array[i] + " (last swap)");
                } else {
                    updateStepText("Partitioning:\nCompare " + array[j] + " with " + pivot + ": " + array[j] + " < " + pivot + ", no swap needed");
                }
                repaint();
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                updateStepText("Partitioning:\nCompare " + array[j] + " with " + pivot + ": " + array[j] + " > " + pivot + ", so no swap.");
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        repaint();
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pivotIndex = -1;
        compareIndex1 = -1;
        compareIndex2 = -1;
        updateStepText("Array after partitioning: " + arrayToString(array));
        return i + 1;
    }

    private void updateStepText(String text) {
        if (running) {
            stepTextArea.setText(text);
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private int[] parseInputArray(String input) {
        String[] parts = input.replaceAll("\\{", "").replaceAll("\\}", "").split(",");//standart function remove extra caracter from java1 
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        return array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < numbers.length; i++) {
            if (i == pivotIndex) {
                g.setColor(Color.RED);
                g.drawString("Pivot", 50 + i * 60, 90);
            } else if (i == compareIndex1 || i == compareIndex2) {
                g.setColor(Color.BLUE);
                g.drawString("Compare", 50 + i * 60, 90);
            } else {
                g.setColor(Color.GREEN);
            }
            g.fillOval(50 + i * 60, 100, circleRadius, circleRadius);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(numbers[i]), 65 + i * 60, 120);
        }
    }
}
