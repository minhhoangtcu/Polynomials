package poly.graphics;

import javax.swing.table.AbstractTableModel;

import poly.datastructure.PolyList;
import poly.datastructure.PolyListIterator;

@SuppressWarnings("serial")
public class PolyTableModel extends AbstractTableModel {
	
	private String[] columnNames;
	private PolyList list;
	private PolyModel model;
	private PolyListIterator iterator;

	public PolyTableModel (PolyModel model) {
		this.model = model;
		columnNames = model.getColumnNames();
		list = model.list;
		iterator = new PolyListIterator(list);
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

    public int getRowCount() {
        return list.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	String output = null;
    	if (col == 0)
    		output = iterator.getName(row);
    	else if (col == 1)
    		output = iterator.getPoly(row);
        return output;
    }

    /*public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }*/

}
