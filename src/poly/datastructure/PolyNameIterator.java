package poly.datastructure;

public class PolyNameIterator {
	
	private PolyNameNode list;
	private PolyNode firstRightNode, lastRightNode;
	
	public PolyNameIterator(PolyNameNode list) {
		this.list = list;
		firstRightNode = list.getRightPtr();
		lastRightNode = list.getLastRightPtr();
	}
	
	public void printNodes() {
		PolyNode currentNode = firstRightNode;
		System.out.printf("Printing all nodes within %s%n", list.getPolyName());
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
	
	public void remove() {
		
	}
	

}
