/*
 * The Model contains data and manipulation methods.
 */
package poly.graphics;

import poly.datastructure.PolyList;

public class PolyModel {

	private String[] tableDataColNames;
	MainMenu main;
	private PolyList list;
	
	public PolyModel(MainMenu mainMenu) {
		initNames();
		main = mainMenu;
		list = new PolyList();
	}
	
	/*
	 * Add the node provided with a name and the raw String form of polynomial to the list
	 */
	public void add(String name, String polynomial) throws IllegalArgumentException{
		if (list.hasName(name))
			throw new IllegalArgumentException("The provided name has already been taken");
		else list.addNode(name, polynomial);
	}
	
	/*
	 * Remove the node with the provided position, i.
	 */
	public void remove(int i) {
		// TODO: write a remove method with provided name (easier to implement and cheaper to perform)
		list.remove(i);
	}
	
	public String[] getColumnNames() {
		return tableDataColNames;
	}
	
	public String getPoly(int i) {
		return list.getPoly(i);
	}
	
	public String getName(int i) {
		return list.getName(i);
	}
	
	private void initNames() {
		tableDataColNames = new String[2];
		tableDataColNames[0] = "Name";
		tableDataColNames[1] = "Polynomials";
	}
	
	public int getSize() {
		return list.getSize();
	}
	
	
}
