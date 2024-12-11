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

public class GraphExample extends JFrame {

    public GraphExample() {
        // Create dataset
        XYSeries seriesC = new XYSeries("C");
        seriesC.add(0, 4);
        seriesC.add(20, 14);

        XYSeries seriesI = new XYSeries("I");
        seriesI.add(0, 5);
        seriesI.add(22, 5);

        XYSeries seriesCI = new XYSeries("C+I");
        seriesCI.add(0, 9);
        seriesCI.add(20, 19);

        XYSeries seriesA = new XYSeries("A");
        seriesA.add(8, 8);

        XYSeries seriesB = new XYSeries("B");
        seriesB.add(18, 18);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesC);
        dataset.addSeries(seriesI);
        dataset.addSeries(seriesCI);
        dataset.addSeries(seriesA);
        dataset.addSeries(seriesB);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Planned C and I vs Real GDP",
                "Real GDP",
                "Planned C and I ($ trillions)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.ORANGE);
        renderer.setSeriesPaint(4, Color.MAGENTA);
        plot.setRenderer(renderer);

        // Create and set up the window
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphExample example = new GraphExample();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
