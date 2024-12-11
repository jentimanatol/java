import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EconomicGraph extends JFrame {

    private XYSeriesCollection dataset;
    private XYPlot plot;
    private XYLineAndShapeRenderer renderer;

    public EconomicGraph(String title) {
        super(title);

        // Create dataset
        dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Economic States",
                "Real GDP ($ trillions)",
                "Price Level",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        plot = chart.getXYPlot();
        renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED); // AD (Long-Run Equilibrium)
        renderer.setSeriesPaint(1, Color.BLUE); // SRAS
        renderer.setSeriesPaint(2, Color.GREEN); // LRAS
        renderer.setSeriesPaint(3, Color.ORANGE); // AD2 (Inflationary Gap)
        renderer.setSeriesPaint(4, Color.MAGENTA); // AD3 (Recessionary Gap)
        renderer.setSeriesPaint(5, Color.CYAN); // AD4 (Depression)
        plot.setRenderer(renderer);

        // Add labels
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
        renderer.setSeriesStroke(4, new BasicStroke(2.0f));
        renderer.setSeriesStroke(5, new BasicStroke(2.0f));

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        // Create a combo box for selecting lines
        String[] lines = {"AD (Long-Run Equilibrium)", "AD2 (Inflationary Gap)", "AD3 (Recessionary Gap)", "AD4 (Depression)"};
        JComboBox<String> comboBox = new JComboBox<>(lines);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLine = (String) comboBox.getSelectedItem();
                updateChart(selectedLine);
            }
        });

        // Add combo box to the frame
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Select Line:"));
        controlPanel.add(comboBox);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private XYSeriesCollection createDataset() {
        XYSeries ad = new XYSeries("AD (Long-Run Equilibrium)");
        ad.add(2, 100);
        ad.add(4, 80);
        ad.add(6, 60);
        ad.add(8, 40);
        ad.add(10, 20);

        XYSeries sras = new XYSeries("SRAS");
        sras.add(2, 20);
        sras.add(4, 40);
        sras.add(6, 60);
        sras.add(8, 80);
        sras.add(10, 100);

        XYSeries lras = new XYSeries("LRAS");
        lras.add(6, 0);
        lras.add(6, 120);

        XYSeries ad2 = new XYSeries("AD2 (Inflationary Gap)");
        ad2.add(4, 100);
        ad2.add(6, 80);
        ad2.add(8, 60);
        ad2.add(10, 40);
        ad2.add(12, 20);

        XYSeries ad3 = new XYSeries("AD3 (Recessionary Gap)");
        ad3.add(0, 100);
        ad3.add(2, 80);
        ad3.add(4, 60);
        ad3.add(6, 40);
        ad3.add(8, 20);

        XYSeries ad4 = new XYSeries("AD4 (Depression)");
        ad4.add(-2, 100);
        ad4.add(0, 80);
        ad4.add(2, 60);
        ad4.add(4, 40);
        ad4.add(6, 20);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ad);
        dataset.addSeries(sras);
        dataset.addSeries(lras);
        dataset.addSeries(ad2);
        dataset.addSeries(ad3);
        dataset.addSeries(ad4);

        return dataset;
    }

    private void updateChart(String selectedLine) {
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            if (dataset.getSeriesKey(i).equals(selectedLine)) {
                renderer.setSeriesVisible(i, true);
            } else if (i != 1 && i != 2) { // Keep SRAS and LRAS always visible
                renderer.setSeriesVisible(i, false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EconomicGraph example = new EconomicGraph("Economic States Visualization");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
