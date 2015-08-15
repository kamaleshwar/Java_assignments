
/*
 *GuiConverter.java
 *
 * Version:
 *     $Id: GuiConverter.java,v 1.7 11/17/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * This class creates the guiComponents necessary
 * 
 */

public class GuiConverter extends JFrame {

	String[] options = { "select", "Fahrenheit->Celsius","Celsius->Fahrenheit", 
			"Inches->Meter", "Meter->Inches","Kmph->mph", "mph->kmph", 
			"km->lightyear", "lightyear->km"};

	static double inputval;
	static double outputVal;
	static int index = -1;
	final JTextField inputField = new JTextField();
	final JTextField outputField = new JTextField(25);
	
	
	public GuiConverter() {

		super("Converter");		
		setResizable(false);
		setLayout(new FlowLayout());
		new UniversalConverter().inputmethod();

	}

	public double Operations(double Val) {
		if (index == 0) {
			outputVal = ((Val - 32) * 5) / 9;
		} else if (index == 1) {
			outputVal = ((Val * 9) / 5) + 32;
		}
		else if (index == 2) {
			outputVal=(Val/39.370);
		}
		else if (index == 3) {
			outputVal=(Val*39.370);
		}
		else if (index == 4) {
			outputVal=(Val/1.609344);
		}
		else if (index == 5) {
			outputVal=(Val*1.609344);
		}
		else if (index == 6) {
			outputVal=(Val/9460524);
			outputVal=outputVal/100000000;
		}
		else if (index == 7) {
			outputVal=(Val*9460524);
			outputVal=outputVal*100000000;
		}

		else {
			JOptionPane.showMessageDialog(null, "select options");
		}

		return outputVal;
	}


/**
 * This class implements all the necessary operations for conversions
 * 
 */
	
	class UniversalConverter {
		public UniversalConverter() {
			JLabel InputLable = new JLabel("Input");
			JLabel outputLabel = new JLabel("Output");
			JButton convert = new JButton("convert");
			
			final JComboBox JOptions = new JComboBox(options);
			JOptions.setSelectedIndex(0);

			Dimension d = new Dimension();
			d.setSize(80, 20);

			outputField.setEditable(false);
			inputField.setPreferredSize(d);
			outputField.setPreferredSize(d);


			add(InputLable);
			add(inputField);
			add(outputLabel);
			add(outputField);
			add(JOptions);
			add(convert);

			// ComboBox action listener
			JOptions.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					index=JOptions.getSelectedIndex()-1;
				}
			});

			// convert action listener
			convert.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					inputval = Double.parseDouble(inputField.getText());
					double output = Operations(inputval);					
					outputField.setText(" " + (output));
				}
			});

		}
		

		/**
		 * inputmethod defines the behavior of the components added
		 */
		
		// Taken from HPB's Slides
		public void inputmethod() {
			JButton button = null;

			for (int i = 0; i < 10; i++) {
				button = new JButton("" + i);
				button.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						inputField.setText(inputField.getText()
								+ e.getActionCommand());
					}
				});

				
				add(button);
			}
			JButton dot_button = new JButton(".");
			JButton Backspace_button = new JButton("Del");
			JButton neg_button = new JButton("Neg");
			
			dot_button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					inputField.setText(inputField.getText()
							+ e.getActionCommand());			
				}
			});
			add(dot_button);
			
			Backspace_button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try{
					String removeString=inputField.getText().
							substring(0,inputField.getText().length()-1);
					inputField.setText(removeString);
					}
					catch(StringIndexOutOfBoundsException siobe)
					{
						JOptionPane.showMessageDialog(null, "Nothing to Delete");
					}

				}
			});
			add(Backspace_button);
			
			neg_button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String negateString="-"+inputField.getText();							
					inputField.setText(negateString);					
				}
			});
			add(neg_button);
		}
	}

	public static void main(String args[]) {
		GuiConverter gc = new GuiConverter();
		gc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gc.setVisible(true);
		gc.setSize(1200, 100);
	}
}
