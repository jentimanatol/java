import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class EconomicGraphallinone extends ApplicationFrame {

    public EconomicGraphallinone(String title) {
        super(title);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Aggregate Demand and Supply",
                "Real GDP",
                "Price Level",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.BLACK);
        renderer.setSeriesPaint(4, Color.ORANGE);

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
        renderer.setSeriesStroke(4, new BasicStroke(2.0f));

        plot.setRenderer(renderer);

        // Adding annotations for zones
        XYTextAnnotation neoclassicalZone = new XYTextAnnotation("Neoclassical Zone", 25, 110);
        neoclassicalZone.setFont(new Font("SansSerif", Font.BOLD, 12));
        neoclassicalZone.setPaint(Color.BLACK);
        plot.addAnnotation(neoclassicalZone);

        XYTextAnnotation intermediateZone = new XYTextAnnotation("Intermediate Zone", 15, 90);
        intermediateZone.setFont(new Font("SansSerif", Font.BOLD, 12));
        intermediateZone.setPaint(Color.BLACK);
        plot.addAnnotation(intermediateZone);

        XYTextAnnotation keynesianZone = new XYTextAnnotation("Keynesian Zone", 5, 70);
        keynesianZone.setFont(new Font("SansSerif", Font.BOLD, 12));
        keynesianZone.setPaint(Color.BLACK);
        plot.addAnnotation(keynesianZone);

        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset() {
        final XYSeries adk = new XYSeries("ADk");
        adk.add(0, 100);
        adk.add(10, 90);
        adk.add(20, 80);
        adk.add(30, 70);

        final XYSeries adi = new XYSeries("ADi");
        adi.add(0, 105);
        adi.add(10, 95);
        adi.add(20, 85);
        adi.add(30, 75);

        final XYSeries adn = new XYSeries("ADn");
        adn.add(0, 110);
        adn.add(10, 100);
        adn.add(20, 90);
        adn.add(30, 80);

        final XYSeries sras = new XYSeries("SRAS");
        sras.add(0, 70);
        sras.add(10, 80);
        sras.add(20, 90);
        sras.add(30, 100);

        final XYSeries lras = new XYSeries("LRAS");
        lras.add(20, 0);
        lras.add(20, 120);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(adk);
        dataset.addSeries(adi);
        dataset.addSeries(adn);
        dataset.addSeries(sras);
        dataset.addSeries(lras);

        return dataset;
    }

    public static void main(String[] args) {
        EconomicGraphallinone chart = new EconomicGraphallinone("Economic Graph");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
