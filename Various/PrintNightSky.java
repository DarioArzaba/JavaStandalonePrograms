public class PrintNightSky {
	public static void main(String[] args) {
		NightSky newsky = new NightSky(0.5,20,10);
		newsky.print();
		System.out.println(newsky.starsInLastPrint());
	}
}