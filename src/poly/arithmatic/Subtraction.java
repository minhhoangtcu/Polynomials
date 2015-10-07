package poly.arithmatic;

import poly.datastructure.PolyList;
import poly.datastructure.PolyNameIterator;
import poly.datastructure.PolyNameNode;
import poly.datastructure.PolyNode;

public class Subtraction {
	
	/*
	 * Substracting the first PolyNameNode by the second Node.
	 */
	public static PolyNameNode sub(PolyNameNode first, PolyNameNode second) {
		PolyNameNode negSecond = neg(second);
		if (first.isEmpty() && second.isEmpty()) return null;
		else if (first.isEmpty()) return negSecond;
		else if (second.isEmpty()) return first;
		else {
			PolyNameNode merged = mergePolyNegative(first, negSecond);
			return merged;
		}
	}
	
	/*
	 * Merge two PolyName nodes together without considering anything
	 */
	private static PolyNameNode mergePolyNegative(PolyNameNode p1, PolyNameNode p2) {
		String newPoly = p1.getRawPolynomial() + " - " + p2.getRawPolynomial();
		String newName = p1.getPolyName() + "-" + p2.getPolyName();
		PolyList list = new PolyList(); // For the sake of using a method within the poly list
		PolyNameNode newNameNode = list.createNameNode(newName, newPoly);
		return newNameNode;
	} 

	/*
	 * Negative a PolyNameNode.
	 */
	public static PolyNameNode neg(PolyNameNode node) {
		PolyNameIterator iter = new PolyNameIterator(node);
		PolyNode current = iter.next();
		PolyNameNode newNameNode = new PolyNameNode("neg" + node.getPolyName(), "");
		do {
			PolyNode newNode = new PolyNode(-current.getCoeff(), current.getXPower(), current.getYPower(), current.getZPower());
			newNameNode.addNode(newNode);
			current = iter.next();
		} while (iter.isFirst(current));
		newNameNode.refreshRawForm();
		return newNameNode;
	}
}
