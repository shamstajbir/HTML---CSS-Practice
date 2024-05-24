import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, sqrtButton, clearButton, backButton, equalsButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;
    private boolean isErrorState = false;

    Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[8];

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        sqrtButton = new JButton("√");
        clearButton = new JButton("C");
        backButton = new JButton("←");
        equalsButton = new JButton("=");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = sqrtButton;
        functionButtons[5] = clearButton;
        functionButtons[6] = backButton;
        functionButtons[7] = equalsButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
        }

        panel.add(textField);
        panel.add(clearButton);
        panel.add(backButton);
        panel.add(sqrtButton);

        for (int i = 1; i <= 9; i++) {
            panel.add(numberButtons[i]);
        }

        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(equalsButton);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (isErrorState) {
                clearError();
            }
            
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText() + String.valueOf(i));
                }
            }

            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }

            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }

            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }

            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }

            if (e.getSource() == sqrtButton) {
                num1 = Double.parseDouble(textField.getText());
                if (num1 < 0) {
                    throw new ArithmeticException("Cannot calculate square root of a negative number");
                }
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
            }

            if (e.getSource() == equalsButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed");
                        }
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            }

            if (e.getSource() == clearButton) {
                textField.setText("");
            }

            if (e.getSource() == backButton) {
                String str = textField.getText();
                if (!str.isEmpty()) {
                    textField.setText(str.substring(0, str.length() - 1));
                }
            }
        } catch (NumberFormatException ex) {
            displayError("Invalid input. Please enter numbers only.");
        } catch (ArithmeticException ex) {
            displayError(ex.getMessage());
        }
    }
    
    private void displayError(String errorMessage) {
        isErrorState = true;
        textField.setText(errorMessage);
    }
    
    private void clearError() {
        isErrorState = false;
        textField.setText("");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
