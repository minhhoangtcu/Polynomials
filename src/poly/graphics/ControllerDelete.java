package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerDelete implements MouseListener {

	PolyModel model;
	PolyView view;
	
	public ControllerDelete(PolyModel model, PolyView view) {
		this.model = model; 
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = view.getSelectedPoly();
		try {
			model.remove(index);
			view.updateTable();
			System.out.println("Removed " + index);
		} catch (Exception error) {
			view.setDbDisplay(error.getMessage());
		}
		
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
