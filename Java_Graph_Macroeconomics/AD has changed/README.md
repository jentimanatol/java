# Macroeconomic Graph Analysis

## Project Description
This project involves analyzing a macroeconomic graph to understand the effects of changes in aggregate demand (AD) due to higher taxes. The aim is to draw new demand lines and analyze the implications on equilibrium price levels, real GDP, and employment.

## Objectives
- Draw a new AD line labeled 'D1' after a tax increase.
- Analyze the impact on the equilibrium price level and real GDP in the short run.
- Determine the feasibility of producing below the full employment level of real GDP.
- Discuss the cost implications of producing below the full employment level of real GDP.

## Instructions
1. **Graph Adjustment**:
    - **AD Change**: Use the line drawing tool to draw the new AD line and label it 'D1'.

2. **Short-run Equilibrium Analysis**:
    - **Price Level**: Analyze whether the new short-run equilibrium price level has increased, decreased, or remained constant.
    - **Real GDP**: Assess whether the real GDP has increased, decreased, or remained constant.

3. **Feasibility of Below Full Employment Production**:
    - Discuss if it is possible or impossible to produce below the full employment level of real GDP in the short run.

4. **Cost Implications**:
    - Determine the cost of producing below the full employment level of real GDP, considering factors like higher unemployment and inflation.

## Data Points and Analysis
- **Graphical Data**: The macroeconomic graph will be used to visually demonstrate the impact of higher taxes on AD.
- **Economic Variables**: Consider changes in price levels, real GDP, and employment levels.
- **Economic Theories**: Apply relevant economic theories to analyze the short-run and long-run effects.



## Project Code Description
This project is a graphical representation of the macroeconomic concepts using Java and the JFreeChart library. The graph includes multiple economic curves such as Aggregate Demand (AD), Long-Run Aggregate Supply (LRAS), Short-Run Aggregate Supply (SRAS), and a shifted Aggregate Demand (AD1). The project visualizes the impact of changes in Aggregate Demand on Real GDP and Price Level.

## Features
- **Graphical Visualization**: Illustrates key macroeconomic concepts through a visual representation.
- **Multiple Curves**: Displays AD, LRAS, SRAS, and AD1 curves.
- **Equilibrium Point Annotation**: Marks the equilibrium point on the graph for clarity.

## Getting Started
### Prerequisites
- Java Development Kit (JDK)
- JFreeChart library

### Installation
1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-repo/macroeconomy-graph.git
    ```
2. **Import the project** into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. **Add JFreeChart library** to the project dependencies.

## Running the Application
1. **Navigate to the main class**:
    ```bash
    src/main/java/MacroeconomyGraph.java
    ```
2. **Run the main class** to launch the graphical interface.

## Project Structure
- **Main Class**: `MacroeconomyGraph` - Extends `JFrame` and sets up the graph.
- **Dataset Creation**: The `createDataset()` method creates the dataset for the chart, including series for AD, LRAS, SRAS, and AD1.
- **Chart Customization**: Customizes the chart's appearance, including color and stroke for different series and adding annotations.

### Example Java Code Snippet
```java
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;

public class MacroeconomyGraph extends JFrame {

    public MacroeconomyGraph(String title) {
        super(title);
        XYSeriesCollection dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Macroeconomy",
                "Real GDP ($ trillions)",
                "Price level",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        XYTextAnnotation annotation = new XYTextAnnotation("E", 12, 120);
        annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        plot.addAnnotation(annotation);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries ad = new XYSeries("AD");
        ad.add(16, 80);
        ad.add(14, 100);
        ad.add(12, 120);
        ad.add(8, 160);

        XYSeries lras = new XYSeries("LRAS");
        lras.add(12, 0);
        lras.add(12, 180);

        XYSeries sras = new XYSeries("SRAS");
        sras.add(4, 80);
        sras.add(10, 100);
        sras.add(12, 120);
        sras.add(14, 160);

        XYSeries ad1 = new XYSeries("AD1");
        ad1.add(14, 80);
        ad1.add(12, 100);
        ad1.add(10, 120);
        ad1.add(6, 160);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(ad);
        dataset.addSeries(lras);
        dataset.addSeries(sras);
        dataset.addSeries(ad1);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MacroeconomyGraph example = new MacroeconomyGraph("Macroeconomy Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}




















