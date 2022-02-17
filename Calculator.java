import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

class Calculator implements ActionListener{
 static JFrame frame;
 static JLabel textfield;
 JButton[] numberButtons = new JButton[10];
 JButton[] operationButtons = new JButton[8];
 static JButton addButton, subButton, mulButton, divButton, deciButton, equButton, delButton, clearButton;
 static JPanel panel;
 double number;
 double result;
 char operator = ' ';
 static int intColor = Integer.parseInt("D9D9D9", 16);
 static Color color = new Color(intColor);
 static int intColor2 = Integer.parseInt("3cb371", 16);
 static Color color2 = new Color(intColor2);
 static int intColor3 = Integer.parseInt("1E90FF", 16);
 static Color color3 = new Color(intColor3);
 static int intColor4 = Integer.parseInt("FF69B4", 16);
 static Color color4 = new Color(intColor4);
 static ImageIcon icon = new ImageIcon("C:\\Users\\Elias\\Calculator App Icon.png");
 static Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
 static Font font2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
 static JMenuBar bar = new JMenuBar();
 static JMenu menu = new JMenu("Style");
 static JMenuItem green = new JMenuItem("Green");
 static JMenuItem blue = new JMenuItem("Blue");
 static JMenuItem pink = new JMenuItem("Pink");
 static Color currentColor = color2;
 
 Calculator() {
   frame = new JFrame("Calculator");
   frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
   frame.setMinimumSize(new Dimension(250, 400));
   frame.getContentPane().setLayout(null);
   frame.setResizable(true);
   frame.setIconImage(icon.getImage());
   menu.add(green);
   menu.add(blue);
   menu.add(pink);
   green.addActionListener(this);
   blue.addActionListener(this);
   pink.addActionListener(this);
   bar.add(menu);
   bar.setBackground(Color.white);
   frame.setJMenuBar(bar);
   textfield = new JLabel("0");
   textfield.setBackground(Color.WHITE);
   textfield.setFont(font);
   textfield.setForeground(Color.WHITE);
   addButton = new JButton("+");
   subButton = new JButton("-");
   mulButton = new JButton("*");
   divButton = new JButton("/");
   deciButton = new JButton(".");
   equButton = new JButton("=");
   delButton = new JButton("Delete");
   clearButton = new JButton("Clear");
   operationButtons[0] = addButton;
   operationButtons[1] = subButton;
   operationButtons[2] = mulButton;
   operationButtons[3] = divButton;
   operationButtons[4] = deciButton;
   operationButtons[5] = equButton;
   operationButtons[6] = clearButton;
   for(int i = 0; i < 7; i++) {
	operationButtons[i].addActionListener(this);
	operationButtons[i].setFocusable(false);
	operationButtons[i].setBackground(color2);
	operationButtons[i].setBorderPainted(false);
	operationButtons[i].setFont(font2);
   }
   for(int i = 0; i < 10; i++) {
	 numberButtons[i] = new JButton(String.valueOf(i));
	 numberButtons[i].addActionListener(this);
	 numberButtons[i].setFocusable(false);
	 numberButtons[i].setBackground(Color.WHITE);
	 numberButtons[i].setBorderPainted(false);
	 numberButtons[i].setFont(font2);
   }
   panel = new JPanel();
   panel.setLayout(new GridLayout(4,4,10, 10));
   panel.setBackground(Color.DARK_GRAY);
   panel.add(numberButtons[7]);
   panel.add(numberButtons[8]);
   panel.add(numberButtons[9]);
   panel.add(mulButton);
   panel.add(numberButtons[4]);
   panel.add(numberButtons[5]);
   panel.add(numberButtons[6]);
   panel.add(divButton);
   panel.add(numberButtons[1]);
   panel.add(numberButtons[2]);
   panel.add(numberButtons[3]);
   panel.add(addButton);
   panel.add(deciButton);
   panel.add(numberButtons[0]);
   panel.add(subButton);
   panel.add(equButton);
   frame.getContentPane().add(panel);
   frame.add(clearButton);
   frame.add(textfield);
   frame.setVisible(true);
   frame.setBounds(0, 0, frame.getWidth(), frame.getHeight());
   frame.getContentPane().setBackground(Color.DARK_GRAY);
   frame.setExtendedState(frame.MAXIMIZED_BOTH);
 }
  public static void main(String[]args) {
    new Calculator();
    for (;;) {
      textfield.setBounds(0, 25, frame.getWidth() - 16, frame.getHeight() / 10);
      panel.setBounds(0, frame.getHeight() / 10 + 50, frame.getWidth() - 16, frame.getHeight() / 2);
      clearButton.setBounds(0, frame.getHeight() - frame.getHeight() / 4, frame.getWidth() - 16, frame.getHeight() / 8);
    }
  }
@Override
 public void actionPerformed(ActionEvent e) {
   if (e.getSource() == green) {
	for(int i = 0; i < 7; i++) {
	 operationButtons[i].setBackground(color2);
	}
	currentColor = color2;
   }
   if (e.getSource() == blue) {
	for(int i = 0; i < 7; i++) {
	 operationButtons[i].setBackground(color3);
	}
	currentColor = color3;
   }
   if (e.getSource() == pink) {
	for(int i = 0; i < 7; i++) {
	 operationButtons[i].setBackground(color4);
	}
	currentColor = color4;
   }
   for(int i = 0; i < 10; i++) {
	 if(e.getSource() == numberButtons[i]) {
	  if (textfield.getText().equals("0")) {
	    textfield.setText(String.valueOf(i));
	  }
	  else {
	   textfield.setText(textfield.getText().concat(String.valueOf(i)));
	  }
	 }
   }
   if (e.getSource() == deciButton) {
	 textfield.setText(textfield.getText().concat("."));
   }
   if (e.getSource() == addButton) {
	 number = Double.parseDouble(textfield.getText());
	 if (operator == ' ') {
	   result = number;
	 }
	 else {
	   calculate();
	 }
	 operator = '+';
	 textfield.setText("");
   }
   if (e.getSource() == subButton) {
	   number = Double.parseDouble(textfield.getText());
		 if (operator == ' ') {
		   result = number;
		 }
		 else {
		   calculate();
		 }
		 operator = '-';
		 textfield.setText("");
   }
   if (e.getSource() == mulButton) {
	   number = Double.parseDouble(textfield.getText());
		 if (operator == ' ') {
		   result = number;
		 }
		 else {
		   calculate();
		 }
		 operator = '*';
		 textfield.setText("");
   }
   if (e.getSource() == divButton) {
	   number = Double.parseDouble(textfield.getText());
		 if (operator == ' ') {
		   result = number;
		 }
		 else {
		   calculate();
		 }
		 operator = '/';
		 textfield.setText("");
   }
   if (e.getSource() == equButton) {
	 number = Double.parseDouble(textfield.getText());
	 calculate();
	 if (((int) result) == result) {
	   textfield.setText(String.valueOf((int) result));
	 }
	 else {
	   textfield.setText(String.valueOf(result));
	 }
	 operator = ' ';
	 number = 0;
	 result = 0;
   }
   if (e.getSource() == clearButton) {
	 operator = ' ';
	 result = 0;
	 number = 0;
	 textfield.setText("0");
   }
 }
 public void calculate() {
    if (operator == '+') {
	  result = result + number;
    }
    if (operator == '-') {
  	  result = result - number;
    }
    if (operator == '*') {
  	  result = result * number;
    }
    if (operator == '/') {
  	  result = result / number;
    }
  }
}
