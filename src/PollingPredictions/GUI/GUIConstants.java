package PollingPredictions.GUI;

/*
    Holds the constants for Swing/AWT
 */


import java.awt.*;

public interface GUIConstants {
    // JFrame
    String FRAME_TITLE = "PollingPredictions";
    int FRAME_WIDTH = 1000;
    int FRAME_HEIGHT = 1000;
    LayoutManager DEFAULT_LAYOUT_MANAGER = new FlowLayout();
    Color BACKGROUND_COLOR = new Color(182,149,192); // a light purple

    // TABLE PANEL
    Dimension TABLE_PANEL_DIMENSION = new Dimension(FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
        // -> JTable
        int JTABLE_X = 150;
        int JTABLE_Y = 50;
        int JTABLE_WIDTH = 200;
        int JTABLE_HEIGHT = 200;

    // STATS PANEL
    Dimension STATS_PANEL_DIMENSION = new Dimension(FRAME_WIDTH / 2, FRAME_HEIGHT / 2);

        // -> etceteron

    // CHART PANEL
    // jFreeChart and such

    // DETAIL PANEL

        // -> yada yada....
}
