import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SwingConverter implements ActionListener {

	private JPanel inputPanel = initInputPanel();
	private JTextField inputText, sInput;
	private JTextArea resultArea, sResult;
	private JButton enterButton, sEnter;

	public SwingConverter() {
		JFrame myWindow = new JFrame("Base Converter - Created by Caleb P");
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myWindow.add(inputPanel);
		myWindow.setSize(600, 500);
		myWindow.setVisible(true);
	}

	private JPanel initInputPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(java.awt.Color.BLUE);

		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		panel.setLayout(null);
		JLabel label = new JLabel("Enter a base 10 number: ");

		label.setBounds(50, 50, 220, 30);
		panel.add(label);

		JTextField text;
		text = inputText = new JTextField();
		text.setBounds(230, 50, 100, 30);
		panel.add(text);

		JButton button = new JButton("Enter");
		button.setActionCommand("Enter");
		button.setBounds(340, 50, 80, 30);
		button.addActionListener(this);
		button.setBackground(java.awt.Color.RED);
		panel.add(button);
		// save to the class variable, to be used in other methods
		enterButton = button; // assign it to class var to be used in other methods

		button = new JButton("Reset");
		button.setActionCommand("Reset");
		button.setBounds(430, 50, 80, 30);
		button.addActionListener(this);
		button.setBackground(java.awt.Color.GREEN);
		panel.add(button);

		resultArea = new JTextArea();
		resultArea.setBounds(50, 180, 500, 200);
		resultArea.setEditable(false);
		resultArea.setBackground(java.awt.Color.CYAN);
		panel.add(resultArea);
		
		
		
		//Sphere calculations start here
		//Surface Area, Volume
		JLabel sLabel = new JLabel("Enter the radius of a sphere:");
		sLabel.setBounds(50, 400, 220, 30);
		panel.add(sLabel);
		
		JTextField sText;
		sText = sInput = new JTextField();
		sText.setBounds(250, 400, 100, 30);
		panel.add(sText);
		
		JButton sButton = new JButton("Enter");
		sButton.setActionCommand("SphereEnter");
		sButton.setBounds(360, 400, 80, 30);
		sButton.addActionListener(this);
		sButton.setBackground(java.awt.Color.RED);
		panel.add(sButton);
		sEnter = sButton;
		
		sButton = new JButton("Reset");
		sButton.setActionCommand("SphereReset");
		sButton.setBounds(450, 400, 80, 30);
		sButton.addActionListener(this);
		sButton.setBackground(java.awt.Color.GREEN);
		panel.add(sButton);
		
		sResult = new JTextArea();
		sResult.setBounds(50, 530, 500, 200);
		sResult.setEditable(false);
		sResult.setBackground(java.awt.Color.CYAN);
		panel.add(sResult);
		

		return panel;
	}

	public static void main(String[] args) throws Exception {
		// SwingConverter baseConverter = new SwingConverter();
		new SwingConverter();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String command = ev.getActionCommand();
		if (command.equals("Enter")) {
			showResult();
		} else if (command.equals("Reset")) {
			reset();
		}
		else if (command.equals("SphereEnter")){
			showSphere();
		}
		else if (command.equals("SphereReset")) {
			resetSphere();
		}
	}

	

	private void showSphere() {
		//System.out.println("showResult entered");
		sInput.setEnabled(false);
		
		sEnter.setEnabled(false);
		Integer s = getSphereInput();
		
		if (s == null) {
			sResult.append("Invalid Number");
			return;
		}
		int radius = s.intValue();
		sResult.append("Radius is " + radius +"\n");
		sResult.append("Surface Area is " + (4*Math.PI*Math.pow(radius,2)) +"\n");
		sResult.append("Volume is " +((4d/3d)* Math.PI * Math.pow(radius, 3)));
		
	}

	private void resetSphere() {
		sInput.setText("");
		sResult.setText("");
		sInput.setEnabled(true);
		sEnter.setEnabled(true);
		sInput.requestFocus();
		
	}
	
	private void showResult() {
		// System.out.println("showResult entered");

		String hexUpperCase;
		inputText.setEnabled(false);
		enterButton.setEnabled(false);

		Integer n = getInputNumber();
		if (n == null) {
			resultArea.append("Invalid Number");
			return;
		}

		int baseTenNumber = n.intValue();
		resultArea.append("base 10 = " + baseTenNumber + "\n");
		resultArea.append("binary = " + Integer.toString(baseTenNumber, 2) + "\n");
		resultArea.append("octal = " + Integer.toString(baseTenNumber, 8) + "\n");
		resultArea.append("hexadecimal = " + Integer.toString(baseTenNumber, 16) + "\n");

		hexUpperCase = Integer.toString(baseTenNumber, 16).toUpperCase();
		resultArea.append("hexadecimal = " + hexUpperCase + "\n");
	}

	private Integer getSphereInput() {
		try {
			Integer s = Integer.parseInt(sInput.getText());
			return s;
		} catch (Exception e) {
			return null;
		}
		
	}

	private Integer getInputNumber() {
		try {
			Integer n = Integer.parseInt(inputText.getText());
			return n;
		} catch (Exception e) {
			//whoops problem with number entry, this traps this error, now tell user the error and let them try an entry again
			// return null is to prevent a total crash but it really is not fixing the problem
		return null;
		}
	}

	private void reset() {
		// System.out.println("Result entered");
		inputText.setText("");
		resultArea.setText("");
		inputText.setEnabled(true);
		enterButton.setEnabled(true);
		inputText.requestFocus();

	}

}
