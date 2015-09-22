package poly.datastructure;

public class PolyNode implements PolyNodeInterface {
	
	private int coeff, xPower, yPower, zPower;
	
	public void PolyNode(int coeff, int xPower, int yPower, int zPower) {
		this.coeff = coeff;
		this.xPower = xPower;
		this.yPower = yPower;
		this.zPower = zPower;
	}

	@Override
	public int getCoeff() {
		return coeff;
	}

	@Override
	public void setCoeff(int c) {
		coeff = c;
	}

	@Override
	public int getXPower() {
		return xPower;
	}

	@Override
	public void setXPower(int ix) {
		xPower = ix;
		
	}

	@Override
	public int getYPower() {
		return yPower;
	}

	@Override
	public void setYPower(int iy) {
		yPower = iy;
	}

	@Override
	public int getZPower() {
		return zPower;
	}

	@Override
	public void setZPower(int iz) {
		zPower = iz;
	}

	@Override
	public PolyNode getPtr() {
		return this;
	}

	@Override
	public void setPtr(PolyNode p) {
		coeff = p.coeff;
		xPower = p.xPower;
		yPower = p.yPower;
		zPower = p.zPower;
	}

}
