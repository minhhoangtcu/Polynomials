package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEvaluate implements MouseListener{

	private PolyView view;
	
	public ControllerEvaluate(PolyView view) {
		this.view = view;
	}
	
	public void turnEvaluationPanel() {
		boolean isVisible = view.panelEvaluate.isVisible();
		if (isVisible) view.panelEvaluate.setVisible(false);
		else view.panelEvaluate.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object event = e.getSource();
		if (event.equals(view.btnEvaluate)) turnEvaluationPanel();		
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
