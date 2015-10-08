package poly.arithmatic;

import poly.datastructure.PolyNameNode;

public class PolyMath {
	
	public static PolyNameNode add(PolyNameNode first, PolyNameNode second) {
		return Addition.add(first, second);
	}
	
	public static PolyNameNode subtract(PolyNameNode first, PolyNameNode second) {
		return Subtraction.sub(first, second);
	}
	
	public static PolyNameNode multiply(PolyNameNode first, PolyNameNode second) {
		return Multiply.multiply(first, second);
	}

}
