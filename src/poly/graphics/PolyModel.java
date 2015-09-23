package poly.graphics;

public class PolyModel {

	private Object[][] tableDataColData;
	MainMenu main;
	
	public PolyModel(MainMenu mainMenu) {
		initiateRandomValues();
		main = mainMenu;
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
