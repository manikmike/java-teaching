import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame
{
   JTextField display;
   JPanel buttons;
   JButton[] number = new JButton[10];
   JButton plus, minus, times, dividedBy;
   JButton clear, plusMinus, equals, point;
   JButton store, recall;

   public Calculator()
   {
      super("Calculator");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(320, 480);
      this.setResizable(false);
      
      display = new JTextField("12345");
      display.setHorizontalAlignment(JTextField.RIGHT);
      Font f = new Font("Courier", Font.BOLD, 48);
      display.setFont(f);
      display.setFocusable(false);
      
      GridLayout layout = new GridLayout(5,4,5,5);
      buttons = new JPanel(layout);
      
      clear = makeButton("C");
      store = makeButton("STO");
      recall = makeButton("RCL");
      minus = makeButton("-");
      
      number[7] = makeButton("7");
      number[8] = makeButton("8");
      number[9] = makeButton("9");
      dividedBy = makeButton("/");
     
      number[4] = makeButton("4");
      number[5] = makeButton("5");
      number[6] = makeButton("6");
      times = makeButton("*");;
      
      number[1] = makeButton("1");
      number[2] = makeButton("2");
      number[3] = makeButton("3");
      minus = makeButton("*");
      
      number[0] = makeButton("0");
      point = makeButton(".");
      plusMinus = makeButton("+/-");
      equals = makeButton("=");

      this.add(display, BorderLayout.NORTH);
      this.add(buttons, BorderLayout.CENTER);
      
      this.setVisible(true);
   }
   
   private JButton makeButton(String label)
   {
      JButton button = new JButton(label);
      Font f = new Font("Courier", Font.BOLD, 18);
      button.setFont(f);
      button.setFocusable(false);
      buttons.add(button);
      return button;
   }
   
   public static void main(String[] args)
   {
      Calculator c = new Calculator();
   }
}

