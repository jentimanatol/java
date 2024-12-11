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

public class PizzaMarketGraph extends JFrame {

    public PizzaMarketGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Pizza Market Supply and Demand",
                "Quantity of Pizzas",
                "Price of Pizzas",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED); // Original Demand Curve (D₀)
        renderer.setSeriesPaint(1, Color.BLUE); // New Demand Curve (D₁)
        renderer.setSeriesPaint(2, Color.GREEN); // Original Supply Curve (S₀)
        renderer.setSeriesPaint(3, Color.ORANGE); // New Supply Curve (S₁)
        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries series1 = new XYSeries("Original Demand Curve (D₀)");
        series1.add(4, 24);
        series1.add(24, 4);

        XYSeries series2 = new XYSeries("New Demand Curve (D₁)");
        series2.add(4, 26); // Shifted up by $2
        series2.add(24, 6); // Shifted up by $2

        XYSeries series3 = new XYSeries("Original Supply Curve (S₀)");
        series3.add(4, 4);
        series3.add(24, 24);

        XYSeries series4 = new XYSeries("New Supply Curve (S₁)");
        series4.add(4, 2); // Shifted down to return equilibrium price to $14
        series4.add(24, 22); // Shifted down to return equilibrium price to $14

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaMarketGraph example = new PizzaMarketGraph("Pizza Market Graph Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
