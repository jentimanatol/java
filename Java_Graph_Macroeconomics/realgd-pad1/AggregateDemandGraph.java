import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;

public class AggregateDemandGraph extends JFrame {

    public AggregateDemandGraph(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Aggregate Demand",
                "Real GDP ($ trillions)",
                "Price level",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        // Add annotation for new AD curve
        XYTextAnnotation annotation = new XYTextAnnotation("AD2", 150, 7.1);
        annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        plot.addAnnotation(annotation);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries ad = new XYSeries("AD");
        ad.add(100, 9);
        ad.add(110, 8);
        ad.add(120, 7);
        ad.add(130, 6);
        ad.add(140, 5);
        ad.add(150, 4);
        ad.add(160, 3);
        ad.add(170, 2);
        ad.add(180, 1);
        ad.add(190, 0);

        XYSeries lras = new XYSeries("LRAS");
        lras.add(150, 0);
        lras.add(150, 9);

        XYSeries ad2 = new XYSeries("AD2");
        ad2.add(100, 8);
        ad2.add(110, 7);
        ad2.add(120, 6);
        ad2.add(130, 5);
        ad2.add(140, 4);
        ad2.add(150, 3);
        ad2.add(160, 2);
        ad2.add(170, 1);
        ad2.add(180, 0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ad);
        dataset.addSeries(lras);
        dataset.addSeries(ad2);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AggregateDemandGraph example = new AggregateDemandGraph("Aggregate Demand Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
