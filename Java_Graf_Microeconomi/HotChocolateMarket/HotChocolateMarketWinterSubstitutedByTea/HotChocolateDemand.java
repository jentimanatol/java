/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : dsfgerdfgch.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 
 import javax.swing.*;
 
 public class HotChocolateDemand {
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             JFrame frame = new JFrame("Hot Chocolate Market Analysis");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(600, 400);
 
             XYSeries seriesBefore = new XYSeries("Before Tea Price Falls");
             seriesBefore.add(5, 20); // Add data points (Quantity, Price)
             seriesBefore.add(15, 15);
 
             XYSeries seriesAfter = new XYSeries("After Tea Price Falls");
             seriesAfter.add(5, 10); // Demand decreases
             seriesAfter.add(15, 5); // New equilibrium
 
             XYSeriesCollection dataset = new XYSeriesCollection();
             dataset.addSeries(seriesBefore);
             dataset.addSeries(seriesAfter);
 
             JFreeChart chart = ChartFactory.createXYLineChart(
                     "Hot Chocolate Market Analysis",
                     "Quantity",
                     "Price",
                     dataset,
                     PlotOrientation.VERTICAL,
                     true,
                     true,
                     false
             );
 
             ChartPanel chartPanel = new ChartPanel(chart);
             frame.setContentPane(chartPanel);
             frame.setVisible(true);
         });
     }
 }
 