package classe;

public class Case {
	int x , y ;

	
	public Case() {
		 this.x = 0 ;
		 this.y = 0 ; 
	}
	
	public Case(int x, int y) {
		this.x = x; 
		this.y = y; 
	}

	
	//get et set 
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Case{" +
				"x=" + (x + 1) +
				", y=" + (y + 1) +
				'}';
	}
}
