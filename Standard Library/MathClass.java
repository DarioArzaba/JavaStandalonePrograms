
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathClass {

	public static void main(String[] args) {
		
		//Perform basic numeric operations.
		//Unlike StrictMath methods are NOT tested for bit per bit results.
		//However most methods simply call their equivalent in StrictMath
		//Accuracy for floating point math is measured in ULPS (units in the last place.)
		//Every method is Static
		
		System.out.println("\n --- FIELDS ---\n");
		
			double euler = Math.E;
			System.out.println("1.- Euler =                       " + round(euler) );
			double pi = Math.PI;
			System.out.println("2.- Pi =                          " + round(pi) );
		
		System.out.println("\n --- METHODS ---\n");
		
		//Trigonometric Sine of an Angle, argument in Radians
		System.out.println("1.-  Sin(90) =                        " + round(Math.sin(Math.toRadians(90.0))) );
		
		//Trigonometric Cosine of an Angle, argument in Radians
		System.out.println("2.-  Cos(90) =                        " + round(Math.cos(Math.toRadians(90.0))) );
		
		//Trigonometric Tangent of an Angle, argument in Radians
		System.out.println("3.-  Tan(45) =                        " + round(Math.tan(Math.toRadians(45.0))) );
		
		//Trigonometric ArcSine of an Angle, result in Radians
		System.out.println("4.-  ASin(0.5) =                      " + round(Math.toDegrees(Math.asin(0.5))) );
		
		//Trigonometric ArcCosine of an Angle, result in Radians
		System.out.println("5.-  ACos(0.5) =                      " + round(Math.toDegrees(Math.acos(0.5))) );
		
		//Trigonometric ArcTangent of an Angle, result in Radians
		System.out.println("6.-  ATan(1) =                        " + round(Math.toDegrees(Math.atan(1.0))) );
		
		//Trigonometric Hyperbolic Sine of an Angle
		System.out.println("7.-  Sinh(5) =                        " + round(Math.sinh(5.0)) );
		
		//Trigonometric Hyperbolic Cosine of an Angle
		System.out.println("8.-  Cosh(5) =                        " + round(Math.cosh(5.0)) );
		
		//Trigonometric Hyperbolic Tangent of an Angle
		System.out.println("9.-  Tanh(5) =                        " + round(Math.tanh(5.0)) );
		
		//Exponential Functions (e^n)
		System.out.println("10.- Exponential e^3.0 =              " + round(Math.exp(3.0)) );
		
		//Exponential Functions (e^n) minus 1
		System.out.println("11.- Exponential e^3.0 - 1 =          " + round(Math.expm1(3.0)) );
	 
		//Natual Logarithm (Base e) of a number.
		System.out.println("12.- Natual Logarithm (10) =          " + round(Math.log(10.0)) );
		
		//Natual Logarithm (Base e) of a plus 1 number
		System.out.println("13.- Natual Logarithm (10+1) =        " + round(Math.log1p(10.0)) );
		
		//Logarithm (Base 10) of a number.
		System.out.println("14.- Logarithm (100) =                " + round(Math.log10(100.0)) );
		
	    //Squared Positive Root of a number
		System.out.println("15.- Square Root (144) =              " + round(Math.sqrt(144.0)) );
		
		//Cube Positive Root of a number
		System.out.println("16.- Cube Root (144) =                " + round(Math.cbrt(144.0)) );
		
		//Sobrante IEEE-754 del primer argumento entre el segundo.
	    //IEEERemainder = [(f1)-((f2)(Math.Round(f1/f2)))]
	    System.out.println("17.- Sobrante IEEE (11.0 / 3.0) =     " + Math.IEEEremainder(11.0, 3.0));
	    
	    //Integer part left after using modulus
	    System.out.println("18.- Modulus (%) =                    " + (11.0 % 3.0));
	    
	    //Round up to next integer
		System.out.println("19.- Round up Integer (2.2) =         " + Math.ceil(2.2));
	    
	    //Round down to next integer
		System.out.println("20.- Round down Integer (2.6) =       " + Math.floor(2.6));
	    
	    //Round up from 0.5 and higher.
		System.out.println("21.- Round (2.499 - 2.5) =            " + Math.round(2.499) + " - " + Math.round(2.5));
	    
	    //Round down form 0.5 and lower.
		System.out.println("22.- Round (2.5 - 2.501) =            " + Math.rint(2.5) + " - " + Math.rint(2.501));
	    
	    //Generate Theta (radius, theta angle) from a polar coordinate (x, y)
		System.out.println("23.- Theta from polar (45 - 30) =     " + round(Math.toDegrees( Math.atan2(45.0, 30.0))) );
	 
		//Powers
		System.out.println("24.- Powers (2^3) =                   " + Math.pow(2.0, 3.0));
	    
	    //Random integer
		System.out.println("25.- Random Integer =                 " + round((Math.random())*100));
		
		//Integral number arithmetic
		System.out.println("26.- Add Integer =                    " + Math.addExact(50L, 100L));
		System.out.println("27.- Multiply Integer =               " + Math.multiplyExact(50L, 100L));
		System.out.println("28.- Increment Integer =              " + Math.incrementExact(100L));
		System.out.println("29.- Decrement Integer =              " + Math.decrementExact(100L));
		System.out.println("30.- Multiply Integer by (-1) =       " + Math.negateExact(100L));
		System.out.println("31.- From Long to Int =               " + Math.toIntExact(100L));
	 
		//FloorDiv does the division of two numbers and rounds down the result.
		System.out.println("32.- Floor Division (9 / 2) =         " + Math.floorDiv(9 , 2));
		
		//FloorDiv does the division of two numbers and rounds down the result.
		System.out.println("33.- Floor Modulus (-10 % 6) =        " + Math.floorMod(-10 , 6));
		
		//FloorDiv y FloorMod se usan para mantener un ciclo al realizar operaciones.
		//Por ejemplo supongamos un reloj que marca las 10:00 AM
		//Si se aumenta 3 horas sera la 1:00 PM, si se retrocede 14 horas seran las 8:00 PM
		System.out.println("10:00 AM + 3 h =                      " + Math.floorMod((10L + 3L), 12L));
		System.out.println("10:00 AM - 14 h =                     " + Math.floorMod((10L - 14L), 12L));
		
	    //Absolute Value
	    System.out.println("34.- Absolute Value (8.2 and -8.2) =  " + Math.abs(8.2) + " and " + Math.abs(-8.2));
	    
	    //Max number between two numbers
		System.out.println("35.- Max Number (3.58 - 6.52) =       " + Math.max(3.58, 6.52));
	    
	    //Min number between two numbers
		System.out.println("36.- Min Number (3.58 - 6.52) =       " + Math.min(3.58, 6.52));
		
		//ULP is the bit quantity needed for the floating number to go up one unit.
	    System.out.println("37.- ULP de 1.0 =                     " + Math.ulp(1.0));
	    
	    //Signum Generates (1) or (-1) depending if the input is positive or negative. And (0) if it is (0).
		System.out.println("38.- Signum 50.1 and -12.1 =          " + Math.signum(50.1) + " and " + Math.signum(-12.1));
		
	    //Pithagoras Theorem
		System.out.println("39.- Hypot of CO (15), CA (20) =      " + Math.hypot(15.0, 20.0));
	 
		//Pithagoras Theorem 2
		System.out.println("40.- Hypot2 of CO (15), CA (20) =     " + Math.sqrt(Math.pow(15.0, 2) + Math.pow(20.0,2)));
		
		//Get exponent without Bias Value (127) by applying IEEE to decimal numbers from a double function.
		//Meaning the exponent with a base (2) from which we can obtain a number lower than the initial one.
		//For example 2^4 <= 17, with 17 as the initial value. So the exponent is (4)
		System.out.println("41.- Exponent without bias =          " + Math.getExponent(17.0));
	 
		//Copy a number sign into another number
		System.out.println("42.- Copy Sign form (-12) to (100) =  " + Math.copySign(100, -12));
	 
		//Next floating point number uppwards (Into the positive infinity).
		System.out.println("43.- Next floating number up (10) =   " + Math.nextUp(10.0));
	    
	    //Next floating point number downwards (Into the negative infinity).
		System.out.println("44.- Next floating number down (5) =  " + Math.nextDown(5.0));
	 
		//Next floating point number from the first number into the direction of the second one.
		System.out.println("45.- Next floating (5 to 10) =        " + Math.nextAfter(5.0, 10.0));
		
	    //Optimized way of calculating (f*(2^x)). F is the number to be scaled and x the scaling factor.
		System.out.println("46.- Scale Number (10*(2^4)) =        " + Math.scalb(10,4));

	}
	
	static Double round(Double val) {
		return new BigDecimal(val.toString()).setScale(4,RoundingMode.HALF_UP).doubleValue();
	}

}
