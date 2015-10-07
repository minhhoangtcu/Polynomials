package poly.graphics.controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerSolve implements MouseListener{
	
	private PolyView view;
	private PolyModel model;
	
	public ControllerSolve(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		try {
			int x = Integer.parseInt(view.getTextX());
			int y = Integer.parseInt(view.getTextY());
			int z = Integer.parseInt(view.getTextZ());
			
			int index = view.getSelectedPoly();
			if (index < 0) {
				view.setResultSolve("Please select a polynomial you want to solve.");
				view.setVisibleResultSolve(true);
			}			
			else {
				view.setResultSolve("Solved the polynomial, yieding: "+model.solve(index, x, y, z));
			}
			view.updateComboBoxes();
		} catch (NumberFormatException e) {
			view.setResultSolve(e.getMessage());
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
