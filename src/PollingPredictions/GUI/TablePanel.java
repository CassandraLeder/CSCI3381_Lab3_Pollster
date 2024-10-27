package PollingPredictions.GUI;

/*
    This panel will hold the JTable with all relevant data
 */

import javax.swing.*;

import java.util.ArrayList;

import static PollingPredictions.PollStructure.final_data_headers;

public class TablePanel extends JPanel implements GUIConstants {
    public JTable data_table;

    TablePanel(ArrayList<Object[]> data) {
        setTable(data);
    }

    private void setTable(ArrayList<Object[]> data) {
        // convert TreeMap<String, Integer> to String[]
        String[] columns = final_data_headers.keySet().toArray(new String[0]);
        // convert data from Object[] to Object[][]
        Object[][] table_data = new Object[data.size()][columns.length];

        // there must be a better way!!!!!
        // copy data
        for (int i = 0; i < data.size(); i++) {
            table_data[i] = data.get(i);
        }

        // set up table
        this.data_table = new JTable(table_data, columns);
        data_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        data_table.setBounds(JTABLE_X, JTABLE_Y, JTABLE_WIDTH, JTABLE_HEIGHT);

        // set up frame
        this.setPreferredSize(TABLE_PANEL_DIMENSION);
        this.add(data_table);
        this.setVisible(true);
    }
}
