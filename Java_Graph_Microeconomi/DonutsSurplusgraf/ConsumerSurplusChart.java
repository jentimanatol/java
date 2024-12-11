import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class ConsumerSurplusChart extends ApplicationFrame {

    public ConsumerSurplusChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Donuts","Value",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0.60, "Value", "First");
        dataset.addValue(0.50, "Value", "Second");
        dataset.addValue(0.40, "Value", "Third");
        dataset.addValue(0.30, "Value", "Fourth");
        dataset.addValue(0.20, "Value", "Fifth");
        dataset.addValue(0.10, "Value", "Sixth");
        dataset.addValue(0.20, "Price", "First");
        dataset.addValue(0.20, "Price", "Second");
        dataset.addValue(0.20, "Price", "Third");
        dataset.addValue(0.20, "Price", "Fourth");
        dataset.addValue(0.20, "Price", "Fifth");
        dataset.addValue(0.20, "Price", "Sixth");
        return dataset;
    }

    public static void main(String[] args) {
        ConsumerSurplusChart chart = new ConsumerSurplusChart(
                "Consumer Surplus",
                "Value of Donuts vs Price");

        chart.pack();
        chart.setVisible(true);
    }
}
