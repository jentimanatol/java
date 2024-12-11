import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class OpportunityCostChart extends JFrame {

    public OpportunityCostChart() {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Choice", "Iced Tea");
        dataset.addValue(0, "Choice", "Diet Cola");
        dataset.addValue(1, "Opportunity Cost", "Cola");

        // Create chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Opportunity Cost of Mariko's Choice",
                "Options",
                "Value",
                dataset);

        // Customize plot
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.GREEN); // Choice
        renderer.setSeriesPaint(1, Color.RED);   // Opportunity Cost

        // Create and set up the window
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OpportunityCostChart example = new OpportunityCostChart();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
