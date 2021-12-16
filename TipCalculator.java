

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TipCalculator extends JFrame{
    //Creating local variables for the program
    double bill, totalAmount;
    JDialog  split, tip;
    JTextField enterBill, enterNumPeople, enterTip;
    JLabel whatBill, numPeople, total, tipPerson, totalTip;
    JButton calculate;
    JFrame frame;
    BoxLayout boxlayoutOne, boxlayoutTwo;
    public static void main(String[] args) {
        new TipCalculator();
    }

   public  TipCalculator(){
       frame = new JFrame("Calculator");
       //Setting the frame size
       frame.setSize(400, 300);
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension dim = tk.getScreenSize();
       int xPos = (dim.width / 2) - (this.getWidth() / 2);
       int yPos = (dim.height / 2) - (this.getHeight() / 2);

       frame.setLocation(xPos, yPos);
       // Define if the user can resize the frame (true by default)
       frame.setResizable(false);
       // Define how the frame exits
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // Setting the title for the frame
       frame.setTitle("Tip Calculator");

       JPanel panelOne = new JPanel();

       JPanel panelTwo = new JPanel();
       //Creating a label to let the user know whats going on
       JLabel options = new JLabel("Which of the following would you like to calculate: ");
       //Setting the appropriate layout for the panel
       panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.Y_AXIS));
       panelTwo.add(options);
       panelOne.add(panelTwo);

       //Setting a layout for the panel
       JPanel panelThree = new JPanel();
       Border borderBox = BorderFactory.createTitledBorder("Choose one:");
       panelThree.setBorder(borderBox);
       panelThree.setLayout(new BoxLayout(panelThree, BoxLayout.Y_AXIS));

       //Creating buttons for user to decide which options they would like to choose
       JRadioButton split = new JRadioButton("Split bill");
       JRadioButton tip =new JRadioButton("Tip");
       JButton click = new JButton("Submit");
       panelThree.add(split);
       panelThree.add(tip);
       panelThree.add(click);


       ButtonGroup group = new ButtonGroup();
       group.add(split);
       group.add(tip);

       //Once the user clicks submit, the following methods will execute
       click.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if(split.isSelected()){
                   splitBill();
               } else if(tip.isSelected()){
                   tipBill();
               }
           }

       });
       panelOne.add(panelThree);
       frame.add(panelOne);
       frame.setVisible(true);

   }

    public void tipBill() {
        //Creating a pop-up dialog for when the user decides to tip
        tip = new JDialog(frame, "dialog Box");

        //Setting the size of the dialog
        tip.setSize(300, 300);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        tip.setLocation(xPos, yPos);

        JPanel tipBill = new JPanel();

        //Setting a box layout along with setting the bounds of it
        boxlayoutOne = new BoxLayout(tipBill, BoxLayout.Y_AXIS);
        // to set the box layout
        tipBill.setLayout(boxlayoutOne);
        // Set border for the panel
        tipBill.setBorder(new EmptyBorder(new Insets(100, 150, 100, 150)));

        // Creating a label for the bill
        whatBill = new JLabel("Whats the Bill? ");
        tipBill.add(whatBill);

        // Creating a text field for user to enter the bill amount
        enterBill = new JTextField("", 5);
        tipBill.add(enterBill);

        // Creating label for percentage
        tipPerson = new JLabel("Enter percentage ");
        tipBill.add(tipPerson);

        //Creating a text field for user to enter the percentage tip
        enterTip = new JTextField("", 5);
        tipBill.add(enterTip);

        // Creating a button for calculating
        calculate = new JButton("Calculate");
        tipBill.add(calculate);

        // Creating label for the total tip
        totalTip = new JLabel("Total Tip: ");
        tipBill.add(totalTip);

        // Creating label for the total amount
        total = new JLabel("Total amount: ");
        tipBill.add(total);

        tip.add(tipBill);
        // Calculate the percentage of the tip
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bill = Double.parseDouble(enterBill.getText());
                double percent  = Double.parseDouble(enterTip.getText());
                double tipAmount = bill * (percent / 100);
                totalAmount = bill + tipAmount;
                //Updates both the totalTip and total with the new calculated answers
                totalTip.setText("Tip amount: $" + String.format("%.2f", tipAmount));
                total.setText("Total amount: $" + String.format("%.2f", totalAmount));

            }
        });
        tip.pack();
        tip.setVisible(true);
    }

    public void splitBill (){
        //Creating a pop-up dialog for when the user decides to split the bill
        split = new JDialog(frame, "Split the Bill");

        //Setting the size of the dialog
        split.setSize(300, 300);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dimen = tool.getScreenSize();
        int xPos = (dimen.width / 2) - (this.getWidth() / 2);
        int yPos = (dimen.height / 2) - (this.getHeight() / 2);
        split.setLocation(xPos, yPos);

        // Creating a panel
        JPanel splitTheBill = new JPanel();

        //Setting a box layout along with setting the bounds of it
        boxlayoutTwo = new BoxLayout(splitTheBill, BoxLayout.Y_AXIS);
        splitTheBill.setLayout(boxlayoutTwo);
        splitTheBill.setBorder(new EmptyBorder(new Insets(100, 150, 100, 150)));

        // Creating label for the bill
        whatBill = new JLabel("Whats the Bill? ");
        //whatBill.setText("Whats the Bill? ");
        splitTheBill.add(whatBill);

        // Creating  text field for user to enter the amount of the bill
        enterBill = new JTextField("", 5);
        splitTheBill.add(enterBill);

        // Creating label for splitting
        numPeople = new JLabel("How many are splitting? ");
        splitTheBill.add(numPeople);

        // Creating text field for user to enter the amount of people splitting
        enterNumPeople = new JTextField("", 5);
        splitTheBill.add(enterNumPeople);

        // Creating a button for calculate
        calculate = new JButton("Calculate");
        splitTheBill.add(calculate);

        // Creating label for total amount
        total = new JLabel("Total amount: ");
        splitTheBill.add(total);
        split.add(splitTheBill);

        //Will calculate the bill by the amount of people splitting
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bill = Double.parseDouble(enterBill.getText());
                double people = Double.parseDouble(enterNumPeople.getText());
                totalAmount = bill / people;
                //Updates the total's text with the new amount
                total.setText("Total amount for " + (int)people + " is: $" + String.format("%.2f", totalAmount) );
            }
        });
        split.pack();
        split.setVisible(true);
    }
}
