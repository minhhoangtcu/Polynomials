package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import poly.datastructure.PolyList;
import poly.datastructure.PolyNameNode;
import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ControllerSave implements MouseListener {
	
	PolyModel model;
	PolyView view;

	public ControllerSave(PolyView view, PolyModel model) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		PolyList list = model.getList();
		if (list.isEmpty()) {
			view.setIODisplay("Empty Database. Please store polynomials inside to save to a file.");
		}
		else {
			JFileChooser fc = new JFileChooser(new File("C:\\"));
			fc.setDialogTitle("Save Database");
			
			int returnVal = fc.showSaveDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fc.getSelectedFile();
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
					PolyNameNode current = list.getFirstNode();
					do {
						writer.write(current.getPolyName() + "\n");
						writer.write(current.getRawPolynomial() + "\n");
						current = current.getDownPtr();
					} while (current != list.getFirstNode());
					
					writer.flush();
					writer.close();
					view.setIODisplay("Saved to " + selectedFile.getAbsolutePath());
				} catch (FileNotFoundException e) {
					view.setIODisplay(e.getLocalizedMessage());
				} catch (IOException e) {
					e.printStackTrace();
					view.setIODisplay(e.getMessage());
				}
				view.setVisibleIO(true);
			}
		}
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
