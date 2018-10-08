import javax.swing.JOptionPane;

public class Sphere {
	private double radius, volume, SA;

	public void setVarsToZero() {
		radius = 0.0;
		volume = 0.0;
		SA = 0.0;
	}

	public void getRadius() {
		radius = Double.parseDouble(JOptionPane.showInputDialog("Please input the radius of a sphere."));
		JOptionPane.showMessageDialog(null, "The radius is " + radius);
	}

	public void calcVolume() {
		volume =(4d/3d)* Math.PI * Math.pow(radius, 3);
	}

	public void calcSA() {
		SA = 4 * Math.PI * Math.pow(radius, 2);
	}

	public void showVars() {
		String msg = "The radius of the circle is " + radius + ", the circumference of the circle is " + volume
				+ ", and the area of the circle is " + SA;
		JOptionPane.showMessageDialog(null, msg);
	}

}
