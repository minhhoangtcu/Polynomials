package poly.datastructure;

public class PolyNameNode implements PolyNameNodeInterface {

	String name;
	String polynomial;
	PolyNameNode downNode;
	PolyNode rightNode;
	
	public PolyNameNode(String name, String polynomial) {
		this.name = name;
		this.polynomial = polynomial;
		downNode = null;
		rightNode = null;
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
		return rightNode;
	}

	@Override
	public void setRightPtr(PolyNode p) {
		rightNode = p;
	}
}
