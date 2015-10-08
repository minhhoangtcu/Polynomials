package poly.datastructure;

public class PolyNameIterator implements PolyNameIteratorInterface {

	private PolyNameNode list;
	private PolyNode current, previous;
	
	public PolyNameIterator(PolyNameNode node) {
		this.list = node;
		current = list.getRightPtr();
		previous = list.getLastRightPtr();
	}

	@Override
	public boolean isFirst(PolyNode node) {
		PolyNode first = list.getRightPtr();
		return (node == first);
	}

	@Override
	public PolyNode next() {
		previous = current;
		current = current.nextNode;
		return current;
	}

	@Override
	public PolyNode getPrevious() {
		return previous;
	}

	@Override
	public PolyNode getCurrent() {
		return current;
	}
}
