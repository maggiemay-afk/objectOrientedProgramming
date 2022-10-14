package a3disc;

public abstract class AbstractItem {
	private int x;
	
	public int getx() {
		return x;
	}
	
	public void setx( int xin ) {
		if (xin > 0)
			x = xin;
	}
	
	@Override
	/**
	 * check equality of 2 objects
	 */
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (other instanceof AbstractItem) { // this is good enough for the discussion but could be better
			AbstractItem o = (AbstractItem) other;
			return x == o.x;
		}
		return false;
	}
	
	// Usually, when we override .equals(), we really should override .hashCode() 
	// and .compareTo() as well if this class implements Comparable<>
	// But since we are not using those methods in our program, we are skipping overriding them
	
	@Override
	public String toString() {
		return "[" + x + "]";
	}
}
