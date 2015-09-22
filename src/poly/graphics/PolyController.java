package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PolyController implements MouseListener {
	
	private MainMenu main;
	private PolyView view;
	private PolyModel model;
	
	public PolyController(MainMenu mainMenu) {
		main = mainMenu; 
		view = main.view;
		model = main.model;
		
		view.btnEvaluate.addMouseListener(this);	
		view.btnDisplay.addMouseListener(this);
	}
	
	/*
	 * Turn on and off the evaluation panel
	 */
	private void evaluate() {
		boolean isVisible = view.panelEvaluate.isVisible();
		if (isVisible) view.panelEvaluate.setVisible(false);
		else view.panelEvaluate.setVisible(true);
	}
	
	/*
	 * Display the appropriate polynomial selected in the table.
	 */
	private void display() {
		view.panelDisplay.setVisible(true);
		boolean isSelected = view.tableData.getSelectedRow() != -1; 
		if (isSelected) {
			int id = view.tableData.getSelectedRow();
			String poly = model.getPoly(id);
			view.lblDisplay.setText("Displaying: " + poly);
		}
		else {
			view.lblDisplay.setText("Please select a polynomial from the left.");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object event = e.getSource();
		if (event.equals(view.btnEvaluate)) evaluate();
		else if (event.equals(view.btnDisplay)) display();
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
