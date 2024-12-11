import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.annotations.XYTextAnnotation;

import java.awt.*;

public class YogurtMarketGraph extends ApplicationFrame {

    public YogurtMarketGraph(String title) {
        super(title);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Yogurt Market",
                "Quantity",
                "Price",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GRAY);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        // Add annotations for each point
        addAnnotations(plot);

        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset() {
        final XYSeries demand = new XYSeries("Demand");
        demand.add(4, 5);
        demand.add(5, 3);

        final XYSeries supply = new XYSeries("Supply");
        supply.add(3, 3);
        supply.add(4, 5);

        final XYSeries priceCeiling = new XYSeries("Price Ceiling");
        priceCeiling.add(3, 3);
        priceCeiling.add(5, 3);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demand);
        dataset.addSeries(supply);
        dataset.addSeries(priceCeiling);

        return dataset;
    }

    private void addAnnotations(XYPlot plot) {
        // Demand points
        plot.addAnnotation(new XYTextAnnotation("D1 (4, 5)", 4, 5));
        plot.addAnnotation(new XYTextAnnotation("D2 (5, 3)", 5, 3));

        // Supply points
        plot.addAnnotation(new XYTextAnnotation("S1 (3, 3)", 3, 3));
        plot.addAnnotation(new XYTextAnnotation("S2 (4, 5)", 4, 5));

        // Price ceiling points
        plot.addAnnotation(new XYTextAnnotation("PC1 (3, 3)", 3, 3));
        plot.addAnnotation(new XYTextAnnotation("PC2 (5, 3)", 5, 3));
    }

    public static void main(String[] args) {
        YogurtMarketGraph chart = new YogurtMarketGraph("Yogurt Market Graph");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
