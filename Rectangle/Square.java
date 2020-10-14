
public class Square extends Rectangle{
	
	// constructor
	Square(int len, int wid) {
		super(len, wid);
	}
	
	// isSquare method
	public static boolean isSquare(int len, int wid) {
		if (len == wid) 
			return true;
		return false;
	}

}
