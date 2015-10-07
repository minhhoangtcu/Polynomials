package poly.graphics.models;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import poly.graphics.PolyModel;

@SuppressWarnings({ "serial"})
public class PolyComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {
	
	private PolyModel model;
	private String selected;
	
	public PolyComboBoxModel(PolyModel model) {
		this.model = model;
		selected = null;
	}

	@Override
	public String getElementAt(int i) {
		System.out.println("model get e at: " + model.getName(i));
		return model.getName(i);
	}

	@Override
	public int getSize() {
		System.out.println("model size: " + model.getSize());
		return model.getSize();
	}

	@Override
	public String getSelectedItem() {
		System.out.println("model get selected item: " + selected);
		return selected;
	}

	@Override
	public void setSelectedItem(Object selected) {
		System.out.println("model set selected item: " + (String) selected);
		this.selected = (String) selected; 
		
	}
	
	

}
