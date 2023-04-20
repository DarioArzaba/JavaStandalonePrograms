public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint = 0;
    
    public NightSky(double density, int width, int height){
    	this.density = density;
        this.width = width;
        this.height = height;
    }
	
    public void printLine(){
        Random random = new Random();
        String line = "";
        String symbol = "";
        for(int i = 0; i < this.width; i ++){
            double probability = random.nextDouble();
            if(probability > this.density){
                symbol = " ";
            }else{
                symbol = "*";
                this.starsInLastPrint += 1;
            }
            line += symbol;
        }
        System.out.println(line);
    }
    public void print(){
        this.starsInLastPrint = 0;
        for(int i = 0; i < this.height; i++){
            this.printLine();
        }
    }
    public int starsInLastPrint(){
        return this.starsInLastPrint;
    }
}