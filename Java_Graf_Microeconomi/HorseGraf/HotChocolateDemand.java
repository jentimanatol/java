import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class HotChocolateDemand extends JFrame {

    public HotChocolateDemand(String appTitle) {
        super(appTitle);

        // Create Dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "Supply", "Before Winter");
        dataset.addValue(100, "Demand", "Before Winter");
        dataset.addValue(100, "Supply", "After Winter");
        dataset.addValue(150, "Demand", "After Winter");

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Hot Chocolate Market", // Chart title
                "Time", // X-Axis Label
                "Quantity", // Y-Axis Label
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static void main(String[] args) {
        HotChocolateDemand chart = new HotChocolateDemand("Hot Chocolate Market Analysis");
        chart.setSize(800, 400);
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
