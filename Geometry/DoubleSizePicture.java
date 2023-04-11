public class DoubleSizePicture {
	
	public static void main(String[] args) {
	
		  Picture pic = new Picture();
		  pic.load("queen-mary.png");
		  pic.move(-pic.getWidth()/4,-pic.getHeight()/4);
		  pic.scale((pic.getWidth()*2), (pic.getHeight()*2));
		  
	}
}