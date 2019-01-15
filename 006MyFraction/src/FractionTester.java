import javax.swing.JOptionPane;

public class FractionTester {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to my fraction program created by: Caleb P");
		String msg = "Put in two fractions to combine (be sure to put a / in the middle, like x/y). There will be two screens for the two fractions to combine.";
		String answer1 = JOptionPane.showInputDialog(msg);
		String answer2 = JOptionPane.showInputDialog(msg);
		Fraction myFraction = new Fraction(answer1, answer2);
		int num1 = myFraction.getNumerator();
		int num2 = myFraction.getNumerator2();
		int den1 = myFraction.getdenominator();
		int den2 = myFraction.getdenominator2();
		
		msg = "Do you want to add, subtract, multiply, or divide? (add, sub, mul, div)";
		
		
		
			String answer = JOptionPane.showInputDialog(msg);
			if(answer.equals("add")) {
				Fraction.add(num1, den1, num2, den2);
				
			}
			else if(answer.equals("sub")){
				Fraction.sub(num1, den1, num2, den2);
				
			}
			else if(answer.equals("mul")) {
				Fraction.mul(num1, den1, num2, den2);
				
			}
			else if(answer.equals("div")) {
				Fraction.div(num1, den1, num2, den2);
				
			}
			else {
				answer = JOptionPane.showInputDialog("Im sorry I didn't catch that. Please try again");
			}
		
		
		
		int finalNumerator = Fraction.getFinalNumerator();
		int finalDenominator = Fraction.getFinalDenominator();

		
		Fraction.simplify(finalNumerator, finalDenominator);
		finalNumerator = Fraction.getFinalNumerator();
		finalDenominator = Fraction.getFinalDenominator();


		JOptionPane.showMessageDialog(null, "the reduced fraction is: " + finalNumerator + "/" + finalDenominator);

	}

}
