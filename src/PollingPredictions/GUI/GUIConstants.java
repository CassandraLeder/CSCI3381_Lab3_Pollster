package PollingPredictions.GUI;

/*
    Holds the constants for Swing/AWT.
 */

import java.awt.*;

public interface GUIConstants {
    // JFrame
    String FRAME_TITLE = "PollingPredictions";
    int FRAME_WIDTH = 1000;
    int FRAME_HEIGHT = 1000;
    LayoutManager DEFAULT_LAYOUT_MANAGER = new CardLayout();
    Color BACKGROUND_COLOR = new Color(124,185,232); // a nice blue
    Font DEFAULT_FONT = new Font("Times New Roman", Font.PLAIN, 15);

    // TABLE PANEL
    Dimension TABLE_PANEL_DIMENSION = new Dimension(FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
        // -> JTable
        int JTABLE_X = 150;
        int JTABLE_Y = 50;
        int JTABLE_WIDTH = 400;
        int JTABLE_HEIGHT = 400;

    // STATS PANEL
    Dimension STATS_PANEL_DIMENSION = new Dimension(FRAME_WIDTH / 2, FRAME_HEIGHT / 2);
    int JTEXTBOX_SIZE = 100;
        // -> etceteron

    // CHART PANEL
    // jFreeChart and such

    // DETAIL PANEL

        // -> yada yada....
}
