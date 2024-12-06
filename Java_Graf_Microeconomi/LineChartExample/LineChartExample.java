import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class LineChartExample {
    public static void main(String[] args) {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Hammers", "1");
        dataset.addValue(2.0, "Hammers", "2");
        dataset.addValue(3.0, "Hammers", "3");
        dataset.addValue(4.0, "Hammers", "4");
        dataset.addValue(5.0, "Hammers", "5");

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Hammers vs. Horseshoes", // Chart title
                "Horseshoes", // X-Axis Label
                "Hammers", // Y-Axis Label
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
