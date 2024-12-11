/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Thu Jun 20 2024
 *  File : f.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.annotations.XYTextAnnotation;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 import org.jfree.chart.renderer.xy.XYAreaRenderer;
 
 import javax.swing.JFrame;
 
 public class ProductionPossibilitiesFrontier {
     public static void main(String[] args) {
         // Create dataset
         XYSeries series1 = new XYSeries("Before Discovery");
         series1.add(0, 100); // Maximum hammers, no horseshoes
         series1.add(50, 80); // Some hammers, some horseshoes (Point E)
         series1.add(70, 60); // Some hammers, some horseshoes (Point I)
         series1.add(100, 0); // No hammers, maximum horseshoes
 
         XYSeries series2 = new XYSeries("After Discovery");
         series2.add(0, 150); // Increased maximum hammers, no horseshoes
         series2.add(75, 120); // Increased production of both goods
         series2.add(100, 50); // Increased maximum horseshoes, fewer hammers
 
         XYSeriesCollection dataset = new XYSeriesCollection();
         dataset.addSeries(series1);
         dataset.addSeries(series2);
 
         // Create chart
         JFreeChart chart = ChartFactory.createXYAreaChart(
                 "Production Possibilities Frontier",
                 "Horseshoes",
                 "Hammers",
                 dataset,
                 PlotOrientation.VERTICAL,
                 true,
                 true,
                 false
         );
 
         // Set the chart to use an area renderer
         chart.getXYPlot().setRenderer(new XYAreaRenderer());
 
         // Add labels for points E and I
         XYTextAnnotation annotationE = new XYTextAnnotation("E", 50, 80);
         XYTextAnnotation annotationI = new XYTextAnnotation("I", 70, 60);
         chart.getXYPlot().addAnnotation(annotationE);
         chart.getXYPlot().addAnnotation(annotationI);
 
         // Create Panel
         ChartPanel panel = new ChartPanel(chart);
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.add(panel);
         frame.pack();
         frame.setVisible(true);
     }
 }
 