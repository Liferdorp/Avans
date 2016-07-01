/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.presentation;

/**
 *
 * @author Jessie den Ridder
 */
import main.java.businesslogic.SystemManager;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginFrame {

    private JFrame frame = new JFrame("Login");
    private final JLabel inputLabel1 = new JLabel("Gebruikersnaam");
    private final JLabel inputLabel2 = new JLabel("Wachtwoord");
    private JTextField input1 = new JTextField();
    private JPasswordField input2 = new JPasswordField();
    private JTextField output = new JTextField();
    private final JButton button = new JButton("Login");
    private final JLabel inputLabel3 = new JLabel("");

    public LoginFrame() {

        inputLabel1.setBounds(850, 405, 180, 20);
        input1.setBounds(1000, 400, 180, 30);

        inputLabel2.setBounds(850, 455, 180, 20);
        input2.setBounds(1000, 450, 180, 30);

        button.setBounds(1000, 520, 180, 30);
        frame.getContentPane().add(button);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);
        frame.getContentPane().add(input2);
        frame.getContentPane().add(inputLabel2);
        frame.getContentPane().add(inputLabel3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ActionListener myActionListener = (ActionEvent ae) -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://145.48.6.147:3306/23ivp4a", "hha2_1user", "hha2pass");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SystemManager.sqlLogIn);
                String user = input1.getText();
                
                String pwd = input2.getText();
                while (rs.next()) {
                    String uname = rs.getString("userName");
                    //Username is the coloumn name in the database table
                    String password = rs.getString("password");
                    if ((user.equals(uname)) && (pwd.equals(password))) {
                        frame.setVisible(false);
                        frame.dispose();
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                    } else {
                        output.setBounds(990, 600, 205, 30);
                        output.setText("Gebruikersnaam of wachtwoord fout");
                        frame.getContentPane().add(output);
                        frame.getContentPane().add(inputLabel3);
                    }
                }
            } catch (ClassNotFoundException | SQLException k) {
                JOptionPane.showMessageDialog(null, k.getMessage());
            }
        };
        button.addActionListener(myActionListener);
        input2.addActionListener(myActionListener);
        input1.addActionListener(myActionListener);
        frame.setVisible(true);
    }

}
