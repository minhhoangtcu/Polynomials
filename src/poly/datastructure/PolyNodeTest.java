package poly.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyNodeTest extends PolyList {

	PolyList list;
	
	@Test
	public void test() {
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
