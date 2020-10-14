
public class TestSquare {

	public static void main(String[] args) {
		
		int l = 10;
		int w = 10;
		
		Square mySquare = new Square(l, w);
		
		long area = mySquare.getArea();
		System.out.println("The area of this square is: " +  area);
		
		boolean isItSquare = Square.isSquare(l, w);
		System.out.println("This is a square: " + isItSquare);
		
		mySquare.draw();

	}

}
