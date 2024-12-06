/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : x.java
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
 
 public class ProductionFunctionChart extends ApplicationFrame {
 
     public ProductionFunctionChart(String applicationTitle , String chartTitle ) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createXYLineChart(
                 chartTitle,
                 "Input","Output",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true,true,false);
 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
         setContentPane(chartPanel);
     }
 
     private XYSeriesCollection createDataset() {
         XYSeriesCollection dataset = new XYSeriesCollection();
         XYSeries series = new XYSeries("Production Function");
 
         // Add data points to the series
         for (int i = 1; i <= 100; i++) {
             double output = 100 * Math.log(i + 1);                      // This is a simplified example of a production function exhibiting diminishing marginal product
             series.add(i, output);
         }
 
         dataset.addSeries(series);
         return dataset;
     }
 
     public static void main(String[] args) {
         ProductionFunctionChart chart = new ProductionFunctionChart(
                 "Economics Analysis Anatolie Jentimir " ,
                 "Production Function with Diminishing Marginal Product");
 
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
     }
 }
 