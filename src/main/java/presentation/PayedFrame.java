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
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.businessentity.Employee;
import main.java.businessentity.UpdateStatus;
import main.java.businesslogic.SystemManager;
import main.java.datastorage.EmployeeDAO;

public class PayedFrame {

    private final JFrame frame = new JFrame("Betaald melden ");
    private final JButton backButton = new JButton("Ga terug");
    private final JLabel inputLabel1 = new JLabel("ID Restuarant Order");
    private final JTextField input1 = new JTextField();
    private final JButton button = new JButton("Betaald Melden");
    private final JLabel inputLabel3 = new JLabel("");

    public PayedFrame() {

        inputLabel1.setBounds(850, 405, 180, 20);
        input1.setBounds(1000, 400, 180, 30);

        button.setBounds(1000, 520, 180, 30);
        backButton.setBounds(1700, 5, 180, 30);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(button);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);

        String[] rowData = new String[8];

        EmployeeDAO daoEmployee = new EmployeeDAO();

        ArrayList<Employee> employees = daoEmployee.getAllEmployees(null);

        for (int i = 0; i < employees.size(); i++) {

            rowData[i] = employees.get(i).getFirstName();
        }

        final JComboBox<String> cb = new JComboBox<>(rowData);

        cb.setBounds(1000, 450, 180, 30);
        frame.add(cb);

        frame.getContentPane().add(inputLabel3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        ActionListener backButtonListner = (ActionEvent ae) -> {
            frame.dispose();
            frame.setVisible(false);
            ScreenInfoFrame ui = new ScreenInfoFrame();
            ui.setVisible(true);
        };

        ActionListener myActionListener = (ActionEvent ae) -> {
            try {
                int ID = Integer.parseInt(input1.getText());
                SystemManager manager = new SystemManager();
                if (ID > 0) {
                    UpdateStatus updateStatusSQL = new UpdateStatus();
                    String firstName = (String) cb.getSelectedItem();
                    ResultSet rs2 = manager.stmt.executeQuery(updateStatusSQL.getEmployeeId(firstName));
                    while (rs2.next()) {
                        int employeeId = rs2.getInt("id");
                        
                        String statement = updateStatusSQL.sqlPayed(employeeId, ID);
                        int rs3 = manager.stmt.executeUpdate(statement);
                        
                        manager.con.close();
                        manager.stmt.close();
                        frame.dispose();
                        frame.setVisible(false);
                        ScreenInfoFrame ui = new ScreenInfoFrame();
                        ui.setVisible(true);
                        
                    }

                }
            } catch (NumberFormatException k ) {
                JOptionPane.showMessageDialog(null,"       Geen geldig getal");
            } catch (SQLException k) {
                JOptionPane.showMessageDialog(null, "          Status Geupdate");
            }
        };
        backButton.addActionListener(backButtonListner);
        button.addActionListener(myActionListener);
        input1.addActionListener(myActionListener);
    }

}
