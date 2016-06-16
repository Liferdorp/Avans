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
import javax.swing.*;
import java.awt.event.*;

public class DeliveredFrameBar {

    private JFrame frame = new JFrame("Bezorgd melden bar bestellingen");
    private JButton backButton = new JButton("Ga terug");
    private final JLabel inputLabel1 = new JLabel("ID Bar Order");
    private JTextField input1 = new JTextField();
    private final JButton button = new JButton("Bezorgd Melden");
    private final JLabel inputLabel3 = new JLabel("");

    public DeliveredFrameBar() {

        inputLabel1.setBounds(850, 405, 180, 20);
        input1.setBounds(1000, 400, 180, 30);

        button.setBounds(1000, 520, 180, 30);
        backButton.setBounds(1700, 5, 180, 30);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(button);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);

        String[] choices = {"Patrick", "Frans", "Roger", "Evert Jan", "Maurice", "Ger"};

        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setBounds(1000, 450, 180, 30);
        frame.add(cb);

        frame.getContentPane().add(inputLabel3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

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

                String firstName = (String) cb.getSelectedItem();
                System.out.println(firstName);
                System.out.println(orderID);
                if (firstName == "Patrick") {
                    int employeeId = 10;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
                if (firstName == "Frans") {
                    int employeeId = 9;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
                if (firstName == "Maurice") {
                    int employeeId = 11;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
                if (firstName == "Ger") {
                    int employeeId = 13;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
                if (firstName == "Evert Jan") {
                    int employeeId = 5;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
                if (firstName == "Roger") {
                    int employeeId = 4;
                    DatabaseConnection connection = new DatabaseConnection();
                    if (connection.openConnection()) {
                        // If a connection was successfully setup, execute the SELECT statement.
                        boolean resultset = true;
                        resultset = connection.executeSqlDmlStatement("UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + orderID + "' ;");
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    }

                }
            }
        };
        backButton.addActionListener(backButtonListner);
        button.addActionListener(myActionListener);
        input1.addActionListener(myActionListener);
    }

}
