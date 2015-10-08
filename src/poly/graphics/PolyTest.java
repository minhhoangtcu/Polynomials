package poly.graphics;
import static org.junit.Assert.*;
import org.junit.Test;

public class PolyTest {

	@Test
	public void testValue() {
		MainMenu program = new MainMenu();
		program.model.add("a", "6*x^4*y^5*z^3");
		program.model.add("b", "6*x^4*y^5*z^3 + 10*x^0*y^1*z^3");
		program.model.add("c", "6*x^4*y^5*z^3");
		program.model.add("d", "2*x^4*y^5*z^3 + 6*x^2*y^2*z^2");
		program.model.add("e", "6*x^4*y^5*z^3 + 6*x^2*y^2*z^2 + 6*x^2*y^2*z^2");
		program.model.add("f", "6*x^4*y^5*z^3 + 0*x^0*y^1*z^3");
		program.model.add("g", "6*x^4*y^5*z^3 + 6*x^2*y^2*z^2 + 6*x^2*y^2*z^2");
		program.model.add("h", "6*x^10*y^3*z^0 + 6*x^2*y^3*z^4 + 1*x^3*y^0*z^8 + 0*x^3*y^0*z^8 + 1*x^0*y^0*z^8");
		program.model.add("z", "-6*x^4*y^5*z^3 + -6*x^2*y^2*z^2 + -6*x^2*y^2*z^2");
		program.model.add("y", "0*x^0*y^0*z^0 + 6*x^6*y^6*z^6 + 9*x^9*y^9*z^9 + 7*x^7*y^7*z^7 + 5*x^5*y^5*z^5 + 2*x^2*y^2*z^2 + 1*x^1*y^1*z^1");
		program.model.add("i", "-6*x^10*y^3*z^0 + -6*x^2*y^3*z^4 + 1*x^3*y^0*z^8 + 0*x^3*y^0*z^8 + 1*x^0*y^0*z^8");
		program.model.add("k", "-6*x^10*y^3*z^0 + -6*x^2*y^3*z^4 + 1*x^3*y^0*z^8 + 0*x^3*y^0*z^8 + -1*x^10*y^3*z^0");
		program.model.printList();
		program.view.repaintEverything();
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
		
		program.view.repaintEverything();
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
