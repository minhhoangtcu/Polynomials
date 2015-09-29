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
		if (firstRightNode == null)
			firstRightNode = p;
		else
			lastRightNode.nextNode = p;
		lastRightNode = p;
		p.nextNode = firstRightNode;
	}
}
