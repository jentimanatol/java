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
                 "Marginal Utility per Dance Event",
                 "Quantity per Month","Marginal Utility",
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
         dataset.addValue(14, "Swing", "1");
         dataset.addValue(27, "Swing", "2");
         dataset.addValue(60, "Swing", "3");
         dataset.addValue(100, "Swing", "5");
         dataset.addValue(120, "Swing", "6");
         dataset.addValue(145, "Swing", "8");
 
         // Add data for Salsa
         dataset.addValue(18, "Salsa", "2");
         dataset.addValue(26, "Salsa", "3");
         dataset.addValue(75, "Salsa", "5");
         dataset.addValue(120, "Salsa", "6");
         dataset.addValue(110, "Salsa", "5");
         dataset.addValue(150, "Salsa", "9");
 
         return dataset;
     }
 
     public static void main(String[] args) {
         LineChart chart = new LineChart("Dance Event Utility Comparison");
         chart.pack();
         chart.setVisible(true);
     }
 }
 