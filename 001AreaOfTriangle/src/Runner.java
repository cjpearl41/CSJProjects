import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

public class Runner {
	
	/*
	 * For grade:
	 * Circle: Input r, calculate circumference and area 
	 * Rectangle: Input side a and b, calculate perimeter area and diagonal DONE
	 * Triangle: Input sides a, b, c: calc perimeter area and all angles DONE
	 * Cuboid: input sides a b and , calc volume, total surface area
	 * Sphere: Input radius, clac volume, and surface area
	 */

	public static void main( String[] args) {
		
		//JOptionPane.showMessageDialog(null, "Hello, Welcome to my most amazing Java geometry program!");
		
		
		//Instantiate each class
		JOptionPane.showMessageDialog(null, "Welcome to my geometery porgram created by: Caleb P, on 9/14/18, period: 3A");

		Triangle myTriangle = new Triangle();
		Rectangle myRectangle = new Rectangle();
		Circle myCircle = new Circle();
		Cuboid myCuboid = new Cuboid();
		Sphere mySphere = new Sphere();
		
		int goAgain = 1;
		
		while (goAgain == 1) {
		String msg = "Please enter your selection: Triangle, Circle, Rectangle, Cuboid, or Sphere";
		String answer = JOptionPane.showInputDialog(msg);
		//When comparing strings, == is unreliable - so that means... don't use it.
		//Use String class  methods .equal
		if ((answer.equals("Triangle")) || (answer.equals("triangle"))) {
			JOptionPane.showMessageDialog(null, "You chose Triangle");
			myTriangle.setVarsToZero();
			myTriangle.setSides();
			myTriangle.calcPerimeter();
			myTriangle.calcArea();
			myTriangle.showVars();
			myTriangle.calcAngles();
			myTriangle.showVarsAngles();
		}
		else if ((answer.equals("Rectangle")) || (answer.equals("rectangle"))) {
			JOptionPane.showMessageDialog(null, "You chose Rectangle");
			myRectangle.setVarsToZero();
			myRectangle.setSides();
			myRectangle.calcPerimeter();
			myRectangle.calcArea();
			myRectangle.calcDiagonal();
			myRectangle.showVars();
		}
		else if ((answer.equals("Circle")) || (answer.equals("circle")))  {
			JOptionPane.showMessageDialog(null, "You chose Circle");
			myCircle.setVarsToZero();
			myCircle.getRadius();
			myCircle.calcCirc();
			myCircle.calcArea();
			myCircle.showVars();
		}
		else if (answer.equals("Cuboid")  || (answer.equals("cuboid")))   {
			JOptionPane.showMessageDialog(null, "You chose Cuboid");
			myCuboid.setVarsToZero();
			myCuboid.setSides();
			myCuboid.calcVolume();
			myCuboid.calcSA();
			myCuboid.showVars();
		}
		else if (answer.equals("Sphere")  || (answer.equals("sphere")))   {
			JOptionPane.showMessageDialog(null, "You chose Sphere");
			mySphere.setVarsToZero();
			mySphere.getRadius();
			mySphere.calcVolume();
			mySphere.calcSA();
			mySphere.showVars();
		}
		else {
			JOptionPane.showMessageDialog(null, "Please try again.");
		}
		
		msg = "Would you like to go again? (Y/N)";
		answer = JOptionPane.showInputDialog(msg);
		if (((answer.equals("Y"))) || ((answer.equals("y"))) || ((answer.equals("Yes"))) || ((answer.equals("yes")))) {
			goAgain = 1;
		}
		else {
			goAgain = 0;
			JOptionPane.showMessageDialog(null, "Thank you! Come back again");
		}
		} //End of while loop

		

		
		

		

		
		
		
		
	} // End of Main
} //End of Runner
