/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : drsd.java
 *  Description: 
 * ******************************************/


 import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class BarChartExample extends JFrame {

    private static final long serialVersionUID = 1L;

    public BarChartExample(String appTitle) {
        super(appTitle);

        // Create Dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(60, "Price", "Before Tax");
        dataset.addValue(280, "Quantity", "Before Tax");
        dataset.addValue(54, "Price", "After Tax");
        dataset.addValue(262, "Quantity", "After Tax");

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Equilibrium Price and Quantity", 
                "Category", 
                "Score", 
                dataset);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static void main(String[] args) {
        BarChartExample example = new BarChartExample("Bar Chart Window");
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
