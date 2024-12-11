/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Sat Jun 22 2024
 *  File : fgfh.java
 *  Description: 
 * ******************************************/
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

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
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Swing
        double[] swingRatios = UtilityCalculator.calculateSwingRatios();
        for (int i = 0; i < UtilityCalculator.QUANTITY_SWING.length; i++) {
            dataset.addValue(swingRatios[i] , "Swing" , Integer.toString(UtilityCalculator.QUANTITY_SWING[i]));
        }

        // Salsa
        double[] salsaRatios = UtilityCalculator.calculateSalsaRatios();
        for (int i = 0; i < UtilityCalculator.QUANTITY_SALSA.length; i++) {
            dataset.addValue(salsaRatios[i] , "Salsa" , Integer.toString(UtilityCalculator.QUANTITY_SALSA[i]));
        }

        return dataset;
    }

    public static void main(String[] args) {
        UtilityChart chart = new UtilityChart(
                "Utility vs Quantity" ,
                "Marginal Utility per Dollar Spent on Swing and Salsa");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
