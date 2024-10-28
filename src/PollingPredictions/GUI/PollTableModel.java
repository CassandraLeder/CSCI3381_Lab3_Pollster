package PollingPredictions.GUI;

/*
    Creates the logic for the JTable that displays our polling data
 */

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

import static PollingPredictions.PollStructure.*;

public class PollTableModel implements TableModel {
    final int column_count;
    final int row_count;
    final String[] COLUMNS = final_data_headers.keySet().toArray(new String[0]);
    Object[][] data;
    ArrayList<TableModelListener> listeners;


    public PollTableModel(ArrayList<Object[]> data) {
        column_count = COLUMNS.length;
        row_count = data.size();

        this.data = new Object[data.size()][COLUMNS.length];

        // copy data
        for (int i = 0; i < data.size(); i++)
            this.data[i] = data.get(i);

        listeners = new ArrayList<>();
    }

    @Override
    public int getRowCount() {return row_count;}
    @Override
    public int getColumnCount() {return column_count;}
    @Override
    public String getColumnName(int column) { return new_data_headers.get(column); }
    @Override
    public Class<?> getColumnClass(int columnIndex) { return null; }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { return data[rowIndex][columnIndex]; }

    // in this instance, one should not be able to change the data
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}