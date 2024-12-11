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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EconomicGraph extends ApplicationFrame {

    private XYSeriesCollection dataset;
    private JFreeChart xylineChart;
    private XYPlot plot;

    public EconomicGraph(String title) {
        super(title);
        dataset = createDataset("ADk");
        xylineChart = ChartFactory.createXYLineChart(
                "Aggregate Demand and Supply",
                "Real GDP",
                "Price Level",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        plot = xylineChart.getXYPlot();

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
        addAnnotations();

        // Create JComboBox for selecting AD curve
        String[] adOptions = {"ADk", "ADi", "ADn"};
        JComboBox<String> adComboBox = new JComboBox<>(adOptions);
        adComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAD = (String) adComboBox.getSelectedItem();
                updateDataset(selectedAD);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select AD Curve:"));
        panel.add(adComboBox);

        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private void addAnnotations() {
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
    }

    private void updateDataset(String selectedAD) {
        dataset.removeAllSeries();
        dataset.addSeries(createADSeries(selectedAD));
        dataset.addSeries(createSRAS());
        dataset.addSeries(createLRAS());
    }

    private XYSeries createADSeries(String adType) {
        XYSeries adSeries = new XYSeries(adType);
        switch (adType) {
            case "ADk":
                adSeries.add(0, 100);
                adSeries.add(10, 90);
                adSeries.add(20, 80);
                adSeries.add(30, 70);
                break;
            case "ADi":
                adSeries.add(0, 105);
                adSeries.add(10, 95);
                adSeries.add(20, 85);
                adSeries.add(30, 75);
                break;
            case "ADn":
                adSeries.add(0, 110);
                adSeries.add(10, 100);
                adSeries.add(20, 90);
                adSeries.add(30, 80);
                break;
        }
        return adSeries;
    }

    private XYSeries createSRAS() {
        XYSeries sras = new XYSeries("SRAS");
        sras.add(0, 70);
        sras.add(10, 80);
        sras.add(20, 90);
        sras.add(30, 100);
        return sras;
    }

    private XYSeries createLRAS() {
        XYSeries lras = new XYSeries("LRAS");
        lras.add(20, 0);
        lras.add(20, 120);
        return lras;
    }

    private XYSeriesCollection createDataset(String adType) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(createADSeries(adType));
        dataset.addSeries(createSRAS());
        dataset.addSeries(createLRAS());
        return dataset;
    }

    public static void main(String[] args) {
        EconomicGraph chart = new EconomicGraph("Economic Graph");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
