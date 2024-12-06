import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class MarketChart extends ApplicationFrame {

    public MarketChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Quantity","Price",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(80000, "Demand", "$1");
        dataset.addValue(64000, "Demand", "$2");
        dataset.addValue(48000, "Demand", "$3");
        dataset.addValue(32000, "Demand", "$4");
        dataset.addValue(16000, "Demand", "$5");
        dataset.addValue(0, "Demand", "$6");
        dataset.addValue(4000, "Supply", "$1");
        dataset.addValue(8000, "Supply", "$2");
        dataset.addValue(12000, "Supply", "$3");
        dataset.addValue(16000, "Supply", "$4");
        dataset.addValue(20000, "Supply", "$5");
        dataset.addValue(24000, "Supply", "$6");
        return dataset;
    }

    public static void main(String[] args) {
        MarketChart chart = new MarketChart(
                "Market Equilibrium",
                "Demand and Supply for Dance Videos");

        chart.pack();
        chart.setVisible(true);
    }
}
