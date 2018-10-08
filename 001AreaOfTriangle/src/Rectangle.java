//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Rectangle {
	private double pairA, pairB;
	private double perimeter;
	private double area;
	private double diagonal;
	
	//Scanner keyboard = new Scanner(System.in);
	
	public void setVarsToZero() {
		 pairA = 0.0;
		 pairB = 0.0;
		 perimeter = 0.0;
		 area = 0.0;
	}

	public void setSides() {
		//System.out.println("Enter the length of one pair of sides on the rectangle: ");
		//pairA = keyboard.nextDouble();
		pairA = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for pair A: "));

		//System.out.println("Enter the length of the other pair of sides on the rectangle: ");
		//pairB = keyboard.nextDouble();
		pairB = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for pairB: "));
		
	}
	
	public void calcPerimeter() {
		perimeter = (2*pairA) + (2*pairB);
		
	}
	
	public void calcArea() {
		area = pairA*pairB;
		
	}
	
	public void calcDiagonal() {
		diagonal = Math.sqrt(Math.pow(pairA, 2) + Math.pow(pairB, 2));
	}
	

	public void showVars() {
		
		//System.out.println("The first pair of sides= " +pairA);
		//System.out.println("The second pair of sides= " +pairB);
		//System.out.println("The perimeter is " +perimeter);
		//System.out.println("The area is " +area);
		
		String msg = "The first pair of sides= " +pairA + ", the second pair of sides= " +pairB + ", the perimeter is " +perimeter + ", the area is " +area+ " and the diagonals of the rectangle are " +diagonal;
		
		JOptionPane.showMessageDialog(null, msg);
		
		
		
		
	}

	

	

	

}
