import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private StringBuilder input;
    private double result;
    private String operator;

    public Calculator() {
             input = new StringBuilder();
         result = 0;
            operator = "";

        
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        
        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "+", "=", 
            "C", "←", "mod", "sqrt"};

        for (String label : buttonLabels) {
              JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
               button.addActionListener(this);
            panel.add(button);}
        add(panel, BorderLayout.CENTER);
         setVisible(true);}

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C":
                    input.setLength(0);
                    display.setText("");
                     result = 0;
                    operator = "";
                    break;
                case "←":
                    if (input.length() > 0) {
                        input.setLength(input.length() - 1);
                        display.setText(input.toString());
                    }
                    break;
                case "=":
                    if (!input.toString().isEmpty() && !operator.isEmpty()) {
                        result = calculate(result, Double.parseDouble(input.toString()), operator);
                        display.setText(String.valueOf(result));
                        input.setLength(0);
                        operator = "";}
                    break;
                case "sqrt":
                    if (!input.toString().isEmpty()) {
                        result = Math.sqrt(Double.parseDouble(input.toString()));
                        display.setText(String.valueOf(result));
                        input.setLength(0);}
                    break;
                case "+", "-", "*", "/", "mod":
                    if (!input.toString().isEmpty()) {
                        result = Double.parseDouble(input.toString());
                        operator = command;
                        input.setLength(0);}
                    break;
                default:
                    input.append(command);
                    display.setText(input.toString());
                    break;}} 
                    catch (Exception ex) {
            display.setText("Error");
            input.setLength(0);
            operator = "";}}

    private double calculate(double a, double b, String operator) throws ArithmeticException {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                yield a / b;}
            case "mod" -> a % b;
            default -> throw new ArithmeticException("Unknown operator");};}

    public static void main(String[] args) {
        new Calculator();
    }
}