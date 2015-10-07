package poly.datastructure;

/*
 * A node containing raw String file of the polynomial and the name.
 * This also act as a circular list (containing the first and last nodes references)
 */
public class PolyNameNode implements PolyNameNodeInterface {

	private String name;
	private String polynomial;
	private PolyNameNode downNode;
	private PolyNode firstRightNode;
	PolyNode lastRightNode;
	
	public PolyNameNode(String name, String polynomial) {
		this.name = name;
		this.polynomial = polynomial;
		downNode = null;
		firstRightNode = null;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		PolyNode currentNode = firstRightNode;
		int size = 0;
		do {
			currentNode = currentNode.nextNode;
			size++;
		} while(currentNode != firstRightNode);
		return size;
	}
	
	/*
	 * Add new node to the list.
	 */
	public void addNode(PolyNode p) {
		if (firstRightNode == null) {
			firstRightNode = p;
			lastRightNode = p;
			p.nextNode = firstRightNode;
			System.out.printf("%s: Added first node(%s) into the list%n", polynomial, p.toString());
		}
		else {
			PolyNode current = firstRightNode;
			PolyNode previous = lastRightNode;
			int sumOfCurrent = firstRightNode.sumOfPower();
			int sumOfInstertingNode = p.sumOfPower();
			
			// CASE1: First Node
			// Check with the first node. If lower, insert at first place
			if (current.isSamePowers(p)) { // CHECK IF EQUAL POWERS
				current.setCoeff(p.getCoeff() + current.getCoeff());
				System.out.println("Found similar polynomials, adding the coeff");
				return;
			}
			if (sumOfInstertingNode < sumOfCurrent) { // CHECK IF POWERS LOWER
				p.nextNode = firstRightNode;
				lastRightNode.nextNode = p;
				firstRightNode = p;
				System.out.printf("%s: Inserted %s to the first slot in the list%n", polynomial, p.toString());
			}
			
			// CASE2: The rests
			else {
				current = firstRightNode.nextNode;
				sumOfCurrent = current.sumOfPower();
				/*
				 *  Loop through the list of the nodes. If we come to a node where sumOfInsert is larger than sumOfCurrent, we stop
				 *  Add the inserting node to that position. (making the list ascending)
				 *  If we came across the node that has a similar powers, we then just add to that node and finish the method.
				 */
				while ((current != firstRightNode) && (sumOfInstertingNode >= sumOfCurrent)) {
					if (current.isSamePowers(p)) {
						current.setCoeff(p.getCoeff() + current.getCoeff());
						System.out.println("Found similar polynomials, adding the coeff");
						return;
					}
					else {
						previous = current;
						current = current.nextNode;
						sumOfCurrent = current.sumOfPower();
					}
				}
				previous.nextNode = p;
				p.nextNode = current;
				//CASE3: The last node
				if (current == firstRightNode){
					lastRightNode = p;
					System.out.printf("%s: Inserted %s to the last slot in the list%n", polynomial, p.toString());
				}
				else 
					System.out.printf("%s: Inserted %s between %s and %s%n", polynomial, p.toString(), previous.toString(), current.toString());
			}
			
		}
	}
	
	public void printNodes() {
		PolyNode currentNode = firstRightNode;
		System.out.printf("Printing all nodes within %s%n", getPolyName());
		do {
			System.out.println(currentNode.toString());
			currentNode = currentNode.nextNode;
		} while(currentNode != firstRightNode);
	}
	
	/*
	 * Get the nice form of a polynomial. Eg: 6*x^8*y^3*z^9 + ...
	 */
	public String getPolynomial() {
		PolyNode currentNode = firstRightNode;
		String output = "";
		do {
			int coeff = currentNode.getCoeff(); 
			if (coeff == 0);
			else {
				if (output != "") { // If we are inserting the first polynomial, we do not need to include + or - upfront
					if (coeff < 0) output += (" - ");
					else if (coeff > 0) output += (" + ");
				}
				int x = currentNode.getXPower();
				int y = currentNode.getYPower();
				int z = currentNode.getZPower();
				output += Math.abs(coeff);
				if (x != 0) output += "x^" + x;
				if (y != 0) output += "y^" + y; 
				if (z != 0) output += "z^" + z;		
			}
			currentNode = currentNode.nextNode;
		} while(currentNode != firstRightNode);
		return output;
	}
	
	@Override
	public String getPolyName() {
		return name;
	}

	@Override
	public void setPolyName(String s) {
		name = s;
	}

	@Override
	public PolyNameNode getDownPtr() {
		return downNode;
	}

	@Override
	public void setDownPtr(PolyNameNode p) {
		downNode = p;
	}

	@Override
	public PolyNode getRightPtr() {
		return firstRightNode;
	}

	@Override
	public void setRightPtr(PolyNode p) {
		firstRightNode = p;
	}
	
	public PolyNode getLastRightPtr() {
		return lastRightNode;
	}
	
	public void setLastRightPtr(PolyNode p) {
		lastRightNode = p;
	}

	public String getRawPolynomial() {
		return polynomial;
	}
}
