import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cipher {
	private String alpha = "zebracdfghijklmnopqstuvwxy0123456789.:";
	private String plainText = "";
	private String encodedText = "";
	private String ans;
	private int key = 0;
	Scanner keyboard = new Scanner(System.in);
	public Cipher() {
		JOptionPane.showMessageDialog(null, "Entered the cipher");
	}
	public void getplainText() {
		plainText = JOptionPane.showInputDialog("What would you like to encrypt?");
		JOptionPane.showMessageDialog(null, "You have entered: "+ plainText);
		
	}
	public void getKey() {
		key = Integer.parseInt(JOptionPane.showInputDialog("What would you like the key to be?"));
		JOptionPane.showMessageDialog(null,"You have entered: "+key);
		
	}
	public void encrypt() {
		for(int i=0;i<plainText.length();i++) {
			if(!alpha.contains(String.valueOf(plainText.charAt(i)))) {
				encodedText += " ";
				
			}
			else {
				char a = plainText.charAt(i);
				int index =alpha.indexOf(a);
				
				index = (index + key)%alpha.length();
				encodedText += alpha.charAt(index);
				
			
		}
		}
		JOptionPane.showMessageDialog(null,encodedText);
		
	}
	public String encryptDecrypt() {
		boolean f = false;
		while(f== false) {
			ans = JOptionPane.showInputDialog("Would you like to encrypt or decrypt? (E or D)");
			ans = String.valueOf(ans.charAt(0)).toUpperCase();
		if(ans.equals("E")||ans.equals("D")) {
				f=true;
			}
			else{
				JOptionPane.showMessageDialog(null,"That was not one of the choices");
			}
		}
		
		return(ans);
		
	}
	public void decrypt() {
		for(int i=0;i<encodedText.length();i++) {
			char a = encodedText.charAt(i);
			int index =alpha.indexOf(a);
			index = (index - key);
			while(index<0) {
				if(index<0) {
					index += alpha.length();
				}
			}
			plainText += alpha.charAt(index);
		}
		JOptionPane.showMessageDialog(null, plainText);
		
	}
		

	public void getEncodedText() {
		encodedText = JOptionPane.showInputDialog("Please enter the encoded text message");
		
		JOptionPane.showMessageDialog(null, "You have entered: "+ encodedText);
		
	}
}
