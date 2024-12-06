/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : jkj.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 import javax.swing.JFrame;
 
 public class LineChartExample {
     public static void main(String[] args) {
         // Create a dataset
         XYSeriesCollection dataset = new XYSeriesCollection();
         XYSeries series = new XYSeries("Hot Chocolate Sales");
         series.add(1, 200);
         series.add(2, 250);
         series.add(3, 275);
         series.add(4, 325);
         dataset.addSeries(series);
 
         // Create a chart
         JFreeChart chart = ChartFactory.createXYLineChart(
             "Hot Chocolate Sales Over Time",
             "Time",
             "Sales",
             dataset
         );
 
         // Create a panel and add the chart to it
         ChartPanel panel = new ChartPanel(chart);
 
         // Create a frame and add the panel to it
         JFrame frame = new JFrame();
         frame.setContentPane(panel);
         frame.setSize(800, 600);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
     }
 }
 