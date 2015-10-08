/* 
 * Name: Minh Hoang
 * Date: 09/23/2015
 * Program: Polynomials Calculator
 * Purpose: an application to help users to quickly do arithmetic computation with polynomials
 * Features: 
 * 	- Input a polynomial and save it into a database
 * 	- Evaluate a polynomial with the provided value of x, y, and z
 *  - Do arithmetic computation (Add, Subtract and Multiply) on two polynomials
 *  - Store the database of polynomials and load it to use in other time
 *   
 * For more information, please refer to the user guide.
 * 
 */
package poly.graphics;

public class MainMenu {
	
	public PolyController control;
	public PolyView view;
	public PolyModel model;
	
	public MainMenu() {
		// View is initialized first.
		model = new PolyModel(this);
		view = new PolyView(this);
		control = new PolyController(this);
		view.setTitle("Polynomials Calculator - Minh Hoang");
		view.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
	}

	
}
