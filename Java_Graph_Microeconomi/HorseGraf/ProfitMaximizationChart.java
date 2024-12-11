/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : hh.java
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
 
 public class ProfitMaximizationChart extends ApplicationFrame {
 
     public ProfitMaximizationChart(String applicationTitle , String chartTitle ) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createXYLineChart(
                 chartTitle,
                 "Quantity","Cost/Revenue",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true,true,false);
 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
         setContentPane(chartPanel);
     }
 
     private XYSeriesCollection createDataset() {
         XYSeriesCollection dataset = new XYSeriesCollection();
 
         XYSeries series1 = new XYSeries("MC");
         XYSeries series2 = new XYSeries("MR");
 
         // Add data points to the series
         for (int i = 1; i <= 100; i++) {
             double mc = i;  // This is a simplified example of a MC curve
             double mr = 100 - i;  // This is a simplified example of a MR curve
             series1.add(i, mc);
             series2.add(i, mr);
         }
 
         dataset.addSeries(series1);
         dataset.addSeries(series2);
 
         return dataset;
     }
 
     public static void main(String[] args) {
         ProfitMaximizationChart chart = new ProfitMaximizationChart(
                 "Economics Analysis" ,
                 "Marginal Cost and Marginal Revenue Curves");
 
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
     }
 }
 