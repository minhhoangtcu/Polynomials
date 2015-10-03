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
	
	/*
	 * Add new node to the list.
	 */
	public void addNode(PolyNode p) {
		if (firstRightNode == null) {
			firstRightNode = p;
			lastRightNode = p;
			p.nextNode = firstRightNode;
			System.out.printf("Added first node(%s) into the list%n", p.toString());
		}
		else {
			PolyNode current = firstRightNode;
			PolyNode previous = lastRightNode;
			int sumOfCurrent = sumOfPower(firstRightNode);
			int sumOfInstertingNode = sumOfPower(p);
			
			// Check with the first node. If lower, insert at first place
			if (sumOfInstertingNode < sumOfCurrent) {
				p.nextNode = firstRightNode;
				lastRightNode.nextNode = p;
				firstRightNode = p;
				System.out.printf("Inserted %s to the first slot in the list%n", p.toString());
			}
			else {
				current = firstRightNode.nextNode;
				sumOfCurrent = sumOfPower(current);
				while ((current != firstRightNode) && (sumOfInstertingNode > sumOfCurrent)) {
					previous = current;
					current = current.nextNode;
					sumOfCurrent = sumOfPower(current);
				}
				previous.nextNode = p;
				p.nextNode = current;
				if (current == firstRightNode){
					lastRightNode = p;
					System.out.printf("Inserted %s to the last slot in the list%n", p.toString());
				}
				else 
					System.out.printf("Inserted %s between %s and %s%n", p.toString(), previous.toString(), current.toString());
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
	
	private int sumOfPower(PolyNode p) {
		return p.getXPower() + p.getYPower() + p.getZPower();
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
}
