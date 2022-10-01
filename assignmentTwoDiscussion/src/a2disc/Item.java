package a2disc;

public class Item {
	String data;
	
	public Item( String d) {
		this.setData(d);
	}
	
	public void setData (String d) {
		this.data = d;
	}
	
	public String getData () {
		return this.data;
	}
	
	public String toString() {
		return "[" + data + "]";
	}
}
