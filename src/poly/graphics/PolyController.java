package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PolyController implements MouseListener {
	
	private MainMenu main;
	private PolyView view; // Controller do not modify the view. It only get data from the view.
	private PolyModel model; // To change the view. Controller must tell the model to do so.
	
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
		model.turnEvaluationPanel();
	}
	
	/*
	 * Display the appropriate polynomial selected in the table.
	 */
	private void display() {
		model.turnDbDisplayLabel();
		boolean isSelected = view.tableData.getSelectedRow() != -1; 
		if (isSelected)
			model.setDbDisplayPoly();
		else
			model.setDbDisplayError();
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
