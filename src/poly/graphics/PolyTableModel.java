package poly.graphics;

import javax.swing.table.AbstractTableModel;

import poly.datastructure.PolyList;

@SuppressWarnings("serial")
public class PolyTableModel extends AbstractTableModel {
	
	private String[] columnNames;
	private PolyList list;
	private PolyModel model;

	public PolyTableModel (PolyModel model) {
		this.model = model;
		columnNames = model.getColumnNames();
		list = model.list;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

    public int getRowCount() {
        return list.getSize();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	String output = null;
    	if (col == 0)
    		output = list.getName(row);
    	else if (col == 1)
    		output = list.getPoly(row);
        return output;
    }
}
