/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : dfg.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 
 import javax.swing.*;
 
 public class HotChocolateDemandQP {
 
     public static void main(String[] args) {
        System.out.println(6*10+5*20+4*30+3*40);
         SwingUtilities.invokeLater(() -> {
             JFrame frame = new JFrame("Hot Chocolate Market Analysis");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(600, 400);
 
             XYSeries seriesBefore = new XYSeries("Before Winter");
             seriesBefore.add(5, 20); // Add data points (Quantity, Price)
             seriesBefore.add(15, 15);
 
             XYSeries seriesAfter = new XYSeries("After Winter Starts");
             seriesAfter.add(5, 30); // Demand increases
             seriesAfter.add(15, 25); // New equilibrium
 
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
 
 