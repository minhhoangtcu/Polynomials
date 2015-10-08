package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import poly.arithmatic.PolyMath;
import poly.datastructure.PolyNameNode;
import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerSubtraction implements MouseListener {

	private PolyView view;
	private PolyModel model;
	
	public ControllerSubtraction(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			ArithmaticHelper.checkValidity(view, model);
		}
		catch (IllegalArgumentException exception) {
			view.setVisibleArithDisplay(true);
			view.setArithDisplay(exception.getMessage());
			return;
		}
		
		String name1 = view.getArithInput1Text();
		String name2 = view.getArithInput2Text();
		PolyNameNode node1 = model.getPolyNameNode(name1);
		PolyNameNode node2 = model.getPolyNameNode(name2);
		PolyNameNode subed = PolyMath.subtract(node1, node2);
		view.setArithResult(subed.getPolynomial());
		view.clearArithInput1Text();
		view.clearArithInput2Text();
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
