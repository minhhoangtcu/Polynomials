// PolyNode interface (** should be included as a part of your Lab1 project)
// ******************PUBLIC OPERATIONS******************************************
// public int getCoeff();
// --> returns the coeff of a specified polynomial term
//
// public void setCoeff(int c);
// --> sets the coeff of the specified polynomial’s term to c
//
// public int getXPower();
// --> returns the specified polynomial’s x power
//
// public void setXPower(int ix);
// --> sets the specified polynomial’s x power to ix
//
// public int getYPower();
// --> returns the specified polynomial’s y power
//
// public void setYPower(int iy);
// --> sets the specified polynomial’s y power to iy
//
// public int getZPower();
// --> returns the specified polynomial’s z power
//
// public void setZPower(int iz);
// --> sets the specified polynomial’s z power to iz
//
// public PolyNode getPtr();
// --> returns the value of the specified polynomial’s link field
//
// public void setPtr(PolyNode p);
// --> sets the specified polynomial’s link field to p
//
// ****************************************************************************
/**
* Protocol for PolyNodeInterface
* @author James Comer
*/
public interface PolyNodeInterface {
	//Method signatures
	public int getCoeff();
	public void setCoeff(int c);
	public int getXPower();
	public void setXPower(int ix);
	public int getYPower();
	public void setYPower(int iy);
	public int getZPower();
	public void setZPower(int iz);
	public PolyNode getPtr();
	public void setPtr(PolyNode p);
}