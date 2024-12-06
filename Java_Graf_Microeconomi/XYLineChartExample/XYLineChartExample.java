import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;

public class XYLineChartExample extends JFrame {

    private static final long serialVersionUID = 1L;

    public XYLineChartExample(String appTitle) {
        super(appTitle);

        // Create dataset
        XYDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Equilibrium Price and Quantity",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series1 = new XYSeries("Before Tax");
        series1.add(1, 60);  // Price
        series1.add(2, 280); // Quantity
        dataset.addSeries(series1);

        XYSeries series2 = new XYSeries("After Tax");
        series2.add(1, 54);  // Price
        series2.add(2, 262); // Quantity
        dataset.addSeries(series2);

        return dataset;
    }

    public static void main(String[] args) {
        XYLineChartExample example = new XYLineChartExample("XY Line Chart Window");
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
