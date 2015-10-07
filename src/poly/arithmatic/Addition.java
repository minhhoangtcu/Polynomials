package poly.arithmatic;

import poly.datastructure.PolyList;
import poly.datastructure.PolyNameNode;

public class Addition {
	
	/*
	 * Adding two nodes together and produce a new node.
	 * If one of the node is empty, return the other one as a resulting node.
	 */
	public static PolyNameNode add(PolyNameNode first, PolyNameNode second) {
		if (first.isEmpty() && second.isEmpty()) return null;
		else if (first.isEmpty()) return second;
		else if (second.isEmpty()) return first;
		else {
			PolyNameNode merged = mergePoly(first, second);
			return merged;
		}
	}

	/*
	 * Merge two PolyName nodes together without considering anything
	 */
	private static PolyNameNode mergePoly(PolyNameNode p1, PolyNameNode p2) {
		String newPoly = p1.getRawPolynomial() + " + " + p2.getRawPolynomial();
		String newName = p1.getPolyName() + "+" + p2.getPolyName();
		PolyList list = new PolyList(); // For the sake of using a method within the poly list
		PolyNameNode newNameNode = list.createNameNode(newName, newPoly);
		return newNameNode;
	}
	
	
}
