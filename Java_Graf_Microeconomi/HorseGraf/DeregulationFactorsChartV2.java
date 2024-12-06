/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : jkl;[.java
 *  Description: 
 * ******************************************/

 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.data.general.DefaultPieDataset;
 import org.jfree.ui.ApplicationFrame;
 import org.jfree.ui.RefineryUtilities;
 
 import javax.swing.*;
 import java.awt.*;
 
 public class DeregulationFactorsChartV2 extends ApplicationFrame {
 
     public DeregulationFactorsChartV2(String title) {
         super(title);
         setContentPane(createChartPanel());
     }
 
     private JPanel createChartPanel() {
         JPanel panel = new JPanel(new GridLayout(2, 1));
 
         String chartTitle = "Effects of Increased Competition";
         DefaultPieDataset dataset = createCompetitionDataset();
         JFreeChart chart = ChartFactory.createPieChart(chartTitle, dataset);
         panel.add(new ChartPanel(chart));
 
         chartTitle = "Success Factors of Deregulation";
         dataset = createSuccessDataset();
         chart = ChartFactory.createPieChart(chartTitle, dataset);
         panel.add(new ChartPanel(chart));
 
         return panel;
     }
 
     private DefaultPieDataset createCompetitionDataset() {
         DefaultPieDataset dataset = new DefaultPieDataset();
         dataset.setValue("Increased Competition  it can result in lower prices for consumers. This is because multiple firms compete for market share, which can lead to price wars. Additionally, firms may strive to improve efficiency and reduce costs in order to offer competitive pricing.", 50);
         dataset.setValue("No Increase in Competition: If deregulation does not lead to increased competition (for example, if entry barriers are still high), then the market may remain a monopoly or become an oligopoly. In such cases, prices may not decrease significantly and could even increase. Firms with monopoly power can set prices above marginal cost to maximize profits.", 50);
         return dataset;
     }
 
     private DefaultPieDataset createSuccessDataset() {
         DefaultPieDataset dataset = new DefaultPieDataset();
         dataset.setValue("Consumer Prices", 25);
         dataset.setValue("Quality of Service", 25);
         dataset.setValue("Market Competition", 25);
         dataset.setValue("Innovation", 25);
         return dataset;
     }
 
     public static void main(String[] args) {
         DeregulationFactorsChartV2 chart = new DeregulationFactorsChartV2("Deregulation Factors");
         chart.pack();
         RefineryUtilities.centerFrameOnScreen(chart);
         chart.setVisible(true);
     }
 }
 