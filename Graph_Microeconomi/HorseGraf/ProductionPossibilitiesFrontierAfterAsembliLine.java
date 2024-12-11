import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;

public class ProductionPossibilitiesFrontierAfterAsembliLine
 {
    public static void main(String[] args) {
        // Create dataset
        XYSeries series1 = new XYSeries("Before Assembly Line");
        series1.add(0, 100); // Maximum hammers, no horseshoes
        series1.add(100, 0); // Maximum horseshoes, no hammers

        XYSeries series2 = new XYSeries("After Assembly Line");
        series2.add(0, 150); // Increased maximum hammers, no horseshoes
        series2.add(100, 0); // Maximum horseshoes, no hammers


















        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Effect of a new computerized assembly line ",
                "Horseshoes",
                "Hammers",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
