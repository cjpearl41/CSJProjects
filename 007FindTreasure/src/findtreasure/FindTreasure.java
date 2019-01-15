package findtreasure;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FindTreasure extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// <-------- Field Variables -------->
	
	
	int col = 5;
	int row=5;
	JLabel[][] choiceLabel1 = new JLabel[row][col];
	int[][] grid = new int[col][row] ;
	
	JLabel[] choiceLabel = new JLabel[24];
	ImageIcon chest = new ImageIcon("chest.jpeg");
	ImageIcon squid = new ImageIcon("PirateSquid.jpg");
	JButton newButton = new JButton();
	int chestLocation;
	int chestLocation2;
	int squidLocation;
	int SquidLocation2;
	int counter;
	JLabel counterLabel = new JLabel();
	Random myRandom = new Random();
	

	// <-------- Constructor -------->
	public FindTreasure() {
		
		//setSize(1000, 800);
		setTitle("Find the Chest! - by Caleb P, November 2018");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent evt) {
				
				exitForm(evt);
			}
		});
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints;
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = col/3;
		gridConstraints.gridy = row+1;
		getContentPane().add(counterLabel, gridConstraints);
		
		// Required: Set a layout manager, or use null
		for(int b = 0; b<col;b++) {
			for(int a=0;a<row;a++) {
				choiceLabel1[a][b] = new JLabel();
			}
		}

		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j< row; j++) {
				gridConstraints = new GridBagConstraints();
				choiceLabel1[j][i].setPreferredSize(new Dimension(chest.getIconWidth(), chest.getIconHeight()));
				choiceLabel1[j][i].setOpaque(true);
				choiceLabel1[j][i].setBackground(Color.RED);
				gridConstraints.gridx = i;
				gridConstraints.gridy = j;
				gridConstraints.insets = new Insets(10, 10, 10, 10);
				getContentPane().add(choiceLabel1[j][i], gridConstraints);
				choiceLabel1[j][i].addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						labelMouseClicked(e);
					}

					
				});
			}
			
			
		}
		newButton.setText("Play Again?");
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = col/2;
		gridConstraints.gridy = row+1;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(newButton, gridConstraints);
		newButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				newButtonActionPreformed(e);
				
			}



			
		});
		getContentPane().setBackground(Color.YELLOW);
		pack();
		newButton.doClick();
		} // End of Constructor
	
	
	
	// <-------- Methods -------->
	private void exitForm(WindowEvent evt) {
		System.exit(0);
	}
	private void newButtonActionPreformed(ActionEvent e) {
		//clear boxes and hide cat
		for (int i=0; i <col; i++) {
			for(int j=0; j<row; j++) {
				choiceLabel1[j][i].setIcon(null);
				choiceLabel1[j][i].setBackground(Color.RED);
				counter = 0;
				counterLabel.setText("");
			}
			
				
			
		}
		chestLocation = myRandom.nextInt(row);
		chestLocation2 = myRandom.nextInt(col);
		squidLocation =  myRandom.nextInt(row);
		SquidLocation2 = myRandom.nextInt(col);
		newButton.setEnabled(false);
		
	}
	private void labelMouseClicked(MouseEvent e) {
		Component clickedComponent = e.getComponent();
		int choice;
		for(choice=0; choice < col; choice++) {
			for(int choice2=0; choice2 < row; choice2++) {
				if(clickedComponent == choiceLabel1[choice][choice2])
				{
					choiceLabel1[choice][choice2].setBackground(Color.WHITE);
					counter ++;
					counterLabel.setText("Counter:" + counter);
					if(choice == chestLocation && choice2 == chestLocation2) {
						choiceLabel1[choice][choice2].setIcon(chest);
						newButton.setEnabled(true);
						
						
					}
					else if(choice == squidLocation && choice2 == SquidLocation2) {
						choiceLabel1[choice][choice2].setIcon(squid);
						JOptionPane.showMessageDialog(null, "Shiver me timbers, that darn pirate squid stole ye treasure.");
						for (int i=0; i <col; i++) {
							for(int j=0; j<row; j++) {
								choiceLabel1[j][i].setIcon(null);
								choiceLabel1[j][i].setBackground(Color.RED);
							}
							
								
							
						}
						chestLocation = myRandom.nextInt(row);
						chestLocation2 = myRandom.nextInt(col);
						squidLocation =  myRandom.nextInt(row);
						SquidLocation2 = myRandom.nextInt(col);
						newButton.setEnabled(false);
					}
				}
			}
			
		}
		
		
	}
} // End of class FindTreasure
