package a2disc;

public class Catalog2 {
	private Item[] items;
	
	public Catalog2() {
		items = new Item[ 10 ];
		
	}
	
	public Item[] getAllItems() {
		return items;
	}
	
	public void add( Item[] i ) {
		for (int index = 0; index < i.length; index++) {
			items[index] = new Item(i[index].getData());
		}
	}
	
	public String toString() {
		String result = "[ ";
		for (Item i : items)
			if(i != null) {
				result += i + " ";
			}
		return  result + " ]";
	}
}
