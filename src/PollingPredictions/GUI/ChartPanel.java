package PollingPredictions.GUI;
/*
    At the moment, I have no idea how this works.
 */
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

import java.awt.*;

public class ChartPanel extends JFreeChart implements GUIConstants {
    JFreeChart chart;

    public ChartPanel(String title, Font titleFont, Plot plot, boolean createLegend) {
        super(title, titleFont, plot, createLegend);
    }
}