import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPolygonAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplyDemandGraph extends JFrame {

    private XYPlot plot;
    private ValueMarker priceCeilingMarker;
    private JComboBox<String> priceDropdown;

    public SupplyDemandGraph() {
        Dataset dataset = new Dataset();
        JFreeChart chart = ChartCreator.createChart(dataset.createDataset());
        plot = chart.getXYPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        priceDropdown = new JComboBox<>(new String[] {"$1.60", "$2.00", "$2.40", "$2.80", "$3.20", "$3.60", "$4.00"});
        priceDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePriceCeiling();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Select Price Ceiling:"));
        controlPanel.add(priceDropdown);

        getContentPane().add(chartPanel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updatePriceCeiling() {
        String selectedPrice = (String) priceDropdown.getSelectedItem();
        double price = Double.parseDouble(selectedPrice.replace("$", ""));
        priceCeilingMarker.setValue(price);
        priceCeilingMarker.setLabel("Price Ceiling " + selectedPrice);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SupplyDemandGraph());
    }
}

class Dataset {
    public static final double[] PRICES = {1.60, 2.00, 2.40, 2.80, 3.20, 3.60, 4.00};
    public static final double[] DEMAND_QUANTITIES = {9000, 8500, 8000, 7500, 7000, 6500, 6000};
    public static final double[] SUPPLY_QUANTITIES = {5000, 5500, 6400, 7500, 9000, 11000, 15000};

    public XYSeriesCollection createDataset() {
        XYSeries demandSeries = new XYSeries("Demand");
        XYSeries supplySeries = new XYSeries("Supply");

        for (int i = 0; i < PRICES.length; i++) {
            demandSeries.add(PRICES[i], DEMAND_QUANTITIES[i]);
            supplySeries.add(PRICES[i], SUPPLY_QUANTITIES[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(demandSeries);
        dataset.addSeries(supplySeries);

        return dataset;
    }
}

class ChartCreator {
    public static JFreeChart createChart(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Supply and Demand",
                "Price",
                "Quantity",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        // Adding intersection points and labels
        AnnotationCreator.addAnnotations(plot);

        // Coloring the areas of excess supply and shortage
        AnnotationCreator.addColoredAreas(plot);

        // Adding a line delimitation at the initial price ceiling ($2.40)
        ValueMarker priceCeilingMarker = new ValueMarker(2.40);
        priceCeilingMarker.setPaint(Color.BLACK);
        priceCeilingMarker.setStroke(new BasicStroke(2.0f));
        priceCeilingMarker.setLabel("Price Ceiling $2.40");
        priceCeilingMarker.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        priceCeilingMarker.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
        plot.addDomainMarker(priceCeilingMarker);

        return chart;
    }
}

class AnnotationCreator {
    public static void addAnnotations(XYPlot plot) {
        for (int i = 0; i < Dataset.PRICES.length; i++) {
            plot.addAnnotation(new XYTextAnnotation(
                    String.format("($%.2f, %.0f)", Dataset.PRICES[i], Dataset.DEMAND_QUANTITIES[i]), Dataset.PRICES[i], Dataset.DEMAND_QUANTITIES[i]
            ));
            plot.addAnnotation(new XYTextAnnotation(
                    String.format("($%.2f, %.0f)", Dataset.PRICES[i], Dataset.SUPPLY_QUANTITIES[i]), Dataset.PRICES[i], Dataset.SUPPLY_QUANTITIES[i]
            ));
        }
    }

    public static void addColoredAreas(XYPlot plot) {
        // Excess supply area
        double[] excessSupplyPolygon = {2.80, 7500, 3.20, 9000, 4.00, 15000};
        XYPolygonAnnotation excessSupplyAnnotation = new XYPolygonAnnotation(
                excessSupplyPolygon, null, null, new Color(255, 0, 0, 50)
        );
        plot.addAnnotation(excessSupplyAnnotation);

        // Shortage area
        double[] shortagePolygon = {2.40, 8000, 2.00, 8500, 1.60, 9000};
        XYPolygonAnnotation shortageAnnotation = new XYPolygonAnnotation(
                shortagePolygon, null, null, new Color(0, 0, 255, 50)
        );
        plot.addAnnotation(shortageAnnotation);
    }
}
