/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : fch.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
 import org.jfree.ui.ApplicationFrame;
 
 public class TicketPriceChart extends ApplicationFrame {
 
     public TicketPriceChart(String applicationTitle, String chartTitle) {
         super(applicationTitle);
         JFreeChart barChart = ChartFactory.createBarChart(
                 chartTitle,
                 "Category",
                 "Score",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true, true, false);
 
         ChartPanel chartPanel = new ChartPanel(barChart);
         setContentPane(chartPanel);
     }
 
     private DefaultCategoryDataset createDataset() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         dataset.addValue(15.0, "Atlanta", "Turner Field");
         dataset.addValue(25.0, "Boston", "Fenway Park");
         return dataset;
     }
 
     public static void main(String[] args) {
         TicketPriceChart chart = new TicketPriceChart(
                 "Ticket Price Comparison",
                 "Price vs Location");
         chart.pack();
         chart.setVisible(true);
     }
 }
 