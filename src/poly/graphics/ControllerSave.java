package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerSave implements MouseListener {

	private PolyView view;
	private PolyModel model;
	
	public ControllerSave(PolyView view, PolyModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String polynomial = getPoly();
		model.list.addNode(name, polynomial);
		
		
	}
	
	private String getPoly() {
		return view.textFieldPolyInput.getText();
	}
	
	private void setNotice(String text) {
		view.lblInputFeedback.setVisible(true);
		view.lblInputFeedback.setText(text);
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
