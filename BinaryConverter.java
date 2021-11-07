package BinaryDecimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryConverter extends JFrame {

    JLabel binLabel = new JLabel("Binary: ",SwingConstants.CENTER);
    JLabel decLabel = new JLabel("Decimal: ",SwingConstants.CENTER);
    JTextField binTextField = new JTextField();
    JTextField decTextField = new JTextField();

    BinaryConverter(){
        this.setLayout(new GridLayout(2, 2));
        this.setSize(200, 100);
        this.setLocationRelativeTo(null); // start in center of screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set fonts
        binLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
        decLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));

        // binary
        this.add(binLabel);
        this.add(binTextField);
        binTextField.addActionListener(new BinaryListener());

        //decimal
        this.add(decLabel);
        this.add(decTextField);
        decTextField.addActionListener(new DecimalListener());

        this.setVisible(true);
    }

    class BinaryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = 0;
            int base = 1;
            int temp;

            int binaryNum = Integer.parseInt(binTextField.getText());
            while(binaryNum > 0) {
                temp = binaryNum%10;
                binaryNum = binaryNum/10;
                result = result + temp*base;
                base = base * 2;
            }
            decTextField.setText(Integer.toString(result));
        }
    }

    class DecimalListener implements ActionListener {
        String result;
        @Override
        public void actionPerformed(ActionEvent e) {
            String result = "";
            int decimalNum = Integer.parseInt(decTextField.getText());
            while(decimalNum > 0) {
                if(decimalNum%2 == 0) {
                    result = result + '0';
                } else {
                    result = result + decimalNum%2;
                }
                decimalNum = decimalNum/2;
            }
            binTextField.setText(new StringBuilder(result).reverse().toString());
        }
    }
}
