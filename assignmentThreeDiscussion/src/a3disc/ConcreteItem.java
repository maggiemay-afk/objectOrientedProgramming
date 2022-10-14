package a3disc;

public class ConcreteItem extends AbstractItem {
	private int y;
	
	public ConcreteItem(int xin, int yin) {
		setx( xin );
		this.y = yin;
	}

	public ConcreteItem(ConcreteItem orig) {
		setx( orig.getx() );
		this.y = orig.y;
	}
	
	public boolean equals (Object other) {
		if (super.equals(other)) {
			ConcreteItem other2 = (ConcreteItem) other;
			
			if (this.y == other2.y) {
				return true;
			}
			
			return false;
		}
		
		return false;
	}

	public String toString() {
		return "[ " + super.toString() + ", " + y + " ]";
	}
}
