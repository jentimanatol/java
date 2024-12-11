import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class SupplyDemandGraph {

    public static void main(String[] args) {
        // Sample data (replace with actual data)
        double[] demandPrices = {10, 8, 6, 4, 2};
        double[] demandQuantities = {20, 30, 40, 50, 60};
        double[] demandWithSocialBenefitsPrices = {10, 8, 6, 4, 2};
        double[] demandWithSocialBenefitsQuantities = {30, 40, 50, 60, 70}; // Increased demand

        // Create XYSeries for demand curves
        XYSeries demandSeries = new XYSeries("Demand");
        XYSeries demandWithSocialBenefitsSeries = new XYSeries("Demand with Social Benefits");

        // Populate series with data
        for (int i = 0; i < demandPrices.length; i++) {
            demandSeries.add(demandQuantities[i], demandPrices[i]);
            demandWithSocialBenefitsSeries.add(demandWithSocialBenefitsQuantities[i], demandWithSocialBenefitsPrices[i]);
        }

        // Create dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demandSeries);
        dataset.addSeries(demandWithSocialBenefitsSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Supply and Demand with Social Benefits",
                "Quantity",
                "Price",
                dataset
        );

        // Customize chart (optional)
        XYPlot plot = (XYPlot) chart.getPlot();
        // Add customizations here, e.g., color, labels, grid lines

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);

        // Create a frame
        JFrame frame = new JFrame("Supply and Demand Graph");
        frame.add(chartPanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
