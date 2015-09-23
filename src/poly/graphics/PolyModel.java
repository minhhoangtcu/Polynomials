package poly.graphics;

public class PolyModel {

	private Object[][] tableDataColData;
	PolyView view;
	MainMenu main;
	
	public PolyModel(MainMenu mainMenu) {
		initiateRandomValues();
		main = mainMenu;
		view = main.view;
	}
	
	public void turnEvaluationPanel() {
		boolean isVisible = view.panelEvaluate.isVisible();
		if (isVisible) view.panelEvaluate.setVisible(false);
		else view.panelEvaluate.setVisible(true);
	}
	
	/*
	 * Turn on the display polynomial label in database section.
	 */
	public void turnDbDisplayLabel() {
		view.panelDisplay.setVisible(true);
	}
	
	public void setDbDisplayPoly() {
		int id = view.tableData.getSelectedRow();
		String poly = getPoly(id);
		view.lblDisplay.setText("Displaying: " + poly);
	}
	
	public void setDbDisplayError() {
		view.lblDisplay.setText("Please select a polynomial from the left.");
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
