import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PPFGraph extends ApplicationFrame {

    public PPFGraph(String title) {
        super(title);
        XYSeries series = new XYSeries("PPF");
        series.add(0, 10);  // Example point
        series.add(10, 6);  // Point B
        series.add(15, 4);  // Point C
        series.add(20, 0);  // Example point

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Production Possibility Frontier",
                "MP3 Players",
                "Watches",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);

        // Adding labels for points B and C
        XYTextAnnotation annotationB = new XYTextAnnotation("B (10, 6)", 10, 6);
        XYTextAnnotation annotationC = new XYTextAnnotation("C (15, 4)", 15, 4);
        plot.addAnnotation(annotationB);
        plot.addAnnotation(annotationC);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        PPFGraph chart = new PPFGraph("Production Possibility Frontier");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
