/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : dfgd.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.CategoryPlot;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.category.DefaultCategoryDataset;
 import org.jfree.ui.ApplicationFrame;
 import org.jfree.ui.RefineryUtilities;
 import org.jfree.chart.plot.ValueMarker;
 import java.awt.*;
 
 public class UtilityChart extends ApplicationFrame {
 
     public UtilityChart(String applicationTitle , String chartTitle ) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createLineChart(
                 chartTitle,
                 "Quantity","Utility",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true,true,false);
 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
         setContentPane(chartPanel);
 
         // Highlight the line at the equilibrium point
         CategoryPlot plot = lineChart.getCategoryPlot();
         double equilibriumPoint = Data.calculateEquilibriumPoint();
         ValueMarker marker = new ValueMarker(equilibriumPoint);  // position is the value on the axis
         marker.setPaint(Color.red);
         plot.addRangeMarker(marker);
     }
 
     private DefaultCategoryDataset createDataset() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 
         // Swing
         for (int i = 0; i < Data.QUANTITY_SWING.length; i++) {
             double swingRatio = (double) Data.MARGINAL_UTILITY_SWING[i] / Data.SWING_PRICE;
             dataset.addValue(swingRatio , "Swing" , Integer.toString(Data.QUANTITY_SWING[i]));
             System.out.println("Marginal Utility of Swing " + Data.QUANTITY_SWING[i] + " = " + swingRatio );
         }
 
         // Salsa
         for (int i = 0; i < Data.QUANTITY_SALSA.length; i++) {
             double salsaRatio = (double) Data.MARGINAL_UTILITY_SALSA[i] / Data.SALSA_PRICE;
             dataset.addValue(salsaRatio , "Salsa" , Integer.toString(Data.QUANTITY_SALSA[i]));
             System.out.println("Marginal Utility of Salsa " + Data.QUANTITY_SALSA[i] + " = " + salsaRatio );
         }
 
         return dataset;
     }
 
     public static void main(String[] args) {
         UtilityChart chart = new UtilityChart(
                 " Anatolie Jentimir 6/22/2024 Utility vs Quantity" ,
                 "Marginal Utility per Dollar Spent on Swing and Salsa");
 
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
     }
 }
 
 class Data {
     // Prices
     public static final double SWING_PRICE = 10.0;
     public static final double SALSA_PRICE = 12.0;
 
     // Initial data
     public static final int[] QUANTITY_SWING = {1, 2, 3, 5, 6, 8};
     public static final int[] QUANTITY_SALSA = {2, 3, 5, 6, 5, 9};
     public static final int[] MARGINAL_UTILITY_SWING = {14, 27, 60, 100, 120, 145};
     public static final int[] MARGINAL_UTILITY_SALSA = {18, 26, 75, 120, 110, 150};
 

     public static double calculateEquilibriumPoint() {
        // Calcularte the equilirbrium point the orisontal line of intersection of all aproximative thhe same pricce 
        for (int i = 0; i < QUANTITY_SWING.length; i++) {
            double swingRatio = (double) MARGINAL_UTILITY_SWING[i] / SWING_PRICE;
            double salsaRatio = (double) MARGINAL_UTILITY_SALSA[i] / SALSA_PRICE;
            if (Math.abs(swingRatio - salsaRatio) < 0.01) {  // A small threshold is used to account for rounding errors
                System.out.println("Equileibrium Point calculadted = " +  swingRatio);
                return swingRatio;
            }
        }
        return -1;  // Return -1 if no equilibrium point is found
    }
    


 }
 //From the graph and the Java terminal we can se the equilibrium point intersect at 10 and we have 5 clases of swing and 6 clases of salsa 
 