package poly.datastructure;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.junit.internal.Throwables;

public class PolyList {
	
	private PolyNameNode firstNode, lastNode;
	
	public PolyList() {
		firstNode = null;
		lastNode = null;
	}
	
	/*
	 * Print the list of nodes for testing
	 */
	public void printList() {
		PolyNameNode current = firstNode;
		int i = 0;
		System.out.println("**************************************************");
		System.out.println("Printing data");
		do {
			System.out.println(i + "\t name: " + current.getPolyName() + "\t poly: " + current.getPolynomial());
			i++;
			current = current.getDownPtr();
		} while (current != firstNode);
		System.out.println("**************************************************");
	}
	
	/*
	 * Search through the list linearly from the first node to find node with similar name
	 * 	If the poly is empty, then there is no such node with the same name
	 */
	public boolean hasName(String name) {
		if (firstNode == null) return false;
		PolyNameNode current = firstNode;
		do {
			if (current.getPolyName().equals(name)) return true;
			current = current.getDownPtr();
		} while (current != firstNode);
		return false;
	}
	
	/*
	 * Remove the NameNode with index i in the list
	 * If there is only 1 node within the list, set both first and last node to null.
	 * If the NameNode is the first node. We will remove the first node.
	 * If the NameNode is somewhere in between, we will find the previous node of the node we want to remove. Then we remove that node:
	 * 	The for loop will run to index i (the position of the node we want to remove)
	 * 	We then check if it is the last node or not. If yes, set the previous of the removing node to last node.
	 * 	Else, we remove like usual.
	 * @param i the index or position of the removing node
	 */
	public void remove(int i) throws NoSuchElementException, IndexOutOfBoundsException{
		int size = getSize();
		if (isEmpty())
			throw new NoSuchElementException("The list is empty");
		else if ((i >= size) | (i < 0)) throw new IndexOutOfBoundsException();
		else {
			if (size == 1) {
				firstNode = null;
				lastNode = null;
			}
			else if (i == 0) {
				firstNode = firstNode.getDownPtr();
				lastNode.setDownPtr(firstNode);
			}
			else {
				PolyNameNode previous = null;
				PolyNameNode current = getFirstNode();
				for (int j = 0; j < i; j++) {
					previous = current;
					current = current.getDownPtr();
				}
				
				if (current == lastNode) {
					lastNode = previous;
				}
				PolyNameNode next = current.getDownPtr();
				previous.setDownPtr(next);
			}
		}
	}
	
	/*
	 * Return the NameNode with index i in the list
	 */
	public PolyNameNode getNameNode(int i)  throws IndexOutOfBoundsException{
		int size = getSize();
		if (i == 0) return firstNode;
		else if (i == size-1) return lastNode;
		else if ((i >= size) | (i < 0)) throw new IndexOutOfBoundsException();
		else {
			PolyNameNode current = firstNode;
			for (int j = 0; j < i; j++)
				current = current.getDownPtr();
			return current;
		}
	}
	
	public PolyNameNode getNameNode(String name) throws IllegalArgumentException{
		PolyNameNode current = firstNode;
		do {
			if (current.getPolyName().equals(name)) return current;
			current = current.getDownPtr();
		} while (current != firstNode);
		throw new IllegalArgumentException("No polynomial has such name");
	}
	
	/*
	 * Return the size of list (contains Name Nodes)
	 */
	public int getSize() {
		if (isEmpty()) return 0;
		else {
			int size = 0;
			PolyNameNode current = firstNode;
			
			do {
				size++;
				current = current.getDownPtr();
			} while (current != firstNode);
			
			return size;
		}
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	/*
	 * Add a node with the provided name and polynomial to the list
	 */
	public PolyNameNode addNode(String name, String polynomial) throws IllegalArgumentException {
		System.out.println("*************************************************");
		System.out.println("Adding " + polynomial + " to the list of NameNode");
		PolyNameNode adding = createNameNode(name, polynomial);
		addNodeToList(adding);
		return adding;
	}
	
	/*
	 * Add the provided node to the list
	 */
	public void addNodeToList(PolyNameNode adding) throws IllegalArgumentException {
		if (firstNode == null)
			firstNode = adding;
		else // Add the node to the last place
			lastNode.setDownPtr(adding);
		lastNode = adding;
		lastNode.setDownPtr(firstNode);
	}
	
	/*
	 * Create various PolyNode if needed from the provided String.
	 * Input: 6*x^4*y^5*z^3 + 3*x^4*y^5*z^3
	 * After checking for error, we create a NameNode then create various PolyNode
	 * If this is the first Node in the list, we point the variable firstNode to it.
	 * If this is not the first Node in the list (!=null), we point the next variable from the firstNode to it.
	 */
	public PolyNameNode createNameNode(String name, String polynomial) throws IllegalArgumentException {
		checkAllPolynomials(polynomial); //The program will continue if no error found, else it will throw error.
		PolyNameNode nameNode = new PolyNameNode(name, polynomial);
		StringTokenizer st = new StringTokenizer(polynomial, " + ");
		int numberOfPolys = st.countTokens();
		for (int i = 0; i < numberOfPolys; i++) {
			String eachPoly = st.nextToken();
			PolyNode rightNode = createPolyNode(eachPoly);
			nameNode.addNode(rightNode);
		}
		return nameNode;
	}
	
	/* 
	 * Create a PolyNode from the provided String
	 */
	protected PolyNode createPolyNode(String polynomial) throws IllegalArgumentException {
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
		StringTokenizer st = new StringTokenizer(polynomial, " + ");
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
		StringTokenizer st = new StringTokenizer(polynomial, " +) ");
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

	public PolyNameNode getFirstNode() {
		return firstNode;
	}
	
	public PolyNameNode getLastNode() {
		return lastNode;
	}
	
	public String getFormedPoly(int i) throws IndexOutOfBoundsException {
		return getNameNode(i).getPolynomial();
	}
	
	public String getRawPoly(int i) throws IndexOutOfBoundsException {
		return getNameNode(i).getRawPolynomial();
	}
	
	public PolyNameNode getPoly(String name) throws IllegalArgumentException {
		return getNameNode(name);
	}
	
	public String getName(int i) throws IndexOutOfBoundsException {
		return getNameNode(i).getPolyName();
	}
}
