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

public class LaborMarketGraph extends JFrame {

    public LaborMarketGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Labor Market",
                "Millions of workers",
                "Hourly wage rate",
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

        // Add unemployment line
        XYSeries unemployment = new XYSeries("Unemployed");
        unemployment.add(120, 7);
        unemployment.add(170, 7);
        dataset.addSeries(unemployment);

        // Add annotation for unemployment
        XYTextAnnotation annotation = new XYTextAnnotation("Unemployed", 145, 7.1);
        annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        plot.addAnnotation(annotation);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries demand = new XYSeries("D");
        demand.add(100, 9);
        demand.add(110, 8);
        demand.add(120, 7);
        demand.add(130, 6);
        demand.add(140, 5);
        demand.add(150, 4);
        demand.add(160, 3);
        demand.add(170, 2);
        demand.add(180, 1);
        demand.add(190, 0);

        XYSeries supply = new XYSeries("S");
        supply.add(100, 0);
        supply.add(110, 1);
        supply.add(120, 2);
        supply.add(130, 3);
        supply.add(140, 4);
        supply.add(150, 5);
        supply.add(160, 6);
        supply.add(170, 7);
        supply.add(180, 8);
        supply.add(190, 9);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demand);
        dataset.addSeries(supply);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LaborMarketGraph example = new LaborMarketGraph("Labor Market Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}

