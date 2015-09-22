package poly.graphics;

public class MainMenu {
	
	PolyController control;
	PolyView view;
	PolyModel model;
	
	public MainMenu() {
		// View is initialized first.
		model = new PolyModel(this);
		view = new PolyView(this);
		control = new PolyController(this);
	}
	
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
		main.view.setVisible(true);
	}

	
}
