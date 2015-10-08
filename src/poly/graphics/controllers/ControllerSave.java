package poly.graphics.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import poly.datastructure.PolyList;
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
		JFileChooser fc = new JFileChooser(new File("C:\\"));
		fc.setDialogTitle("Save Database");
		int returnVal = fc.showSaveDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			FileOutputStream saveFile;
			try {
				saveFile = new FileOutputStream(selectedFile);
				ObjectOutputStream save = new ObjectOutputStream(saveFile);
				PolyList list = model.getList();
				save.writeObject(list);
				save.flush();
				save.close();
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
