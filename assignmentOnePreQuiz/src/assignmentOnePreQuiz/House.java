package assignmentOnePreQuiz;

class House {
	private int floors = 0;
	private float squareFeet = 0;
	
	public House (float sq) {
		squareFeet = sq;
	}
	
	public House (int f) {
		setFloors(f);
		setSqFt(1000.0f);
	}
	
	public House (int f, float sq) {
		floors = f;
		squareFeet = sq;
	}
	
	public House (House in) {
		floors = in.floors;
		squareFeet = in.squareFeet;
	}
	
	public void setFloors (int f) {
		floors = f;
	}
	
	public void setSqFt (float sq) {
		squareFeet = sq;
	}
	
	public String toString () {
		return "House has " + floors + " floors and " + squareFeet + " square feet";
	}

	public static void main (String[] args) {
		
		House house1, house2;
		
		house1 = new House(2, 1000.0f);
		house2 = new House(2500.0f);
		House house3 = new House(house2);
		
		house1.setSqFt(1500.0f);
		
		
		if (house3 == house2) {
			System.out.println("same");
		} else {
			System.out.println("different");
		}
		
	}

}
