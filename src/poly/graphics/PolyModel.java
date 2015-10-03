/*
 * The Model contains data and manipulation methods.
 */
package poly.graphics;

import poly.datastructure.PolyList;

public class PolyModel {

	private String[] tableDataColNames;
	MainMenu main;
	PolyList list;
	
	public PolyModel(MainMenu mainMenu) {
		initNames();
		main = mainMenu;
		list = new PolyList();
	}
	
	public void add(String name, String polynomial) throws IllegalArgumentException{
		list.addNode(name, polynomial);
	}
	
	public void remove(int i) {
		list.remove(i);
	}
	
	public String[] getColumnNames() {
		return tableDataColNames;
	}
	
	public String getPoly(int i) {
		return list.getPoly(i);
	}
	
	private void initNames() {
		tableDataColNames = new String[2];
		tableDataColNames[0] = "Name";
		tableDataColNames[1] = "Polynomials";
	}
	
}
