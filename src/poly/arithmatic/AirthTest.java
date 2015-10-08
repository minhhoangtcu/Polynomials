package poly.arithmatic;

import org.junit.Test;
import poly.datastructure.PolyList;
import poly.datastructure.PolyNameNode;

public class AirthTest {

	@Test
	public void testSub1() {
		PolyList list = new PolyList();
		PolyNameNode node1 = list.createNameNode("a", "6*x^4*y^5*z^3");
		PolyNameNode node2 = list.createNameNode("b", "6*x^4*y^5*z^3");
		PolyNameNode result = PolyMath.subtract(node1, node2);
		System.out.println(result.getPolynomial());
	}
	
	@Test
	public void testSub2() {
		PolyList list = new PolyList();
		PolyNameNode node1 = list.createNameNode("a", "0*x^0*y^0*z^0");
		PolyNameNode node2 = list.createNameNode("b", "6*x^4*y^5*z^3");
		PolyNameNode result = PolyMath.subtract(node1, node2);
		System.out.println(result.getPolynomial());
	}

	@Test
	public void testSub3() {
		PolyList list = new PolyList();
		PolyNameNode node1 = list.createNameNode("a", "6*x^4*y^5*z^3 + 6*x^4*y^5*z^3 + 6*x^4*y^5*z^3");
		PolyNameNode node2 = list.createNameNode("b", "6*x^4*y^5*z^3");
		PolyNameNode result = PolyMath.subtract(node1, node2);
		System.out.println(result.getPolynomial());
	}
	
	@Test
	public void testSub4() {
		PolyList list = new PolyList();
		PolyNameNode node1 = list.createNameNode("a", "6*x^4*y^5*z^3 + 10*x^4*y^5*z^3 + 6*x^3*y^5*z^7");
		PolyNameNode node2 = list.createNameNode("b", "6*x^4*y^5*z^3 + 6*x^4*y^5*z^3");
		PolyNameNode result = PolyMath.subtract(node1, node2);
		System.out.println(result.getPolynomial());
	}
}
