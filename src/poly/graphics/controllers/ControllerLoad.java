package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerLoad implements MouseListener {
	
	PolyModel model;
	PolyView view;
	
	public ControllerLoad(PolyModel model, PolyView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		JFileChooser fc = new JFileChooser(new File("C:\\"));
		//fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fc.getSelectedFile();
		    view.setIODisplay("Selected file: " + selectedFile.getAbsolutePath());
		    view.setVisibleIO(true);
		}
		else {
			view.setIODisplay("Selected another file");
			view.setVisibleIO(true);
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
