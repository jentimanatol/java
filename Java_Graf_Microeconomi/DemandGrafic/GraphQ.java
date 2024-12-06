/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : a.java
 *  Description: 
 * ******************************************/
/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Fri Jun 21 2024
 *  File : GraphChangeinSuply.java
 *  Description: 
 * ******************************************/

 
 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 
 import javax.swing.JFrame;
 
 public class GraphQ
  {
     public static void main(String[] args) {
         // Create dataset
         int i ;
         XYSeries series1 = new XYSeries(" Quantity");
        series1.add(0, 0); 
         series1.add(10, 20);  //  series1.add(19, 2);  // series1.add(28, 3);  // series1.add(37, 4); 
        

         XYSeries series2 = new XYSeries("Quantity");

           series2.add(10,20); 
           series2.add(20,0); 
         

         XYSeries series3 = new XYSeries("Demand");

        
           series3.add(0, 20); 
           series3.add(20, 20); 
         
 
         XYSeriesCollection dataset = new XYSeriesCollection();
         dataset.addSeries(series1);
         dataset.addSeries(series2);
         dataset.addSeries(series3);
         
         // Create chart
         JFreeChart chart = ChartFactory.createXYLineChart(
                 "Consumer surplus increases.",
                 "Q Units",
                 "P $ ",
                 dataset,
                 PlotOrientation.VERTICAL,
                 true,
                 true,
                 false
         );
 


  // Set the chart to use an area renderer
       // chart.getXYPlot().setRenderer(new XYAreaRenderer()); // use for shade a portion of the graph

        // Add labels for points Qs and CQS
        XYTextAnnotation annotationQS = new XYTextAnnotation("*", 10, 20);
        XYTextAnnotation annotationQS1 = new XYTextAnnotation("A", 10, 18);
        XYTextAnnotation annotationCQS = new XYTextAnnotation("Demand", 20, 20);
        chart.getXYPlot().addAnnotation(annotationQS);
        chart.getXYPlot().addAnnotation(annotationQS1);
        chart.getXYPlot().addAnnotation(annotationCQS);






         // Create Panel
         ChartPanel panel = new ChartPanel(chart);
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.add(panel);
         frame.pack();
         frame.setVisible(true);
     }
 }
 