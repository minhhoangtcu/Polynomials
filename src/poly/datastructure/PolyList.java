package poly.datastructure;

import java.util.StringTokenizer;

public class PolyList {
	
	PolyNameNode firstNode, lastNode;
	
	public PolyList() {
		firstNode = null;
		lastNode = null;
	}
	
	/*
	 * Return the size of list (contains Name Nodes)
	 */
	public int size() {
		int size = 0;
		PolyNameNode current = firstNode;
		
		do {
			size++;
			current = current.downNode;
		} while (current != firstNode);
		
		return size;
	}
	
	/*
	 * Create various PolyNode if needed from the provided String.
	 * Input: 6*x^4*y^5*z^3 + 3*x^4*y^5*z^3
	 * After checking for error, we create a NameNode then create various PolyNode
	 * If this is the first Node in the list, we point the variable firstNode to it.
	 * If this is not the first Node in the list (!=null), we point the next variable from the firstNode to it.
	 */
	public PolyNameNode addNode(String name, String polynomial) throws IllegalArgumentException {
		checkAllPolynomials(polynomial); //The program will continue if no error found, else it will throw error.
		
		StringTokenizer st = new StringTokenizer(polynomial, "(+|-)");
		int numberOfPolys = st.countTokens();
		
		//Create the first Name Node
		PolyNameNode nameNode = new PolyNameNode(name, polynomial);
		if (firstNode == null)
			firstNode = nameNode;
		else
			lastNode.downNode = nameNode;
		lastNode = nameNode;
		nameNode.downNode = firstNode;
		
		//Create the poly nodes (right nodes) for the Name Node
		for (int i = 0; i < numberOfPolys; i++) {
			String eachPoly = st.nextToken();
			PolyNode rightNode = getPolyNode(eachPoly);
			nameNode.addNode(rightNode);
		}
		
		return nameNode;
	}
	
	/* 
	 * Create a PolyNode from the provided String
	 */
	protected PolyNode getPolyNode(String polynomial) throws IllegalArgumentException {
		checkPolynomial(polynomial); //The program will continue if no error found, else it will throw error.
		
		StringTokenizer st = new StringTokenizer(polynomial, "*");
				int coeff = Integer.parseInt(st.nextToken().trim());
		String component = st.nextToken().trim();
		int xPower = Integer.parseInt(component.split("\\^")[1]);
		component = st.nextToken().trim();
		int yPower = Integer.parseInt(component.split("\\^")[1]);
		component = st.nextToken().trim();
		int zPower = Integer.parseInt(component.split("\\^")[1]);
		
		PolyNode node = new PolyNode(coeff, xPower, yPower, zPower);
		return node;
	}

	/*
	 * Check if the String input is a valid polynomial or not
	 */
	protected boolean isValid(String polynomial) {
		StringTokenizer st = new StringTokenizer(polynomial, "(+|-)");
		int numberOfPolys = st.countTokens();
		
		for (int i = 0; i < numberOfPolys; i++) {
			String eachPoly = st.nextToken().trim();
			try {
				checkPolynomial(eachPoly);
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Check the validity of the input as many polynomials (a series of them)
	 */
	protected void checkAllPolynomials(String polynomial) throws IllegalArgumentException {
		StringTokenizer st = new StringTokenizer(polynomial, "(+|-)");
		int numberOfPolys = st.countTokens();
		
		for (int i = 0; i < numberOfPolys; i++) {
			String eachPoly = st.nextToken().trim();
			checkPolynomial(eachPoly);
		}
	}
	
	/*
	 * Check the validity of the input as a polynomial
	 * First, we need to check if there is more than one * together or not.
	 * Then, we check separate each components of the polynomials by the asterisk "*" and check them. 
	 * If there are 4 components (the coeff, x, y, z), then pass.
	 * Next, we need to check if each components if they follow the correct format or not: the variable must be x, y, and z accordingly. The power must be a valid integer. Also, we must not have multiple ^^
	 */
	protected void checkPolynomial(String polynomial) throws IllegalArgumentException {
		if (polynomial.matches(".*\\*{2,}.*")) { // If find more than one "*" together
			throw new IllegalArgumentException("Cannot have two * together, please enter the input in the right format."); 
		}
		StringTokenizer st = new StringTokenizer(polynomial, "*");
		int numberOfComponents = st.countTokens();
		
		if (numberOfComponents == 4) {
			// Check the coeff
			try {
				Integer.parseInt(st.nextToken().trim());
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("The coeff of the input polynomial is not an integer");
			}
			
			// Check the first component
			String component = st.nextToken().trim();
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
			component = st.nextToken().trim();
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
			component = st.nextToken().trim();
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
