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

public class DVDMarketGraph extends JFrame {

    public DVDMarketGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Market for DVDs",
                "Quantity",
                "Price ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesShapesVisible(2, true);
        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries supply = new XYSeries("Supply");
        supply.add(1, 10);
        supply.add(2, 8);
        supply.add(3, 6);
        supply.add(4, 4);
        supply.add(5, 2);

        XYSeries newSupply = new XYSeries("New Line");
        newSupply.add(1, 8);
        newSupply.add(2, 6);
        newSupply.add(3, 4);
        newSupply.add(4, 2);
        newSupply.add(5, 1);

        XYSeries demand = new XYSeries("Demand");
        demand.add(1, 2);
        demand.add(2, 4);
        demand.add(3, 6);
        demand.add(4, 8);
        demand.add(5, 10);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(supply);
        dataset.addSeries(newSupply);
        dataset.addSeries(demand);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DVDMarketGraph example = new DVDMarketGraph("Market for DVDs");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
