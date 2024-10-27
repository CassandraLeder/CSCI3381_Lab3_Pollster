package PollingPredictions.GUI;
/*

 */
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

public class ChartPanel extends JFreeChart implements GUIConstants {
    JFreeChart chart;

    ChartPanel() {
        chart = new JFreeChart("Average Percentage for Each Candidate", new Plot());
    }
}