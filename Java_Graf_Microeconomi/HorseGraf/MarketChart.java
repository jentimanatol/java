/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : dfd.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.chart.plot.ValueMarker;
 import org.jfree.chart.plot.XYPlot;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 import org.jfree.ui.ApplicationFrame;
 import org.jfree.ui.RefineryUtilities;
 
 import java.awt.*;
 
 public class MarketChart extends ApplicationFrame {
 
     public MarketChart(String applicationTitle , String chartTitle ) {
         super(applicationTitle);
         JFreeChart lineChart = ChartFactory.createXYLineChart(
                 chartTitle,
                 "Quantity","Price",
                 createDataset(),
                 PlotOrientation.VERTICAL,
                 true,true,false);





         // Add labels for points 
         XYTextAnnotation annotation1 = new XYTextAnnotation("                Perfect MP", 50, 50);
         XYTextAnnotation annotation2 = new XYTextAnnotation(" Decrease seling  ", 30, 70);
         XYTextAnnotation annotation3 = new XYTextAnnotation(" Decrease Profit  ", 30, 30);
         XYTextAnnotation annotation4 = new XYTextAnnotation(" Increase Seling  ", 70, 30);
         XYTextAnnotation annotation5 = new XYTextAnnotation(" Increase stock  ", 70, 70);

         lineChart.getXYPlot().addAnnotation(annotation1);
         lineChart.getXYPlot().addAnnotation(annotation2);
         lineChart.getXYPlot().addAnnotation(annotation3);
         lineChart.getXYPlot().addAnnotation(annotation4);
         lineChart.getXYPlot().addAnnotation(annotation5);













 
         ChartPanel chartPanel = new ChartPanel(lineChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
         setContentPane(chartPanel);
     }
 
     private XYSeriesCollection createDataset() {
         XYSeriesCollection dataset = new XYSeriesCollection();
 
         XYSeries series1 = new XYSeries("Supply");
         XYSeries series2 = new XYSeries("Demand");
         XYSeries series3 = new XYSeries("Market Price");
         XYSeries series4 = new XYSeries(" Below Market Price");
         XYSeries series5 = new XYSeries(" Over Market Price");
         XYSeries series6 = new XYSeries("Intersection Points");
 
         // Assume the market price is $20
         double marketPrice = 50.0;
         double marketPriceBelow = 30.0;
         double marketPriceOver = 70.0;
 
         // Add data points to the series
         for (int i = 1; i <= 100; i++) {
             double supplyPrice = i;  
             double demandPrice = 100 - i;  
             series1.add(i, supplyPrice);
             series2.add(i, demandPrice);
             series3.add(i, marketPrice);
             series4.add(i, marketPriceBelow);
             series5.add(i, marketPriceOver);


               // Add intersection points with the market price
            if (supplyPrice == marketPrice || demandPrice == marketPrice) {
                series6.add(i, marketPrice);
            }

         }
 
         dataset.addSeries(series1);
         dataset.addSeries(series2);
         dataset.addSeries(series3);
         dataset.addSeries(series4);
         dataset.addSeries(series5);
         dataset.addSeries(series6);

 
         return dataset;
     }


     public static void main(String[] args) {
        MarketChart chart = new MarketChart(
                "Economics Analysis Anatolie Jentimir" ,
                "Supply, Demand, and Market Price in a Perfectly Competitive Market");
    
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    
        // Get the ChartPanel from the content pane
        ChartPanel chartPanel = (ChartPanel) chart.getContentPane();
    
        // Get the plot
        XYPlot plot = chartPanel.getChart().getXYPlot();
    
        // Add domain (x-axis) markers
        ValueMarker marketPriceMarker = new ValueMarker(50);  // Position is the x-value where y=marketPrice
        marketPriceMarker.setPaint(Color.BLACK);
        plot.addDomainMarker(marketPriceMarker);
    
        ValueMarker belowMarketPriceMarker = new ValueMarker(30);  // Position is the x-value where y=marketPriceBelow
        belowMarketPriceMarker.setPaint(Color.BLACK);
        plot.addDomainMarker(belowMarketPriceMarker);
    
        ValueMarker overMarketPriceMarker = new ValueMarker(70);  // Position is the x-value where y=marketPriceOver
        overMarketPriceMarker.setPaint(Color.BLACK);
        plot.addDomainMarker(overMarketPriceMarker);
    }
    
 /* 
     public static void main(String[] args) {
         MarketChart chart = new MarketChart(
                 "Economics Analysis Anatolie Jentimir" ,
                 "Supply, Demand, and Market Price in a Perfectly Competitive Market");
 
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
 
         // Get the plot
         XYPlot plot = chart.getChart().getXYPlot();
 
         // Add domain (x-axis) markers
         ValueMarker marketPriceMarker = new ValueMarker(50);  // Position is the x-value where y=marketPrice
         marketPriceMarker.setPaint(Color.BLACK);
         plot.addDomainMarker(marketPriceMarker);
 
         ValueMarker belowMarketPriceMarker = new ValueMarker(30);  // Position is the x-value where y=marketPriceBelow
         belowMarketPriceMarker.setPaint(Color.BLACK);
         plot.addDomainMarker(belowMarketPriceMarker);
 
         ValueMarker overMarketPriceMarker = new ValueMarker(70);  // Position is the x-value where y=marketPriceOver
         overMarketPriceMarker.setPaint(Color.BLACK);
         plot.addDomainMarker(overMarketPriceMarker);
     }*/
 }
 