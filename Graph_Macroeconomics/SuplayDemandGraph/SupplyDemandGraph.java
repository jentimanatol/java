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

public class SupplyDemandGraph extends JFrame {

    public SupplyDemandGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Supply and Demand Graph",
                "Quantity (Millions)",
                "Price",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.ORANGE);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesShapesVisible(3, true);
        plot.setRenderer(renderer);

        // Add chart to panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800, 600));
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries demand = new XYSeries("Demand D");
        demand.add(1, 0.9);
        demand.add(9, 0.1);

        XYSeries supply1 = new XYSeries("Supply S1");
        supply1.add(1, 0.1);
        supply1.add(9, 0.9);

        XYSeries supply2 = new XYSeries("Supply S2");
        supply2.add(1, 0.2); // Adjusted for increased cost
        supply2.add(9, 1.0); // Adjusted for increased cost

        XYSeries demand2 = new XYSeries("Demand D2");
        demand2.add(1, 0.8); // Adjusted for new demand
        demand2.add(9, 0.0); // Adjusted for new demand

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demand);
        dataset.addSeries(supply1);
        dataset.addSeries(supply2);
        dataset.addSeries(demand2);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SupplyDemandGraph example = new SupplyDemandGraph("Supply and Demand Graph");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
