package poly.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerSave implements MouseListener {

	private PolyView view;
	
	public ControllerSave(PolyView view) {
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		view.lblInputFeedback.setVisible(true);
		view.lblInputFeedback.setText("Underconstruction");
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
