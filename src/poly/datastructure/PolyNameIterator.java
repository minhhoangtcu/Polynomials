package poly.datastructure;

public class PolyNameIterator implements PolyNameIteratorInterface {

	PolyNameNode list;
	PolyNode current;
	PolyNode previous;
	
	public PolyNameIterator(PolyNameNode node) {
		this.list = node;
	}

	@Override
	public boolean isFirst(PolyNode node) {
		PolyNode first = list.getRightPtr();
		return (node == first);
	}

	@Override
	public PolyNode next() {
		current = current.nextNode;
		return current;
	}

	@Override
	public PolyNode getPrevious() {
		return previous;
	}

}
