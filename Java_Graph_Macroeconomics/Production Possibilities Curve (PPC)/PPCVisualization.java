import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
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
        ppc.add(0, 3); // (D, A)
        ppc.add(3, 0); // (A, D)

        XYSeries ppc1 = new XYSeries("PPC1");
        ppc1.add(0, 4); // Shifted PPC
        ppc1.add(4, 0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ppc);
        dataset.addSeries(ppc1);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Production Possibilities Curve",
                "Grade in Marketing",
                "Grade in Economics",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        plot.setRenderer(renderer);

        // Customize axes
        String[] grades = {"D", "C", "B", "A"};
        SymbolAxis xAxis = new SymbolAxis("Grade in Marketing", grades);
        SymbolAxis yAxis = new SymbolAxis("Grade in Economics", grades);
        plot.setDomainAxis(xAxis);
        plot.setRangeAxis(yAxis);

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
