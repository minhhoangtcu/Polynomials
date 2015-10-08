package poly.graphics.controllers;
import poly.graphics.PolyModel;
import poly.graphics.PolyView;

public class ArithmaticHelper {
	
	public static boolean checkValidity(PolyView view, PolyModel model) throws IllegalArgumentException{
		String name1 = view.getArithInput1Text();
		String name2 = view.getArithInput2Text();
		boolean hasName1 = model.hasName(name1);
		boolean hasName2 = model.hasName(name2);
		boolean isEmpty1 = name1.equals("");
		boolean isEmpty2 = name2.equals("");
		
		if (hasName1 && hasName2)
			return true;
		if (isEmpty1 && isEmpty2)
			throw new IllegalArgumentException("Please enter the name of the polynomial.");
		else if (isEmpty1)
			throw new IllegalArgumentException("Please enter the name of the first polynomial.");
		else if (isEmpty2)
			throw new IllegalArgumentException("Please enter the name of the second polynomial.");
		else if (!hasName1 && !hasName2)
			throw new IllegalArgumentException(String.format("%s and %s are not names of polynomials in the list", name1, name2));
		else if (!hasName1)
			throw new IllegalArgumentException(String.format("%s is not a name of a polynomial in the list.", name1));
		else if (!hasName2)
			throw new IllegalArgumentException(String.format("%s is not a name of a polynomial in the list.", name2));
		else return true;
	}

}
