import javax.swing.JOptionPane;

public class Circle {
	private double radius, area, circumference;


	public void setVarsToZero() {
		radius = 0.0;
		circumference = 0.0;
		area = 0.0;
	}
	public void getRadius() {
		radius = Double.parseDouble(JOptionPane.showInputDialog("Please input the radius of a circle."));
		JOptionPane.showMessageDialog(null, "The radius is " +radius);
	}
	public void calcArea() {
		area = Math.PI*Math.pow(radius, 2);
	}
	public void calcCirc() {
		circumference = 2*Math.PI*radius;
	}
	public void showVars() {
		String msg = "The radius of the circle is " +radius+ ", the circumference of the circle is " +circumference + ", and the area of the circle is " +area ;
		JOptionPane.showMessageDialog(null, msg);
	}



} //End of main

	




