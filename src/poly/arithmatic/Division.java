package poly.arithmatic;

import poly.datastructure.PolyNameIterator;
import poly.datastructure.PolyNameNode;
import poly.datastructure.PolyNode;

public class Division {
	
	public static PolyNameNode devideBy(PolyNameNode first, PolyNameNode second) {
		PolyNameIterator fIter = new PolyNameIterator(first);
		PolyNameIterator sIter = new PolyNameIterator(second);
		PolyNameNode newNameNode = new PolyNameNode(String.format("%sDevideBy%s", first.getPolyName(), second.getPolyName()), "");
		
		PolyNode fNode = fIter.getCurrent(); //Biggest one of the first list
		PolyNode sNode = sIter.getCurrent(); //Biggest one of the second list
		
		PolyNode q = devideNodeBy(fNode, sNode);
		PolyNameNode tempNameNode = new PolyNameNode("temp", q.toString());
		PolyNameNode substract = Multiply.multiply(second, tempNameNode);
		PolyNameNode substracted = Subtraction.sub(first, substract);
		return substracted;
	}
	
	public static PolyNode devideNodeBy(PolyNode first, PolyNode second) {
		PolyNode q = new PolyNode(first.getCoeff() / second.getCoeff(),
								  first.getXPower() - second.getXPower(),
								  first.getYPower() - second.getYPower(),
								  first.getZPower() - second.getZPower());
		return q;
	}
}
