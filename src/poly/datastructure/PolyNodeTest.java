package poly.datastructure;
import static org.junit.Assert.*;
import org.junit.Test;
import poly.graphics.MainMenu;

public class PolyNodeTest extends PolyList {

	PolyList list;
	
	
	@Test
	public void testSolving() {
		MainMenu program = new MainMenu();
		program.model.add("a", "6*x^4*y^5*z^3");
		assertEquals(6, program.model.solve(0, 1, 1, 1));
		assertEquals(21233664, program.model.solve(0, 2, 4, 6));
		
		program.model.add("b", "6*x^4*y^5*z^3 + 10*x^0*y^1*z^3");
		assertEquals(16, program.model.solve(1, 1, 1, 1));
		assertEquals(24736, program.model.solve(1, 2, 2, 2));
		
		program.model.remove(0);
		program.model.add("a", "6*x^4*y^5*z^3 + 6*x^4*y^5*z^3");
		assertEquals(12, program.model.solve(1, 1, 1, 1));
		
		program.view.updateTable();
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testTable() {
		MainMenu program = new MainMenu();
		program.model.add("a", "6*x^4*y^5*z^3");
		program.model.add("b", "6*x^4*y^5*z^3 + 6*x^2*y^5*z^3");
		program.model.add("c", "6*x^1*y^1*z^1 - 6*x^2*y^2*z^2 + 6*x^0*y^0*z^0");
		program.model.add("d", "6*x^1*y^1*z^1 - 6*x^2*y^2*z^2 + 6*x^0*y^0*z^0 + 6*x^5*y^5*z^5 + 6*x^4*y^4*z^4 + 6*x^3*y^3*z^3");
		program.model.remove(0);
		program.view.updateTable();
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testAddPoly() {
		list = new PolyList();
		list.addNode("a", "6*x^4*y^5*z^3");
		list.addNode("b", "6*x^4*y^5*z^3 + 6*x^2*y^5*z^3");
		list.addNode("c", "6*x^1*y^1*z^1 - 6*x^2*y^2*z^2 + 6*x^0*y^0*z^0");
		list.addNode("d", "6*x^1*y^1*z^1 - 6*x^2*y^2*z^2 + 6*x^0*y^0*z^0 + 6*x^5*y^5*z^5 + 6*x^4*y^4*z^4 + 6*x^3*y^3*z^3");
		PolyNameNode firstNode = list.getFirstNode();
		firstNode.printNodes();
		System.out.println(firstNode.getPolynomial());
	}
	
	public void testGetPolyNode() {
		assertTrue("6*x^4*y^5*z^3".equals(createPolyNode("6*x^4*y^5*z^3").toString()));
		assertTrue("9*x^3*y^8*z^1".equals(createPolyNode("9*x^3*y^8*z^1").toString()));
		assertTrue("10*x^2*y^126*z^1234123".equals(createPolyNode("10*x^2*y^126*z^1234123").toString()));
		assertTrue("12341*x^4*y^1235*z^1234".equals(createPolyNode("12341*x^4*y^1235*z^1234").toString()));
		assertTrue("0*x^0*y^0*z^0".equals(createPolyNode("0*x^0*y^0*z^0").toString()));
	}
	
	public void testValidity() {
		assertTrue(isValid("6*x^4*y^5*z^3"));
		assertTrue(isValid("6*x^4*y^5*z^3 + 6*x^4*y^5*z^3"));
		assertTrue(isValid("6*x^4*y^5*z^3 + 6*x^4*y^5*z^3 - 6*x^4*y^5*z^3"));
		assertTrue(isValid("6*x^4*y^5*z^3+6*x^4*y^5*z^3-6*x^4*y^5*z^3"));
		assertFalse(isValid("6*x^4*y^5*z^3 + 6*x^4*y^5*z^3 + 6*z^4*y^5*z^3"));
		assertTrue(isValid("6*x^4*y^5*z^3"));
		assertTrue(isValid("6*x^4*y^5*z^3"));
		assertFalse(isValid("s*x^4*y^5*z^3"));
		assertFalse(isValid("6*z^4*y^5*z^3"));
		assertFalse(isValid("123123145*x^x*y^5*z^3"));
		assertFalse(isValid("1231*x^4*12345^5*z^3"));
		assertFalse(isValid("123*x^4*y^ydsa*z^3"));
		assertTrue(isValid("1234*x^25*y^123123*z^17347347"));
		assertFalse(isValid("asdfasdfqwer"));
		assertFalse(isValid("****"));
		assertFalse(isValid("***"));
		assertFalse(isValid("6*x^4*y^5"));
		assertFalse(isValid("6*x^4*y^5*z3"));
		assertTrue("^^^^".matches("\\^*"));
		assertTrue("11^^^11".matches(".*\\^*.*"));
		assertTrue("6*x^4*y^5*z^^^3".matches(".*\\^{2,}.*"));
		assertFalse(isValid("6*x^4*y^5*z^^^3"));
		assertFalse(isValid("6*x^4*y^5*z^^^3"));
		assertFalse(isValid("6***x^4****y^5*z^^^3"));
		assertFalse(isValid("6***x^4****y^5*z^3"));
	}

}
