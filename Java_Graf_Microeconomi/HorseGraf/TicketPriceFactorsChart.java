import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TicketPriceFactorsChart extends ApplicationFrame {

    public TicketPriceFactorsChart(String title) {
        super(title);
        setContentPane(createChartPanel());
    }

    private ChartPanel createChartPanel() {
        String chartTitle = "Factors Affecting Ticket Prices";
        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createPieChart(chartTitle, dataset);

        return new ChartPanel(chart);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Popularity", 20);
        dataset.setValue("Performance", 15);
        dataset.setValue("Opponent Quality", 10);
        dataset.setValue("Income Level", 30);
        dataset.setValue("Stadium Size", 15);
        dataset.setValue("Number of Games", 10);

        return dataset;
    }

    public static void main(String[] args) {
        TicketPriceFactorsChart chart = new TicketPriceFactorsChart("Ticket Price Factors");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
