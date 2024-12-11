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

public class PPCVisualization extends JFrame {

    public PPCVisualization() {
        // Create dataset
        XYSeries ppc = new XYSeries("PPC");
        ppc.add(0, 20000); // 100 acres of soybeans
        ppc.add(10000, 0); // 100 acres of corn

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ppc);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Production Possibilities Curve",
                "Bushels of Corn",
                "Bushels of Soybeans",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        plot.setRenderer(renderer);

        // Create and set up the window
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PPCVisualization example = new PPCVisualization();
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
