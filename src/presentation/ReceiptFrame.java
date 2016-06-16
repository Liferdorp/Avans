/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Jessie den Ridder
 */
import datastorage.DatabaseConnection;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class ReceiptFrame {

    private JFrame frame = new JFrame("Bon");
    private JButton backButton = new JButton("Ga terug");
    private JTextPane jTextPane = new JTextPane();
    private final JLabel inputLabel1 = new JLabel("ID Restaurant Order");
    private JTextField input1 = new JTextField();
    private final JButton button = new JButton("Bon");
    private final JLabel inputLabel3 = new JLabel("");

    public ReceiptFrame() {

        inputLabel1.setBounds(850, 850, 180, 20);
        input1.setBounds(1000, 850, 180, 30);
        button.setBounds(1000, 900, 180, 30);
        jTextPane.setBounds(600, 100, 800, 700);
        backButton.setBounds(1700, 5, 180, 30);
        frame.getContentPane().add(backButton);

        frame.getContentPane().add(button);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);
        frame.getContentPane().add(jTextPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ActionListener backButtonListner = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                frame.setVisible(false);
                ScreenInfoFrame ui = new ScreenInfoFrame();
                ui.setVisible(true);
            }
        };

        ActionListener myActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ID = input1.getText();
                int orderID = Integer.parseInt(ID);
                if (true) {
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        jTextPane.setFont(new Font("monospaced", Font.PLAIN, 15));
                        jTextPane.setContentType("text/html");
                        
                        jTextPane.setText("<html><u><i><b>lelelelelelelelswag swag swag swag swag swag swag swag swag swag </i></u></b><hr></html>");
                        
                    }

                }

            }

        };
        backButton.addActionListener(backButtonListner);
        frame.getContentPane().add(inputLabel3);
        button.addActionListener(myActionListener);
        input1.addActionListener(myActionListener);
        frame.setVisible(true);

    }

}
