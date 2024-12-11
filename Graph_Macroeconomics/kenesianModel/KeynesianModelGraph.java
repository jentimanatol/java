import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;

public class KeynesianModelGraph extends JFrame {

    public KeynesianModelGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Keynesian Model",
                "Real GDP ($, trillions)",
                "Price level",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        // Add annotation for new AD curve
        XYTextAnnotation annotation = new XYTextAnnotation("AD1", 150, 7.1);
        annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        plot.addAnnotation(annotation);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries ad0 = new XYSeries("AD0");
        ad0.add(100, 9);
        ad0.add(110, 8);
        ad0.add(120, 7);
        ad0.add(130, 6);
        ad0.add(140, 5);
        ad0.add(150, 4);
        ad0.add(160, 3);
        ad0.add(170, 2);
        ad0.add(180, 1);
        ad0.add(190, 0);

        XYSeries sras = new XYSeries("SRAS");
        sras.add(0, 5);
        sras.add(200, 5);

        XYSeries ad1 = new XYSeries("AD1");
        ad1.add(100, 8);
        ad1.add(110, 7);
        ad1.add(120, 6);
        ad1.add(130, 5);
        ad1.add(140, 4);
        ad1.add(150, 3);
        ad1.add(160, 2);
        ad1.add(170, 1);
        ad1.add(180, 0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ad0);
        dataset.addSeries(sras);
        dataset.addSeries(ad1);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeynesianModelGraph example = new KeynesianModelGraph("Keynesian Model Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
