package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerSave implements MouseListener {

	private PolyView view;
	private PolyModel model;
	
	public ControllerSave(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String polynomial = view.getPolynomialInput();
		String name = view.getNameInput();
		try {
			model.add(name, polynomial);
			view.repaint();
			setNotice(String.format("Named polymial: %s named %s into the list", polynomial, name));
		} catch (IllegalArgumentException e) {
			setNotice(e.getMessage());
		}
	}
	
	private void setNotice(String text) {
		view.setVisibleInput(true);
		view.setInputDisplay(text);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
