package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import poly.graphics.PolyView;

public class ControllerEvaluate implements MouseListener{

	private PolyView view;
	
	public ControllerEvaluate(PolyView view) {
		this.view = view;
	}
	
	public void turnEvaluationPanel() {
		boolean isVisible = view.isEvaluateVisible();
		view.setVisibleEvaluation(!isVisible);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		turnEvaluationPanel();		
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
