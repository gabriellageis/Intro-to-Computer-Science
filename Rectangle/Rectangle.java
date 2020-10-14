
public class Rectangle {
	
	// instance variables
	protected int length;
	protected int width;
	
	// constructor
	Rectangle(int len, int wid) {
		this.length = len;
		this.width = wid;
	}
	
	// getArea method
	public long getArea() {
		return this.length * this.width;
	}
	
	// draw method
	public void draw() {
		for (int i = 0; i < this.length; i ++) {
			System.out.print("*" + " ");
		}
		System.out.println();
		for (int i = 0; i < (this.width - 2); i++) {
			for (int j = 0; j < this.length; j ++) {
				if (j == 0 || j == this.length - 1) 
					System.out.print("*" + " ");
				else 
					System.out.print(" " + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < this.length; i ++) {
			System.out.print("*" + " ");
		}
		System.out.println();
	}
}
