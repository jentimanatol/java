import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class PieChartExample extends JFrame {

    public PieChartExample(String appTitle) {
        super(appTitle);
        setLayout(new GridLayout(1, 2));

        add(createChartPanel(createDataset(), "Efficiency"));
        add(createChartPanel(createDataset(), "Equity"));
    }

    private static DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 50);
        dataset.setValue("Category 2", 50);
        return dataset;
    }

    private static JPanel createChartPanel(DefaultPieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, dataset);
        return new ChartPanel(chart);
    }

    public static void main(String[] args) {
        PieChartExample example = new PieChartExample("Pie Chart Window");
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
