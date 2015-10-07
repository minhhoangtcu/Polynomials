package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import poly.arithmatic.PolyMath;
import poly.datastructure.PolyNameNode;
import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerAddition implements MouseListener  {

	private PolyView view;
	private PolyModel model;
	
	public ControllerAddition(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String name1 = view.getArithInput1Text();
		String name2 = view.getArithInput2Text();
		boolean hasName1 = model.hasName(name1);
		boolean hasName2 = model.hasName(name2);
		boolean isEmpty1 = name1.equals("");
		boolean isEmpty2 = name2.equals("");
		
		if (hasName1 && hasName2) {
			PolyNameNode node1 = model.getPolyNameNode(name1);
			PolyNameNode node2 = model.getPolyNameNode(name2);
			PolyNameNode added = PolyMath.add(node1, node2);
			view.setArithResult(added.getPolynomial());
			view.clearArithInput1Text();
			view.clearArithInput2Text();
		}
		else if (isEmpty1 && isEmpty2) {
			view.setVisibleArithDisplay(true);
			view.setArithDisplay("Please enter the name of the polynomial.");
		}
		else if (isEmpty1) {
			view.setVisibleArithDisplay(true);
			view.setArithDisplay("Please enter the name of the first polynomial.");
		}
		else if (isEmpty2) {
			view.setVisibleArithDisplay(true);
			view.setArithDisplay("Please enter the name of the second polynomial.");
		}
		else if (!hasName1 && !hasName2){
			view.setVisibleArithDisplay(true);
			view.setArithDisplay(String.format("%s and %s are not names of polynomials in the list", name1, name2));
			view.clearArithInput1Text();
			view.clearArithInput2Text();
		}
		else if (!hasName1){
			view.setVisibleArithDisplay(true);
			view.setArithDisplay(String.format("%s is not a name of a polynomial in the list.", name1));
			view.clearArithInput1Text();
		}
		else if (!hasName2){
			view.setVisibleArithDisplay(true);
			view.setArithDisplay(String.format("%s is not a name of a polynomial in the list.", name2));
			view.clearArithInput2Text();
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
