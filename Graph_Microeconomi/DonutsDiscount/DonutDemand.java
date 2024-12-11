import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class DonutDemand extends ApplicationFrame {

    public DonutDemand(String applicationTitle) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Cops's Demand Curve for Donuts",
                "Quantity","Value",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0.60, "donuts", "1");
        dataset.addValue(0.50, "donuts", "2");
        dataset.addValue(0.40, "donuts", "3");
        dataset.addValue(0.30, "donuts", "4");
        dataset.addValue(0.20, "donuts", "5");
        dataset.addValue(0.10, "donuts", "6");
        return dataset;
    }

    public static void main(String[] args) {
        DonutDemand chart = new DonutDemand("Cops's Demand for Donuts");
        chart.pack();
        chart.setVisible(true);
    }
}
