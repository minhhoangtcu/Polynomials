package poly.arithmatic;

import poly.datastructure.PolyNameIterator;
import poly.datastructure.PolyNameNode;
import poly.datastructure.PolyNode;

public class Multiply {
	
	public static PolyNameNode multiply(PolyNameNode first, PolyNameNode second) {
		PolyNameIterator fIter = new PolyNameIterator(first);
		PolyNameIterator sIter = new PolyNameIterator(second);
		PolyNameNode newNameNode = new PolyNameNode(String.format("%sMultiply%s", first.getPolyName(), second.getPolyName()), "");
		
		PolyNode fNode = fIter.getCurrent();
		PolyNode sNode = fIter.getCurrent();
		do {
			do {
				
				int newCoeff = fNode.getCoeff() * sNode.getCoeff();
				int newX = fNode.getXPower() * sNode.getXPower();
				int newY = fNode.getYPower() * sNode.getYPower();
				int newZ = fNode.getZPower() * sNode.getZPower();
				PolyNode newNode = new PolyNode(newCoeff, newX, newY, newZ);
				newNameNode.addNode(newNode);
				
				sNode = sIter.next();
			} while (!sIter.isFirst(sNode));
			fNode = fIter.next();
		} while (!fIter.isFirst(fNode));
		return newNameNode;
	}
}
