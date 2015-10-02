package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerDisplay implements MouseListener{

	private PolyModel model;
	private PolyView view;
	
	public ControllerDisplay(PolyModel model, PolyView view) {
		this.model = model;
		this.view = view;
	}
	
	/*
	 * Turn on the display polynomial label in database section.
	 */
	public void turnDbDisplayLabel() {
		view.setVisibleDisplay(true);
	}
	
	public void setDbDisplayPoly() {
		int id = view.tableData.getSelectedRow();
		String poly = model.getPoly(id);
		view.setDbDisplay("Displaying: " + poly);
	}
	
	public void setDbDisplayError() {
		view.setDbDisplay("Please select a polynomial from the left.");
	}
	
	/*
	 * Display the appropriate polynomial selected in the table.
	 */
	private void display() {
		turnDbDisplayLabel();
		boolean isSelected = view.tableData.getSelectedRow() != -1; 
		if (isSelected)
			setDbDisplayPoly();
		else
			setDbDisplayError();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		display();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
