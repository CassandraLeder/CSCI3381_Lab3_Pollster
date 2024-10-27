package PollingPredictions;

/*
    This panel will hold the JTable with all relevant data
 */

import javax.swing.*;

public class TablePanel extends JPanel implements GUIConstants {
    public JTable data_table;
    private DataCollector dataCollector;

    TablePanel(DataCollector dataCollector) {
        data_table = new JTable();
        this.dataCollector = dataCollector;
        setTable();
    }

    private void setTable() {
        data_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        data_table.setBounds(JTABLE_X, JTABLE_Y, JTABLE_WIDTH, JTABLE_HEIGHT);

        this.setPreferredSize(TABLE_PANEL_DIMENSION);
        this.add(data_table);
    }

    public void addDataToTable() {

    }
}
