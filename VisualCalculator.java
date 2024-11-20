package visualcalculator;

import javax.swing.*; // imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class VisualCalculator { 
    
    private JFrame frame;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };
    
    // operation var
    private String currentOperator = "";
    // double var holder
    private double firstOperand = 0.0;
    
    public VisualCalculator() {
        initialize();
    }
    
    // creating the frame    
    private void initialize() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //jframe exit on close
        frame.getContentPane().setBackground(Color.PINK); //frame color to pink
        frame.setLayout(new BorderLayout());
        
    
        // need to display text here
        textField = new JTextField(20); 
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(Color.PINK); //recolor background and forground 
        textField.setForeground(Color.BLACK); 
        textField.setPreferredSize(new Dimension(200, 50));
        textField.setFont(new Font("Brush Script MT", Font.ITALIC, 50)); //font + font size for  text display
        frame.add(textField, BorderLayout.NORTH);
        
        // panel for buttons and layout
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        
        ButtonClickListener buttonClickListener = new ButtonClickListener();
        for (int i = 0; i < buttonLabels.length; i++) { //len buttons
        	JButton button = new JButton(buttonLabels[i]);
        	button.addActionListener(buttonClickListener);
        	buttonPanel.add(button);
        
        }
        buttonPanel.setPreferredSize(new Dimension(400, 500)); // pannel size
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    // action listener for buttons
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton)e.getSource()).getText(); //determines which buttons where clicked, and text along with them
            if (command.equals("=")) {
                calculateResult();
            } else if (command.equals("C")) {
                textField.setText("");
            } else {
                textField.setText(textField.getText() + command); //appends user input text
            }
        }
    }

    
    

    // calculator  (all the math)
    private void calculateResult() {
        String expression = textField.getText();
        if (expression.contains("+")) { //checkng if it contains additon 
            String[] operands = expression.split("\\+"); 
            double result = Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]); //converts to double
            textField.setText(String.valueOf(result)); //result back into text feild
            
        } else if (expression.contains("-")) {
            String[] operands = expression.split("-"); //checking for subtraction operator 
            double result = Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]); //converts to double for subtraction
            textField.setText(String.valueOf(result));
            
        } else if (expression.contains("*")) { //checks for multiplication 
            String[] operands = expression.split("\\*");
            double result = Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]); //double for multiplication 
            textField.setText(String.valueOf(result)); 
            
        } else if (expression.contains("/")) { //checks for division operator 
            String[] operands = expression.split("/");
            double divisor = Double.parseDouble(operands[1]); // converts double for division
            
            if (divisor == 0) { //check is division by zero is attempted 
                textField.setText("Error: dont divide by zero shawty"); //error message
                
            } else {
                double result = Double.parseDouble(operands[0]) / divisor; // if not divided by zero ur all set
                textField.setText(String.valueOf(result)); //returns to text field
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // will run gui
            public void run() {
                new VisualCalculator(); //represents the gui calc
            }
        });
    }
}

// Program By: Bridget Wexler :3

					                 // Framework: 
	 
								// create frame ( 400 x 300 )
									// exit on close 
								
								// create layout of calculator (GridBag layout ---> x and y cords)
								// (GridBag, Order, Flow Layout, Grid, Box Layout)
								
								// create buttons and labels (manual, dont forget action lisener) 
									// numbers = 0-9
									// operations = +, -, *, /
									// equals
									// decimal points
									// clear
								
								
								// Display GUI
									// text field
									// backspace to type in gui
								
						
								// Methods for operators 
									//add
									// subtract
									// multiply
									// divide (code to handle divide by zero)
								// Methods for equals  of two operators 
									// mindful of order of operation
								
								//Clear Method
									// TextField remove All
								
								
								
		
		

		



