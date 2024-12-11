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

public class GeneticTestingMarket extends JFrame {

    public GeneticTestingMarket() {
        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Market for Genetic Testing",
                "Quantity of tests (thousands)",
                "Price ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED); // Demand curve
        renderer.setSeriesPaint(1, Color.BLUE); // Supply curve
        renderer.setSeriesPaint(2, Color.GREEN); // Subsidy line
        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries demand = new XYSeries("Demand (D1)");
        XYSeries supply = new XYSeries("Supply (S1)");
        XYSeries subsidy = new XYSeries("$400 Subsidy");

        // Add data points for demand curve
        demand.add(0, 1000);
        demand.add(100, 0);

        // Add data points for supply curve
        supply.add(0, 0);
        supply.add(100, 1000);

        // Add data points for subsidy line
        subsidy.add(0, 600); // Assuming equilibrium price is $1000
        subsidy.add(100, 600);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demand);
        dataset.addSeries(supply);
        dataset.addSeries(subsidy);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeneticTestingMarket example = new GeneticTestingMarket();
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
