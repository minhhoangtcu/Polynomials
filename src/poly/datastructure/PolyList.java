package poly.datastructure;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.internal.Throwables;

public class PolyList {
	
	private PolyNameNode firstNode;
	private PolyNameNode lastNode;
	
	public PolyList() {
		firstNode = null;
		lastNode = null;
	}
	
	/*
	 * Create various PolyNode if needed from the provided String.
	 * Input: 6*x^4*y^5*z^3 + 3*x^4*y^5*z^3
	 * After checking for error, we create a NameNode then create various PolyNode
	 * If this is the first Node in the list, we point the variable firstNode to it.
	 * If this is not the first Node in the list (!=null), we point the next variable from the firstNode to it.
	 */
	protected void addNode(String polynomial) {
		
		Pattern pat = Pattern.compile(" (+|-) ");
		Matcher mat = pat.matcher(polynomial);
		
		// If there is a + or - sign in the program (more than 1 polynomial), we process as follow.
		if (mat.matches()) {
			
		}
		// If there is only 1 polynomial, we process as follow.
		else {
			
		}
	}
	
	/* 
	 * Create a PolyNode from the provided String
	 */
	protected PolyNode getPolyNode(String polynomial) {
		StringTokenizer st = new StringTokenizer(polynomial, "*");
		
		
		PolyNode node = new PolyNode(0, 0, 0, 0);
		return node;
	}

	protected boolean isValid(String polynomial) {
		try {
			checkComponents(polynomial);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	/*
	 * Check the validity of the input as polynomial
	 * We check each components of the polynomials by the asterisk "*" 
	 * If there are 4 components (the coeff, x, y, z), then pass.
	 * Next, we need to check if each components if they follow the correct format or not.
	 */
	protected void checkComponents(String polynomial) throws IllegalArgumentException {
		StringTokenizer st = new StringTokenizer(polynomial, "*");
		int numberOfComponants = st.countTokens();
		
		if (numberOfComponants == 4) {
			// Check the coeff
			try {
				Integer.parseInt(st.nextToken());
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("The coeff of the input polynomial is not an integer");
			}
			
			// Check the first component
			String component = st.nextToken();
			if (component.matches(".*\\^{2,}.*")) { // If find more than one "^"
				throw new IllegalArgumentException(component + " is not in the right format."); 
			}
			StringTokenizer stComponent = new StringTokenizer(component, "^");
			if (stComponent.countTokens() != 2) {
				throw new IllegalArgumentException(component + " is not in the right format.");
			}
			else { 
				String variable = stComponent.nextToken();
				if (!variable.equals("x")) {
					throw new IllegalArgumentException(variable + " is not x. The first variable must be x");
				}
				String topString = stComponent.nextToken();
				try {
					Integer.parseInt(topString);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(topString + " is not a valid integer. The power of the input polynomial must be an integer");
				}
			}
			
			// Check the second component
			component = st.nextToken();
			if (component.matches(".*\\^{2,}.*")) { // If find more than one "^"
				throw new IllegalArgumentException(component + " is not in the right format."); 
			}
			stComponent = new StringTokenizer(component, "^");
			if (stComponent.countTokens() != 2) {
				throw new IllegalArgumentException(component + " is not in the right format.");
			}
			else { 
				String variable = stComponent.nextToken();
				if (!variable.equals("y")) {
					throw new IllegalArgumentException(variable + " is not y. The second variable must be y");
				}
				String topString = stComponent.nextToken();
				try {
					Integer.parseInt(topString);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(topString + " is not a valid integer. The power of the input polynomial must be an integer");
				}
			}
			
			// Check the third component
			component = st.nextToken();
			if (component.matches(".*\\^{2,}.*")) { // If find more than one "^"
				throw new IllegalArgumentException(component + " is not in the right format."); 
			}
			stComponent = new StringTokenizer(component, "^");
			if (stComponent.countTokens() != 2) {
				throw new IllegalArgumentException(component + " is not in the right format.");
			}
			else { 
				String variable = stComponent.nextToken();
				if (!variable.equals("z")) {
					throw new IllegalArgumentException(variable + " is not z. The third variable must be z");
				}
				String topString = stComponent.nextToken();
				try {
					Integer.parseInt(topString);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(topString + " is not a valid integer. The power of the input polynomial must be an integer");
				}
			}
		}
		else
			throw new IllegalArgumentException("Must input all 4 components: the coefficient, x, y, z. Please review the provided format.");
	}
}
