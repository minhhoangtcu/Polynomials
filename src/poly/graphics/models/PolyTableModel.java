package poly.graphics.models;

import javax.swing.table.AbstractTableModel;

import poly.graphics.PolyModel;

@SuppressWarnings("serial")
public class PolyTableModel extends AbstractTableModel {
	
	private String[] columnNames;
	private PolyModel model;

	public PolyTableModel (PolyModel model) {
		this.model = model;
		columnNames = model.getColumnNames();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

    public int getRowCount() {
        return model.getSize();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	String output = null;
    	if (col == 0)
    		output = model.getName(row);
    	else if (col == 1)
    		output = model.getPoly(row);
        return output;
    }
}
