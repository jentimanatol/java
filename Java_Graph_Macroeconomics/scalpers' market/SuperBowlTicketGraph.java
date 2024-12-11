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

public class SuperBowlTicketGraph extends JFrame {

    public SuperBowlTicketGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Super Bowl Ticket Market",
                "Quantity of Tickets (thousands)",
                "Price per Ticket ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED); // Demand Curve (D)
        renderer.setSeriesPaint(1, Color.BLUE); // Supply Curve (S)
        renderer.setSeriesPaint(2, Color.GREEN); // Scalpers' Market Price
        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries series1 = new XYSeries("Demand Curve (D)");
        series1.add(20, 9000);
        series1.add(180, 1000);

        XYSeries series2 = new XYSeries("Supply Curve (S)");
        series2.add(80, 0);
        series2.add(80, 10000); // Extend the line vertically

        XYSeries series3 = new XYSeries("Scalpers' Market Price");
        series3.add(0, 5000);
        series3.add(200, 5000); // Horizontal line at $5,000

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SuperBowlTicketGraph example = new SuperBowlTicketGraph("Super Bowl Ticket Market Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
