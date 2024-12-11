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

## Java Code
Include the necessary Java code for any computational analysis or graphical representations here.

```java
// Example Java code snippet for plotting the new AD line
import java.awt.*;
import javax.swing.*;

public class MacroEconomyGraph extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Code to draw the original and new AD lines
        g.drawLine(50, 300, 250, 100); // Original AD line
        g.drawLine(50, 300, 250, 150); // New AD line 'D1'
        g.drawString("AD", 245, 95);
        g.drawString("D1", 245, 145);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Macroeconomic Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MacroEconomyGraph());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
