
public class TestRectangle {

	public static void main(String[] args) {
		
		int l = 15;
		int w = 10;
		
		Rectangle rect = new Rectangle(l, w);
		long area = rect.getArea();
		System.out.println("The area of this rectangle is: " + area);
		rect.draw();

	}

}
