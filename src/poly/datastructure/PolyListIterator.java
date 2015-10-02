package poly.datastructure;

public class PolyListIterator {
	
	private PolyList list;
	
	public PolyListIterator(PolyList list) {
		this.list = list;
	}
	
	public String getPoly(int i) throws IndexOutOfBoundsException {
			return new PolyNameIterator(getNameNode(i)).getPolynomial();
	}
	
	public String getName(int i) throws IndexOutOfBoundsException {
		return getNameNode(i).getPolyName();
	}

	public void setName(int i, String s) {
		getNameNode(i).setPolyName(s);
	}
	
	public PolyNameNode getNameNode(int i)  throws IndexOutOfBoundsException{
		if (i >= list.size()) throw new IndexOutOfBoundsException();
		else {
			PolyNameNode current = list.getFirstNode();
			for (int j = 0; j < i; j++)
				current = current.getDownPtr();
			return current;
		}
	}
}
