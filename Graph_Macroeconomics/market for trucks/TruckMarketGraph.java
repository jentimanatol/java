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

public class TruckMarketGraph extends JFrame {

    public TruckMarketGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Market for Trucks",
                "Quantity",
                "Market Price",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.ORANGE);
        renderer.setSeriesShapesVisible(3, true);
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

        XYSeries newSupply = new XYSeries("New Supply");
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

        XYSeries newDemand = new XYSeries("New Demand");
        newDemand.add(1, 4);
        newDemand.add(2, 6);
        newDemand.add(3, 8);
        newDemand.add(4, 10);
        newDemand.add(5, 12);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(supply);
        dataset.addSeries(newSupply);
        dataset.addSeries(demand);
        dataset.addSeries(newDemand);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TruckMarketGraph example = new TruckMarketGraph("Market for Trucks");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
