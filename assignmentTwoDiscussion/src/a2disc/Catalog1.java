package a2disc;

public class Catalog1 {
	private Item[] items;
	
	public Catalog1() {
		items = new Item[ 10 ];
	}
	
	public Item getItem(int i) throws ArrayIndexOutOfBoundsException {
			
		return items[ i ];
	
	}
	
	public void add( Item i, int pos) {
		items [pos] = new Item(i.getData());
	}
	
	public String toString() {
		String result = "[ ";
		for (Item i : items)
			if (i != null) {
				result += i + " ";
			}
		return  result + " ]";
	}
}
