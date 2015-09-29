package poly.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyNodeTest extends PolyList {

	PolyList list;
	
	@Test
	public void testPoly() {
		assertTrue("6*x^4*y^5*z^3".equals(getPolyNode("6*x^4*y^5*z^3").toString()));
		assertTrue("9*x^3*y^8*z^1".equals(getPolyNode("9*x^3*y^8*z^1").toString()));
		assertTrue("10*x^2*y^126*z^1234123".equals(getPolyNode("10*x^2*y^126*z^1234123").toString()));
		assertTrue("12341*x^4*y^1235*z^1234".equals(getPolyNode("12341*x^4*y^1235*z^1234").toString()));
		assertTrue("0*x^0*y^0*z^0".equals(getPolyNode("0*x^0*y^0*z^0").toString()));
	}
	
	@Test
	public void testValidity() {
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
	}

}
