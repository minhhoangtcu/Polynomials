package poly.graphics.models;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import poly.graphics.PolyModel;

@SuppressWarnings({ "serial", "rawtypes" })
public class PolyComboBoxModel extends AbstractListModel implements ComboBoxModel {
	
	private PolyModel model;
	private String selected;
	
	public PolyComboBoxModel(PolyModel model) {
		this.model = model;
		selected = null;
	}

	@Override
	public Object getElementAt(int i) {
		return model.getName(i);
	}

	@Override
	public int getSize() {
		return model.getSize();
	}

	@Override
	public Object getSelectedItem() {
		return selected;
	}

	@Override
	public void setSelectedItem(Object selected) {
		this.selected = (String) selected; 
		
	}
	
	

}
