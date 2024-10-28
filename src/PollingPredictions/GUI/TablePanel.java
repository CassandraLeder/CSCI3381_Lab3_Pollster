package PollingPredictions.GUI;

/*
    This panel will hold the JTable with all relevant data
 */

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JScrollPane implements GUIConstants {
    public JTable dataTable;
    public JScrollPane scrollPane;

    TablePanel(PollTableModel data) {
        // set up table
        dataTable = new JTable();
        dataTable.setModel(data);
        dataTable.setFont(DEFAULT_FONT);

        scrollPane = new JScrollPane(dataTable);
        scrollPane.setPreferredSize(SCROLL_PANE_DIMENSION);
        dataTable.setFillsViewportHeight(true);

        // set up panel
        setPreferredSize(TABLE_PANEL_DIMENSION);
        setBackground(BACKGROUND_COLOR);
        super.add(dataTable);
        setVisible(true);
    }
}
