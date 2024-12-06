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
//import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.XYSeries;
  import org.jfree.data.xy.XYSeriesCollection;
  
  import javax.swing.JFrame;
  
  public class GraphChangeinSuply
   {
      public static void main(String[] args) {
          // Create dataset
          int i ;
          XYSeries series1 = new XYSeries(" Suplay Curv");
         // series1.add(0, 0); // series1.add(10, 1);  //  series1.add(19, 2);  // series1.add(28, 3);  // series1.add(37, 4); 
          for(i=1;i<20;i++){
            series1.add((i*5)/(Math.sqrt(i)), i+2); 
          }

          XYSeries series2 = new XYSeries("Shifted Change in suplay S1");

          for(i=1;i<20;i++){
            series2.add((i*5)/(Math.sqrt(i)), i+4); 
          }

          XYSeries series3 = new XYSeries("Shifted Change in suply S2");

          for(i=1;i<20;i++){
            series3.add((i*5)/(Math.sqrt(i)), i); 
          }
  
          XYSeriesCollection dataset = new XYSeriesCollection();
          dataset.addSeries(series1);
          dataset.addSeries(series2);
          dataset.addSeries(series3);
          
          // Create chart
          JFreeChart chart = ChartFactory.createXYLineChart(
                  "Change in supply and a change in quantity supplied",
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
         XYTextAnnotation annotationQS = new XYTextAnnotation("QS", 10, 6);
         XYTextAnnotation annotationCQS = new XYTextAnnotation("CQS", 20, 18);
         chart.getXYPlot().addAnnotation(annotationQS);
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
  