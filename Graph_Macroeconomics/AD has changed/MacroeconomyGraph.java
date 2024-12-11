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

public class MacroeconomyGraph extends JFrame {

    public MacroeconomyGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Macroeconomy",
                "Real GDP ($ trillions)",
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

        // Add annotation for equilibrium point
        XYTextAnnotation annotation = new XYTextAnnotation("E", 12, 120);
        annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        plot.addAnnotation(annotation);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries ad = new XYSeries("AD");
        ad.add(16, 80);
        ad.add(14, 100);
        ad.add(12, 120);
        ad.add(8, 160);

        XYSeries lras = new XYSeries("LRAS");
        lras.add(12, 0);
        lras.add(12, 180);

        XYSeries sras = new XYSeries("SRAS");
        sras.add(4, 80);
        sras.add(10, 100);
        sras.add(12, 120);
        sras.add(14, 160);

        XYSeries ad1 = new XYSeries("AD1");
        ad1.add(14, 80);
        ad1.add(12, 100);
        ad1.add(10, 120);
        ad1.add(6, 160);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ad);
        dataset.addSeries(lras);
        dataset.addSeries(sras);
        dataset.addSeries(ad1);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MacroeconomyGraph example = new MacroeconomyGraph("Macroeconomy Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
