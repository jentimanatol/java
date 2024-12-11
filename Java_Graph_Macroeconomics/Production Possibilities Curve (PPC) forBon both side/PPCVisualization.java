import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

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

        // Add annotations for B grade
        XYTextAnnotation annotation = new XYTextAnnotation("B", 2, 2);
        annotation.setFont(new Font("Arial", Font.BOLD, 12));
        annotation.setTextAnchor(TextAnchor.CENTER);
        plot.addAnnotation(annotation);

        // Add horizontal and vertical lines for B grade
        XYSeries horizontalLine = new XYSeries("Horizontal Line");
        horizontalLine.add(0, 2);
        horizontalLine.add(3, 2);

        XYSeries verticalLine = new XYSeries("Vertical Line");
        verticalLine.add(2, 0);
        verticalLine.add(2, 3);

        XYSeriesCollection linesDataset = new XYSeriesCollection();
        linesDataset.addSeries(horizontalLine);
        linesDataset.addSeries(verticalLine);

        XYLineAndShapeRenderer linesRenderer = new XYLineAndShapeRenderer();
        linesRenderer.setSeriesPaint(0, Color.GREEN);
        linesRenderer.setSeriesPaint(1, Color.GREEN);
        plot.setDataset(1, linesDataset);
        plot.setRenderer(1, linesRenderer);

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
