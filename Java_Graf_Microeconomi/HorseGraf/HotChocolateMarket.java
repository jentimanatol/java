/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : frt.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 import javax.swing.JFrame;
 
 public class HotChocolateMarket {
 
     private double demand;
     private double supply;
     //private double price;
 
     public HotChocolateMarket(double initialDemand, double initialSupply, double initialPrice) {
         this.demand = initialDemand;
         this.supply = initialSupply;
         //this.price = initialPrice;
     }
 
     public void winterStarts() {
         // Assuming that demand increases by 20% when winter starts
         this.demand *= 1.20;
         calculateEquilibrium();
     }
 
     private void calculateEquilibrium() {
         // For simplicity, let's assume that the equilibrium price is determined by the ratio of supply to demand
        // this.price = this.supply / this.demand;
     }
 
     public void createChart() {
         // Create a dataset
         XYSeriesCollection dataset = new XYSeriesCollection();
         XYSeries series = new XYSeries("Demand");
         series.add(0, this.demand);
         series.add(1, this.demand * 1.10); // Simulate an increase in demand
         dataset.addSeries(series);
 
         series = new XYSeries("Supply");
         series.add(0, this.supply);
         series.add(1, this.supply * 0.90); // Simulate a decrease in supply
         dataset.addSeries(series);
 
         // Create a chart
         JFreeChart chart = ChartFactory.createXYLineChart(
             "Hot Chocolate Market",
             "Time",
             "Quantity",
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
 
     public static void main(String[] args) {
         HotChocolateMarket market = new HotChocolateMarket(100, 100, 1);
         market.winterStarts();
         market.createChart();
     }
 }
 