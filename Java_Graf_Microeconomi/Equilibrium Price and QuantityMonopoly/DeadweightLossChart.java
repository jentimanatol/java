import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class DeadweightLossChart extends ApplicationFrame {

    public DeadweightLossChart(String title) {
        super(title);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                title,
                "Quantity",
                "Price",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries demandSeries = new XYSeries("Demand");
        XYSeries supplySeries = new XYSeries("Supply (MC)");
        XYSeries mrSeries = new XYSeries("MR");

        for (int i = 0; i <= 100; i++) {
            demandSeries.add(i, 100 - i);
            supplySeries.add(i, i);
            mrSeries.add(i, 100 - 2 * i);
        }

        dataset.addSeries(demandSeries);
        dataset.addSeries(supplySeries);
        dataset.addSeries(mrSeries);

        return dataset;
    }

    public static void main(String[] args) {
        DeadweightLossChart chart = new DeadweightLossChart("Deadweight Loss in Monopoly");
        chart.pack();
        chart.setVisible(true);
    }
}
