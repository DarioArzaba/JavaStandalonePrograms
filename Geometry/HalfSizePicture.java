

public class HalfSizePicture {
	
	public static void main(String[] args) {
		
		Picture pic = new Picture();
		pic.load("queen-mary.png");
		pic.scale((pic.getWidth()/2), (pic.getHeight()/2));
		pic.move((pic.getWidth()/4), (pic.getHeight()/4));

	}
}