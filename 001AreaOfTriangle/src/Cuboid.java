import javax.swing.JOptionPane;

public class Cuboid {
	private double length, width, height, volume, SA;

	public void setVarsToZero() {
		length = 0.0;
		width = 0.0;
		height = 0.0;
		volume = 0.0;
		SA = 0.0;

	}

	public void setSides() {


		length = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for length: "));

		width = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for width: "));

		height = Double.parseDouble(JOptionPane.showInputDialog("Please enter a value for height: "));
		
		 String sideMsg = "The length is " +length+ ", the width is " +width+ ", the height is " +height;
		 JOptionPane.showMessageDialog(null, sideMsg);
	}
	public void calcVolume() {
		volume = length*width*height;
	}
	public void calcSA() {
		SA = (2*length*width)+(2*length*height)+(2*width*height);
	}
	public void showVars() {
		String msg = "The volume is " + volume+", and the surface area is " + SA;
		JOptionPane.showMessageDialog(null, msg);
	}
}
