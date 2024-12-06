/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : hgjk.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.data.category.DefaultCategoryDataset;
 import org.jfree.ui.ApplicationFrame;
 
 public class LineChart extends ApplicationFrame {
 
     public LineChart(String applicationTitle) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createLineChart(
                 "Marginal Utility to Price Ratio per Dance Event",
                 "Quantity per Month","Marginal Utility to Price Ratio",
                 createDataset(),
                 org.jfree.chart.plot.PlotOrientation.VERTICAL,
                 true,true,false);
 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
         setContentPane(chartPanel);
     }
 
     private DefaultCategoryDataset createDataset() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 
         // Add data for Swing
         dataset.addValue(14/10.0, "Swing", "1");
         dataset.addValue(27/10.0, "Swing", "2");
         dataset.addValue(60/10.0, "Swing", "3");
         dataset.addValue(100/10.0, "Swing", "5");
         dataset.addValue(120/10.0, "Swing", "6");
         dataset.addValue(145/10.0, "Swing", "8");
 
         // Add data for Salsa
         dataset.addValue(18/12.0, "Salsa", "2");
         dataset.addValue(26/12.0, "Salsa", "3");
         dataset.addValue(75/12.0, "Salsa", "5");
         dataset.addValue(120/12.0, "Salsa", "6");
         dataset.addValue(110/12.0, "Salsa", "5");
         dataset.addValue(150/12.0, "Salsa", "9");
 
         return dataset;
     }
 
     public static void main(String[] args) {
         LineChart chart = new LineChart("Dance Event Utility to Price Ratio Comparison");
         chart.pack();
         chart.setVisible(true);
     }
 }
 