import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput;
    private double operand1, operand2, result;
    private String operator;
    private boolean startNewInput;

    public Calculator() {
        currentInput = new StringBuilder();
          operand1 = operand2 = result = 0;
           operator = "";
          startNewInput = true;

        
        setTitle("Calculator");
         setSize(400, 500);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               setLayout(new BorderLayout());

      
        display = new JTextField();
           display.setFont(new Font("Arial", Font.BOLD, 24));
         display.setHorizontalAlignment(SwingConstants.RIGHT);
         display.setEditable(false);
           add(display, BorderLayout.NORTH);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "⌫", "√", "%"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
              button.setFont(new Font("Arial", Font.BOLD, 20));
               button.addActionListener(this);
             panel.add(button);
        }

         add(panel, BorderLayout.CENTER);

        
          setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.equals("C")) {
                clear();
            } else if (command.equals("⌫")) {
                backspace();
            } else if (command.equals("=")) {
                calculate();
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || 
                       command.equals("/") || command.equals("%") || command.equals("√")) {
                setOperator(command);
            } else {
                appendToInput(command);
            }
        } catch (ArithmeticException ex) {
            display.setText("Error: " + ex.getMessage());
            startNewInput = true;
        } catch (Exception ex) {
            display.setText("Error: Invalid input");
            startNewInput = true;
        }
    }

    private void clear() 
    {
        currentInput.setLength(0);
          operand1 = operand2 = result = 0;
        operator = "";
         display.setText("");
        startNewInput = true;
    }

    private void backspace() 
    {
        if (currentInput.length() > 0) {
            currentInput.setLength(currentInput.length() - 1);
               display.setText(currentInput.toString());
        }
    }

    private void appendToInput(String text)
     {
        if (startNewInput) {
                 currentInput.setLength(0);
             startNewInput = false;
        }
        currentInput.append(text);
          display.setText(currentInput.toString());
    }

    private void setOperator(String op) {
        if (currentInput.length() > 0) {
             operand1 = Double.parseDouble(currentInput.toString());
            operator = op;
              currentInput.setLength(0);
             display.setText("");
        } else if (op.equals("√")) {
             operand1 = 0;
              operator = op;
            calculate();
        }
    }

    private void calculate() {
        if (operator.isEmpty()) return;

         if (currentInput.length() > 0) {
            operand2 = Double.parseDouble(currentInput.toString());
        }

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) throw new ArithmeticException("Cannot divide by zero");
                result = operand1 / operand2;
                break;
            case "%":
                if (operand2 == 0) throw new ArithmeticException("Cannot divide by zero");
                result = operand1 % operand2;
                break;
            case "√":
                if (operand1 < 0) throw new ArithmeticException("Cannot take square root of negative number");
                result = Math.sqrt(operand1);
                break;
        }

        display.setText(String.valueOf(result));
          startNewInput = true;
           operator = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
