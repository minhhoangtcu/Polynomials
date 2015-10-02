/*
 * The Model contains data and manipulation methods.
 */
package poly.graphics;

import poly.datastructure.PolyList;
import poly.datastructure.PolyNameIterator;
import poly.datastructure.PolyNameNode;

public class PolyModel {

	private Object[][] tableDataColData;
	MainMenu main;
	PolyList list;
	int numberOfNode;
	
	public PolyModel(MainMenu mainMenu) {
		initiateRandomValues();
		main = mainMenu;
		list = new PolyList();
		numberOfNode = 0;
	}
	
	public void add(String name, String polynomial) throws IllegalArgumentException{
		PolyNameNode addingNode = list.addNode(name, polynomial);
		PolyNameIterator iterator = new PolyNameIterator(addingNode);
		tableDataColData[numberOfNode][0] = name;
		tableDataColData[numberOfNode][1] = iterator.getPolynomial();
		numberOfNode++;
	}
	
	public Object[][] getData() {
		return tableDataColData;
	}
	
	public String getPoly(int id) {
		return (String) tableDataColData[id][1];
	}
	
	private void initiateRandomValues() {
		tableDataColData = new Object[2][2];
		tableDataColData[0][0] = "1";
		tableDataColData[1][0] = "2";
		tableDataColData[0][1] = "test test test";
		tableDataColData[1][1] = "test test test test";
	}

}
