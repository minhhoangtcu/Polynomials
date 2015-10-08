/*
 * The Model contains data and manipulation methods.
 */
package poly.graphics;

import poly.datastructure.PolyList;
import poly.datastructure.PolyNameIterator;
import poly.datastructure.PolyNameNode;
import poly.datastructure.PolyNode;

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
		else {
			list.addNode(name, polynomial);
		}
	}
	
	/*
	 * Remove the node with the provided position, i.
	 */
	public void remove(int i) {
		// TODO: write a remove method with provided name (easier to implement and cheaper to perform)
		list.remove(i);
	}
	
	/*
	 * Solve a polynomial with the given index of the poly within the list and the value of x, y, and z
	 */
	public int solve(int index, int x, int y, int z) {
		PolyNameNode poly = list.getNameNode(index);
		PolyNameIterator iter = new PolyNameIterator(poly);
		int output = 0;
		
		PolyNode current = iter.getCurrent();
		do {
			int coeff = current.getCoeff();
			int xP = current.getXPower();
			int yP = current.getYPower();
			int zP = current.getZPower();
			output += coeff*Math.pow(x, xP)*Math.pow(y, yP)*Math.pow(z, zP);
			current = current.next();
		} while (!iter.isFirst(current));
		System.out.println(output);
		return output;
	}
	
	public String[] getColumnNames() {
		return tableDataColNames;
	}
	
	public PolyNameNode getPolyNameNode(String name) {
		return list.getPoly(name);
	}
	
	public String getRawPoly(int i) {
		return list.getRawPoly(i);
	}
	
	public String getFormedPoly(int i) throws IndexOutOfBoundsException{
		return list.getFormedPoly(i);
	}
	
	public String getName(int i) {
		return list.getName(i);
	}
	
	private void initNames() {
		tableDataColNames = new String[2];
		tableDataColNames[0] = "Name";
		tableDataColNames[1] = "Polynomials";
	}
	
	public boolean hasName(String name) {
		return list.hasName(name);
	}
	
	public int getSize() {
		return list.getSize();
	}
	
	public void printList() {
		list.printList();
	}
	
	public PolyList getList() {
		return list;
	}
	
	public void setList(PolyList list) {
		this.list = list;
	}
}
