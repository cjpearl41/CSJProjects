package mousedraw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.color.*;

public class MouseDraw extends JFrame {

	JMenuBar mainMenuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem exitMenuItem = new JMenuItem("Exit");

	JMenu boardColor = new JMenu("BoardColor");
	JMenuItem blackMenuItem = new JMenuItem("Black");
	JMenuItem yellowMenuItem = new JMenuItem("Yellow");
	JMenuItem redMenuItem = new JMenuItem("Red");

	JMenu penSize = new JMenu("PenSize");
	JMenuItem fineMenuItem = new JMenuItem("Fine");
	JMenuItem smallMenuItem = new JMenuItem("Small");
	JMenuItem mediumMenuItem = new JMenuItem("Medium");
	JMenuItem largeMenuItem = new JMenuItem("Large");

	JPanel drawPanel = new JPanel();
	JPanel colorPanel = new JPanel();
	JLabel[] colorLabel = new JLabel[24];

	JLabel leftColorLabel = new JLabel();
	JLabel rightColorLabel = new JLabel();

	Color drawColor, leftColor, rightColor;

	double xPrevious, yPrevious;

	Graphics2D g2D;

	public MouseDraw() {
		// frame constructor
		setTitle("Artistic Creations by Caleb P. October 2018");
		setResizable(false);
		setSize(800, 700);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}// end of handler

		});// end of Listener

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(new Color(18, 20, 153));

		setJMenuBar(mainMenuBar);
		fileMenu.setMnemonic('F');
		mainMenuBar.add(fileMenu);
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		mainMenuBar.setBackground(new Color(114, 255, 231));
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMenuItemActionPerformed(e);
			}

		});
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitMenuItemActionPerformed(e);
			}

		});

		boardColor.setMnemonic('B');
		mainMenuBar.add(boardColor);
		boardColor.add(blackMenuItem);
		boardColor.addSeparator();
		boardColor.add(yellowMenuItem);
		boardColor.addSeparator();
		boardColor.add(redMenuItem);
		blackMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blackMenuItemActionPerformed(e);
			}

		});
		yellowMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yellowMenuItemActionPerformed(e);
			}

		});
		redMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redMenuItemActionPerformed(e);
			}

		});

		penSize.setMnemonic('P');
		mainMenuBar.add(penSize);
		penSize.add(fineMenuItem);
		penSize.addSeparator();
		penSize.add(smallMenuItem);
		penSize.addSeparator();
		penSize.add(mediumMenuItem);
		penSize.addSeparator();
		penSize.add(largeMenuItem);

		fineMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fineMenuItemActionPerformed(e);
			}

		});
		smallMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smallMenuItemActionPerformed(e);
			}

		});
		mediumMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediumMenuItemActionPerformed(e);
			}

		});
		largeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeMenuItemActionPerformed(e);
			}

		});

		drawPanel.setPreferredSize(new Dimension(500, 400));
		drawPanel.setBackground(new Color(200,200,200));

		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridheight = 2;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(drawPanel, gridConstraints);
		drawPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				drawPanelMousePressed(e);
			}
		});

		drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				drawPanelMouseDragged(e);
			}

		});
		drawPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				drawPanelMouseReleased(e);
			}

		});

		leftColorLabel.setPreferredSize(new Dimension(40, 40));
		leftColorLabel.setOpaque(true);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(leftColorLabel, gridConstraints);

		rightColorLabel.setPreferredSize(new Dimension(40, 40));
		rightColorLabel.setOpaque(true);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(rightColorLabel, gridConstraints);

		colorPanel.setPreferredSize(new Dimension(80, 390));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 2;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(colorPanel, gridConstraints);

		colorPanel.setLayout(new GridBagLayout());
		int j = 0;
		for (int i = 0; i < 24; i++) {
			colorLabel[i] = new JLabel();
			colorLabel[i].setPreferredSize(new Dimension(30, 30));
			colorLabel[i].setOpaque(true);
			gridConstraints = new GridBagConstraints();
			gridConstraints.gridx = j;
			gridConstraints.gridy = i - j * 12;
			colorPanel.add(colorLabel[i], gridConstraints);
			if (i == 11) {
				j++;
			}

			colorLabel[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					colorMousePressed(e);
				}

			});

		} // end of color grids loop
		
		//red
		colorLabel[0].setBackground(new Color(255, 153, 153));
		colorLabel[1].setBackground(new Color(255, 0, 0));
		colorLabel[2].setBackground(new Color(153, 0, 0));
		//green
		colorLabel[3].setBackground(new Color(132, 225, 132));
		colorLabel[4].setBackground(new Color(51, 204, 51));
		colorLabel[5].setBackground(new Color(25, 103, 25));
		//blue
		colorLabel[6].setBackground(new Color(102, 102, 255));
		colorLabel[7].setBackground(new Color(0, 0, 255));
		colorLabel[8].setBackground(new Color(0, 0, 128));
		//cyan
		colorLabel[9].setBackground(new Color(179, 255, 255));
		colorLabel[10].setBackground(new Color(0, 255, 255));
		colorLabel[11].setBackground(new Color(0, 128, 128));
		//magenta
		colorLabel[12].setBackground(new Color(255, 179, 255));
		colorLabel[13].setBackground(new Color(255, 0, 255));
		colorLabel[14].setBackground(new Color(128, 0, 128));
		//yellow
		colorLabel[15].setBackground(new Color(255, 255, 179));
		colorLabel[16].setBackground(new Color(255, 255, 0));
		colorLabel[17].setBackground(new Color(153, 153, 0));
		
		//Fun colors
		colorLabel[18].setBackground(new Color(255, 153, 0));
		colorLabel[19].setBackground(new Color(153, 0, 204));
		colorLabel[20].setBackground(new Color(255, 102, 153));
		colorLabel[21].setBackground(new Color(204, 102, 0));
		colorLabel[22].setBackground(new Color(153, 0, 51));
		colorLabel[23].setBackground(new Color(255, 0, 102));
		
		
		
		
		
		
		
		
		// FUN COLORS FOR PICKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
		//colorLabel[0].setBackground(new Color(29, 99, 37));
		//colorLabel[1].setBackground(new Color(255, 0, 229));
		//colorLabel[2].setBackground(new Color(0, 67, 255));
		//colorLabel[3].setBackground(new Color(0, 255, 250));
		//colorLabel[4].setBackground(new Color(0, 255, 123));
		//colorLabel[5].setBackground(new Color(107, 14, 237));
		//colorLabel[6].setBackground(new Color(13, 237, 188));
		//colorLabel[7].setBackground(new Color(246, 255, 0));
		//colorLabel[8].setBackground(new Color(255, 0, 0));
		//colorLabel[9].setBackground(new Color(255, 148, 0));
		//colorLabel[10].setBackground(new Color(0, 255, 255));
		//colorLabel[11].setBackground(new Color(255, 33, 132));
		//colorLabel[12].setBackground(new Color(255, 33, 132));
		//colorLabel[13].setBackground(new Color(255, 33, 132));
		//colorLabel[14].setBackground(new Color(255, 33, 132));
		//colorLabel[15].setBackground(new Color(255, 33, 132));
		//colorLabel[16].setBackground(new Color(255, 33, 132));
		//colorLabel[17].setBackground(new Color(255, 33, 132));
		

		leftColor = colorLabel[1].getBackground();
		leftColorLabel.setBackground(leftColor);
		rightColor = colorLabel[2].getBackground();
		rightColorLabel.setBackground(rightColor);
		
		pack();
		setLocationRelativeTo(null);

		g2D = (Graphics2D) drawPanel.getGraphics();

	}// end of constructor

	private void exitForm(WindowEvent e) {
		g2D.dispose();
		System.exit(0);
	}// end of exitForm methodnP

	private void newMenuItemActionPerformed(ActionEvent e) {
		int response;
		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new drawing?", "New Drawing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			g2D.setPaint(drawPanel.getBackground());
			g2D.fill(new Rectangle2D.Double(0,0, drawPanel.getWidth(), drawPanel.getHeight()));
		}

	}

	private void exitMenuItemActionPerformed(ActionEvent e) {
		int response;
		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit Program",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			return;
		} else {
			exitForm(null);
		}
	}

	private void drawPanelMousePressed(MouseEvent e) {
		// if left button or right button clicked, set color and start drawing process
		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
			xPrevious = e.getX();
			yPrevious = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				drawColor = leftColor;
			} else {
				drawColor = rightColor;
			}
		}
		// System.out.println("mouse x, y= " + xPrevious + ", " + yPrevious);
	}// end of mousePressed

	private void drawPanelMouseDragged(MouseEvent e) {

		// if drawing, connect previous point with new point
		Line2D.Double myLine = new Line2D.Double(xPrevious, yPrevious, e.getX(), e.getY());
		g2D.setPaint(drawColor);
		g2D.draw(myLine);
		xPrevious = e.getX();
		yPrevious = e.getY();
		//System.out.println("mouse x,y = " + xPrevious + ", " + yPrevious);

	}// end of drawPanelMouseDragged

	private void drawPanelMouseReleased(MouseEvent e) {
		//if left or right button released, connect last point
		if(e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
			Line2D.Double myLine = new Line2D.Double(xPrevious, yPrevious, e.getX(), e.getY());
			g2D.setPaint(drawColor);
			g2D.draw(myLine);
		}
	}//end of mouseReleased

	private void blackMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(0,0,0));
	}

	private void yellowMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(255,255,0));
	}

	private void redMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(255,0,0));
	}

	private void fineMenuItemActionPerformed(ActionEvent e) {
		g2D.setStroke(new BasicStroke(1));
	}

	private void smallMenuItemActionPerformed(ActionEvent e) {
		g2D.setStroke(new BasicStroke(2));
	}

	private void mediumMenuItemActionPerformed(ActionEvent e) {
		g2D.setStroke(new BasicStroke(10));
	}

	private void largeMenuItemActionPerformed(ActionEvent e) {
		g2D.setStroke(new BasicStroke(20));
	}

	private void colorMousePressed(MouseEvent e) {
		// decide which color was selected and which button was used
		java.awt.Component clickedColor = e.getComponent();
		// Make audible tone and set drawing color
		// Toolkit.getDefaultToolkit().beep();
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftColor = clickedColor.getBackground();
			leftColorLabel.setBackground(leftColor);

		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightColor = clickedColor.getBackground();
			rightColorLabel.setBackground(rightColor);
		}
	}// end of colorMousedPressed

}// end of class
