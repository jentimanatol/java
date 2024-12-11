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

public class PurplePotatoMarketGraph extends ApplicationFrame {

    public PurplePotatoMarketGraph(String title) {
        super(title);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Purple Potato Market",
                "Pounds of Purple Potatoes per Day",
                "Price per Pound",
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
        demand.add(1000, 70);
        demand.add(1500, 60);
        demand.add(2000, 50);
        demand.add(2500, 40);
        demand.add(3000, 30);
        demand.add(3500, 20);
        demand.add(4000, 10);

        final XYSeries supply = new XYSeries("Supply");
        supply.add(1000, 10);
        supply.add(1500, 20);
        supply.add(2000, 30);
        supply.add(2500, 40);
        supply.add(3000, 50);
        supply.add(3500, 60);
        supply.add(4000, 70);

        final XYSeries priceCeiling = new XYSeries("Price Ceiling");
        priceCeiling.add(1000, 30);
        priceCeiling.add(4000, 30);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demand);
        dataset.addSeries(supply);
        dataset.addSeries(priceCeiling);

        return dataset;
    }

    private void addAnnotations(XYPlot plot) {
        // Demand points
        plot.addAnnotation(new XYTextAnnotation("D1 (1000, 70)", 1000, 70));
        plot.addAnnotation(new XYTextAnnotation("D2 (1500, 60)", 1500, 60));
        plot.addAnnotation(new XYTextAnnotation("D3 (2000, 50)", 2000, 50));
        plot.addAnnotation(new XYTextAnnotation("D4 (2500, 40)", 2500, 40));
        plot.addAnnotation(new XYTextAnnotation("D5 (3000, 30)", 3000, 30));
        plot.addAnnotation(new XYTextAnnotation("D6 (3500, 20)", 3500, 20));
        plot.addAnnotation(new XYTextAnnotation("D7 (4000, 10)", 4000, 10));

        // Supply points
        plot.addAnnotation(new XYTextAnnotation("S1 (1000, 10)", 1000, 10));
        plot.addAnnotation(new XYTextAnnotation("S2 (1500, 20)", 1500, 20));
        plot.addAnnotation(new XYTextAnnotation("S3 (2000, 30)", 2000, 30));
        plot.addAnnotation(new XYTextAnnotation("S4 (2500, 40)", 2500, 40));
        plot.addAnnotation(new XYTextAnnotation("S5 (3000, 50)", 3000, 50));
        plot.addAnnotation(new XYTextAnnotation("S6 (3500, 60)", 3500, 60));
        plot.addAnnotation(new XYTextAnnotation("S7 (4000, 70)", 4000, 70));

        // Price ceiling points
        plot.addAnnotation(new XYTextAnnotation("PC1 (1000, 30)", 1000, 30));
        plot.addAnnotation(new XYTextAnnotation("PC2 (4000, 30)", 4000, 30));
    }

    public static void main(String[] args) {
        PurplePotatoMarketGraph chart = new PurplePotatoMarketGraph("Purple Potato Market Graph");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
