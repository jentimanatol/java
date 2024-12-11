/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : cgf.java
 *  Description: 
 * ******************************************/

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CostCurvesChart extends ApplicationFrame {

    public CostCurvesChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "Quantity of Output", "Cost",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series1 = new XYSeries("ATC");
        XYSeries series2 = new XYSeries("MC");
        XYSeries series3 = new XYSeries("MR");
        XYSeries series4 = new XYSeries("Number of Units ");
        XYSeries series5 = new XYSeries("Overage Per Unit");
        XYSeries series6 = new XYSeries("Max profit Aria ");
        

        double mr = 300.00;
        // Add data points to the series
        for (int i = -10; i <= 15; i++) {
            double atc = 200 + Math.pow(i, 2);
            series1.add(i + 20, atc);
        }
        for (int i = -20; i <= 20; i++) {
            double mc = 100 + Math.pow(i + 6, 2);
            series2.add(i + 20, mc);
        }

        for (int i = 0; i <= 40; i++) {
          
            series3.add(i, mr);
        }

        series4.add(28, 264);
        series4.add(0, 264);
 series5.add(28, 296);
 series5.add(28, 264);


 for (int i = 0; i <= 27; i++) {
          
    series6.add(i, 296);
    series6.add(i+0.25, 264);
    series6.add(i+0.25, 296);
    series6.add(i+0.5, 264);
    series6.add(i+0.5, 296);
    series6.add(i+1, 264);
}






        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);

        return dataset;
    }

    public static void main(String[] args) {
        CostCurvesChart chart = new CostCurvesChart(
                "Economics Analysis Anatolie Jentimir 6/22/2024",
                "Profit Maximization");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
//A firm in a competitive market maximizes profit where the cost of making one more unit equals the revenue from selling that unit (MC=MR). If making another unit brings in more revenue than its cost (MR>MC), the firm should produce more. If the cost is higher than the revenue (MC>MR), the firm should produce less.