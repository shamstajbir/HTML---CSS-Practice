import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, sqrtButton, clearButton, backButton, equalsButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    New_Calculator() {
        setTitle("New_Calculator");
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
            textField.setText(str.substring(0, str.length() - 1));
        }
    }

    public static void main(String[] args) {
        new New_Calculator();
    }
}
