
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Triangle {
	// Class variables go here
	private double sideA, sideB, sideC;
	private double perimeter;
	private double theArea;

	// Scanner keyboard = new Scanner(System.in);

	// constructor goes here
	public Triangle() {

	}

	// methods go here

	public void setVarsToZero() {
		sideA = 0.0;
		sideB = 0.0;
		sideC = 0.0;
		perimeter = 0.0;
		theArea = 0.0;

	} // End of setVarsToZero

	public void showVars() {
		// System.out.println("Side A = " +sideA);
		// System.out.println("Side B = " +sideB);
		// System.out.println("Side C = " +sideC);
		// System.out.println("The perimeter = " +perimeter);
		// System.out.println("The Area = " +theArea);

		String msg = "Side A, B, C = " + sideA + ", " + sideB + ", " + sideC + "; perimeter: " + perimeter + "; area = "
				+ theArea;

		JOptionPane.showMessageDialog(null, msg);

	} // End of showVars

	public void setSides() {

		// System.out.println("Please enter a value for side A: ");
		// sideA = keyboard.nextDouble();
		boolean a = true;
		while (a) {
			try {
				sideA = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for side A: "));
				a = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
		}
		// System.out.println("Please enter a value for side B: ");
		// sideB = keyboard.nextDouble();
		boolean b = true;
		while (b) {
			try {
				sideB = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for side B: "));
				b = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
		}

		//sideB = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for side B: "));

		// System.out.println("Please enter a value for side C: ");
		// sideC = keyboard.nextDouble();
		boolean c = true;
		while (c) {
			try {
				sideC = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for side c: "));
				c = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
		}

		//sideC = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for side C: "));
	} // End of setSides

	public void calcPerimeter() {
		perimeter = sideA + sideB + sideC;
	}

	public void calcArea() {
		double p = 0.0;
		p = (sideA + sideB + sideC) / 2.0;
		theArea = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
	}

	public void calcAngles() {
		double cosA = 0.0, Acos = 0.0, Adeg = 0.0;
		double cosB = 0.0, Bcos = 0.0, Bdeg = 0.0;
		double cosC = 0.0, Ccos = 0.0, Cdeg = 0.0;

		cosA = ((Math.pow(sideB, 2.0) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC));
		// System.out.println("cosA =" +cosA);
		Acos = Math.acos(cosA);
		// System.out.println("arcCos =" +Acos);
		Adeg = Math.toDegrees(Acos);
		// System.out.println("The degree of angle A is " +Adeg);

		cosB = ((Math.pow(sideA, 2.0) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) / (2 * sideA * sideC));
		// System.out.println("cosB =" +cosB);
		Bcos = Math.acos(cosB);
		// System.out.println("arcCos =" +Bcos);
		Bdeg = Math.toDegrees(Bcos);
		// System.out.println("The degree of angle B is " +Bdeg);

		cosC = ((Math.pow(sideA, 2.0) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (2 * sideA * sideB));
		// System.out.println("cosC =" +cosC);
		Ccos = Math.acos(cosC);
		// System.out.println("arcCos =" +Ccos);
		Cdeg = Math.toDegrees(Ccos);
		// System.out.println("The degree of angle C is " +Cdeg);

		String AngleMSG = "The degree of angle A = " + Adeg + ", the degree of angle B = " + Bdeg
				+ ", and the degree of angle C = " + Cdeg;

		JOptionPane.showMessageDialog(null, AngleMSG);

	}

	public void showVarsAngles() {

	}

} // End of class
