// PolyNameNode interface (** should be included as a part of your Lab1 project)
// ******************PUBLIC OPERATIONS******************************************
// public String getPolyName();
// --> returns the name of the polynomial being pointed to
//
// public void setPolyName(String s);
// --> sets the name of this polynomial to s
//
// public PolyNameNode getDownPtr();
// --> returns the value of the “down ptr” for the specified PolyListNode
//
// public void setDownPtr(PolyNameNode p);
// --> sets the “down ptr” of the specified node to p
//
// public PolyNode getRightPtr();
// --> returns the value of the “right ptr” for the specified PolyNameNode
//
// public void setRightPtr(PolyNode p);
// --> sets the “right ptr” of the specified node to p
//
// ****************************************************************************
/**
* Protocol for PolyNameNodeInterface
* @author James Comer
*/

package poly.datastructure;

public interface PolyNameNodeInterface {
	//Method signatures
	public String getPolyName();
	public void setPolyName(String s);
	public PolyNameNode getDownPtr();
	public void setDownPtr(PolyNameNode p);
	public PolyNode getRightPtr();
	public void setRightPtr(PolyNode p);
}