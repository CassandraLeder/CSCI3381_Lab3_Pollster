package PollingPredictions.GUI;

/*
    This panel will hold the JTable with all relevant data
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class TablePanel extends JScrollPane implements GUIConstants {
    public JTable dataTable;
    public JScrollPane scrollPane;

    TablePanel(PollTableModel data) {
        // set up table
        dataTable = new JTable();
        dataTable.setModel(data);
        dataTable.setFont(DEFAULT_FONT);

        for (int column_index = 0; column_index < dataTable.getColumnCount(); column_index++) {
            TableColumn column = dataTable.getColumnModel().getColumn(column_index);
            column.sizeWidthToFit();
        }

        scrollPane = new JScrollPane(dataTable);
        scrollPane.setPreferredSize(SCROLL_PANE_DIMENSION);
        dataTable.setFillsViewportHeight(true);

        // set up panel
        super.setPreferredSize(TABLE_PANEL_DIMENSION);
        super.setBackground(BACKGROUND_COLOR);
        super.add(scrollPane);
        setVisible(true);
    }
}
