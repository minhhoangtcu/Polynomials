package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import poly.datastructure.PolyList;
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
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select a database saved by this application");
		
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fc.getSelectedFile();
		    try {
				BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
				PolyList list = new PolyList();
				
				String name = null;
				while ((name = reader.readLine()) != null) {
					String poly = reader.readLine();
					list.addNode(name, poly);
				}
				
				reader.close();
				view.repaintEverything();
				model.setList(list);
				view.setIODisplay("Selected file: " + selectedFile.getAbsolutePath());
				view.setVisibleIO(true);
			} catch (FileNotFoundException e1) {
				view.setIODisplay(e1.getLocalizedMessage());
			} catch (IOException e1) {
				view.setIODisplay(e1.getMessage());
			}
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
