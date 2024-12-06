import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public class TicketFactorsChart extends ApplicationFrame {

    public TicketFactorsChart(String title) {
        super(title);
        setContentPane(createChartPanel());
    }

    private JPanel createChartPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        String chartTitle = "Demand Factors";
        DefaultPieDataset dataset = createDemandDataset();
        JFreeChart chart = ChartFactory.createPieChart(chartTitle, dataset);
        panel.add(new ChartPanel(chart));

        chartTitle = "Supply Factors";
        dataset = createSupplyDataset();
        chart = ChartFactory.createPieChart(chartTitle, dataset);
        panel.add(new ChartPanel(chart));

        return panel;
    }

    private DefaultPieDataset createDemandDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Popularity", 20);
        dataset.setValue("Performance", 15);
        dataset.setValue("Opponent", 10);
        dataset.setValue("Income Level", 30);
        return dataset;
    }

    private DefaultPieDataset createSupplyDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Stadium Size", 15);
        dataset.setValue("Number of Games", 10);
        return dataset;
    }

    public static void main(String[] args) {
        TicketFactorsChart chart = new TicketFactorsChart("Ticket Price Factors Jentimir Anatolie 6/22/2024");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
//These factors interact in complex ways to determine the equilibrium 
//price in the market for tickets. If demand is high and supply is low,
// prices will be high. Conversely, if demand is low and supply is 
//high, prices will be lower. This is the basic principle of supply and demand.