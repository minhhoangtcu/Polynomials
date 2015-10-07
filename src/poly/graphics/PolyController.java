/*
 * The controller assigns listeners to various GUI components.
 */
package poly.graphics;

import poly.graphics.controllers.ControllerAddition;
import poly.graphics.controllers.ControllerDelete;
import poly.graphics.controllers.ControllerDisplay;
import poly.graphics.controllers.ControllerEvaluate;
import poly.graphics.controllers.ControllerLoad;
import poly.graphics.controllers.ControllerSave;
import poly.graphics.controllers.ControllerSolve;
import poly.graphics.controllers.ControllerSubtraction;

public class PolyController {
	
	private MainMenu main;
	private PolyView view; // Controller do not modify the view. It only get data from the view.
	private PolyModel model; // To change the view. Controller must tell the model to do so.
	private ControllerSave conSave;
	private ControllerEvaluate conEvaluate;
	private ControllerDisplay conDisplay;
	private ControllerLoad conLoad;
	private ControllerDelete conDelete;
	private ControllerSolve conSolve;
	private ControllerAddition conAdd;
	private ControllerSubtraction conSub;
	
	public PolyController(MainMenu mainMenu) {
		main = mainMenu; 
		view = main.view;
		model = main.model;
		
		conSave = new ControllerSave(view, model);
		conEvaluate = new ControllerEvaluate(view);
		conDisplay = new ControllerDisplay(model, view);
		conLoad = new ControllerLoad(model, view);
		conDelete = new ControllerDelete(model, view);
		conSolve = new ControllerSolve(view, model);
		conAdd = new ControllerAddition(view, model);
		conSub = new ControllerSubtraction(view, model);
		
		view.btnSolve.addMouseListener(conSolve);
		view.btnSave.addMouseListener(conSave);
		view.btnEvaluate.addMouseListener(conEvaluate);	
		view.btnDisplay.addMouseListener(conDisplay);
		view.btnLoadDb.addMouseListener(conLoad);
		view.btnDelete.addMouseListener(conDelete);
		view.btnAdd.addMouseListener(conAdd);
		view.btnSubtract.addMouseListener(conSub);
	}
}
