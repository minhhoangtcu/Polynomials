package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerStoreArith implements MouseListener {

	PolyView view;
	private PolyModel model;
	
	public ControllerStoreArith(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}
	
	private void setNotice(String text) {
		view.setVisibleArithDisplay(true);
		view.setArithDisplay(text);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String polynomial = view.getArithResult();
		String name = view.getArithName();
		
		try {
			model.add(name, polynomial);
			view.repaint();
			setNotice(String.format("Named polymial: %s named %s into the list", polynomial, name));
		} catch (IllegalArgumentException error) {
			setNotice(error.getMessage());
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
