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
 
     public CostCurvesChart(String applicationTitle , String chartTitle ) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createXYLineChart(
                 chartTitle,
                 "Quantity of Output","Cost",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true,true,false);
 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
         setContentPane(chartPanel);
     }
 
     private XYSeriesCollection createDataset() {
         XYSeriesCollection dataset = new XYSeriesCollection();
 
         XYSeries series1 = new XYSeries("ATC");
         XYSeries series2 = new XYSeries("MC");
 
         // Add data points to the series
         for (int i = 1; i <= 100; i++) {
             double atc = 1000 / i;                                   // This is a simplified example of an ATC curve exhibiting economies of scale
             double mc = Math.sqrt(i);                                           // This is a simplified example of an MC curve exhibiting increasing marginal costs
             series1.add(i, atc);
             series2.add(i, mc);
         }
 
         dataset.addSeries(series1);
         dataset.addSeries(series2);
 
         return dataset;
     }
 
     public static void main(String[] args) {
         CostCurvesChart chart = new CostCurvesChart(
                 "Economics Analysis Anatolie Jentimir 6/22/2024" ,
                 "Average Total Cost and Marginal Cost Curves");
 
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
     }
 }
 