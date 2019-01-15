/**
 * Our main goal for this project is to: Add fractions together Learn JavaDocs
 * Enter two fractions as strings Use String methods to pull out numerator and
 * denominator Use common denominator to add, then reduce to lowest common
 * denominator (Just for first part of grading) (Second part) is to add,
 * multiply, subtract, and divide using JavaDocs
 * 
 * @author Caleb P
 *
 */
public class Fraction {
	/**
	 * 
	 */
	private static int numerator;
	/**
	 * 
	 */
	private static int denominator;
	/**
	 * 
	 */
	private static int numerator2;
	/**
	 * 
	 */
	private static int denominator2;
	/**
	 * 
	 */
	private static int finalNumerator;
	/**
	 * 
	 */
	private static int finalDenominator;

	public Fraction(String passFraction, String passFraction2) {
		int seperatorLocation = passFraction.indexOf("/");
		String numeratorStr = passFraction.substring(0, seperatorLocation);
		String denomStr = passFraction.substring(seperatorLocation + 1);
		Fraction.numerator = Integer.parseInt(numeratorStr);
		Fraction.denominator = Integer.parseInt(denomStr);

		int seperatorLocation2 = passFraction2.indexOf("/");
		String numeratorStr2 = passFraction2.substring(0, seperatorLocation2);
		String denomStr2 = passFraction2.substring(seperatorLocation2 + 1);
		Fraction.numerator2 = Integer.parseInt(numeratorStr2);
		Fraction.denominator2 = Integer.parseInt(denomStr2);
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		Fraction.numerator = numerator;
	}

	public int getdenominator() {
		return denominator;
	}

	public void setdenominator(int denominator) {
		Fraction.denominator = denominator;
	}

	public int getNumerator2() {
		return numerator2;
	}

	public void setNumerator2(int numerator) {
		Fraction.numerator2 = numerator;
	}

	public int getdenominator2() {
		return denominator2;
	}

	public void setdenominator2(int denominator) {
		Fraction.denominator2 = denominator;
	}
	public static int getFinalDenominator() {
		return finalDenominator;
	}

	public static void setFinalDenominator(int finalDenominator) {
		Fraction.finalDenominator = finalDenominator;
	}

	public static int getFinalNumerator() {
		return finalNumerator;
	}

	public static void setFinalNumerator(int finalNumerator) {
		Fraction.finalNumerator = finalNumerator;
	}
	/**
	 * This adds the fraction together
	 */
	public static void add(int num1, int den1, int num2, int den2) {
		setFinalNumerator((numerator * denominator2)
				+ (denominator * numerator2));
		setFinalDenominator((denominator * denominator2));
	}
	/**
	 * 
	 *This subtracts the fraction
	 *
	 */
	public static void sub(int num1, int den1, int num2, int den2) {
		setFinalNumerator((numerator * denominator2)
				- (denominator * numerator2));
		setFinalDenominator((denominator * denominator2));
		
	}
	/**
	 *This multiplies the fraction
	 *It just multiplies across 
	 */
	public static void mul(int num1, int den1, int num2, int den2) {
		setFinalNumerator(numerator*numerator2);
		setFinalDenominator(denominator*denominator2);
		
	}
	/**
	 *This divides the fraction 
	 *All it does is cross multiplies
	 */
	public static void div(int num1, int den1, int num2, int den2) {
		setFinalNumerator(numerator*denominator2);
		setFinalDenominator(denominator*numerator2);
		
	}
	/**
	 * This simplifies the fraction
	 * 
	 * @param num this is the numerator that is simplified
	 * @param den this is the denominator that is simplified
	 */

	public static void simplify(int num, int den) {
		int a = 2;
		while (a < 10) {
			if ((num % a == 0) && (den % a == 0)) {
				num = num / a;
				den = den / a;
				a = 2;
			}

			else {
				a++;
			}
		}
		setFinalNumerator(num);
		setFinalDenominator(den);
	}

	

	

	

	
}
