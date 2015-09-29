package poly.datastructure;

/*
 * A node containing raw String file of the polynomial and the name.
 * This also act as a circular list (containing the first and last nodes references)
 */
public class PolyNameNode implements PolyNameNodeInterface {

	String name;
	String polynomial;
	PolyNameNode downNode;
	PolyNode firstRightNode;
	PolyNode lastRightNode;
	
	public PolyNameNode(String name, String polynomial) {
		this.name = name;
		this.polynomial = polynomial;
		downNode = null;
		firstRightNode = null;
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
			int sumOfCurrent = firstRightNode.getXPower() + firstRightNode.getYPower() + firstRightNode.getZPower();
			int sumOfInstertingNode = p.getXPower() + p.getYPower() + p.getZPower();
			
			// Check with the first node. If lower, insert at first place
			if (sumOfInstertingNode < sumOfCurrent) {
				p.nextNode = firstRightNode;
				lastRightNode.nextNode = p;
				firstRightNode = p;
			}
			else {
				current = firstRightNode.nextNode;
				while ((current != firstRightNode) && (sumOfInstertingNode > sumOfCurrent)) {
					previous = current;
					current = current.nextNode;
				}
				previous.nextNode = p;
				p.nextNode = current;
				if (current == firstRightNode) lastRightNode = p;
			}
			System.out.printf("Inserted %s between %s and %s%n", p.toString(), previous.toString(), current.toString());
		}
	}
}
