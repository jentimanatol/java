import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hot Chocolate Market Analysis");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            XYSeriesCollection dataset = new XYSeriesCollection();

            // Scenario: Price $0.50 above equilibrium
            XYSeries series = new XYSeries("Price $0.50 above equilibrium");
            series.add(1.0, 3.0); // Original equilibrium point (quantity, price)
            series.add(1.0, 3.5); // New price point (quantity remains the same, price increases by $0.50)
            dataset.addSeries(series);

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Hot Chocolate Market Analysis", // Title
                    "Quantity", // x-axis Label
                    "Price", // y-axis Label
                    dataset // Dataset
            );

            frame.setContentPane(new ChartPanel(chart));
            frame.setVisible(true);
        });
    }
}
