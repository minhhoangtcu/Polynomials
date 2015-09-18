package poly.graphics;

public class MainMenu {
	
	PolyController control;
	PolyView view;
	PolyModel model;
	
	public MainMenu() {
		control = new PolyController(this);
		view = new PolyView(this);
		model = new PolyModel(this);
	}
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

	
}
