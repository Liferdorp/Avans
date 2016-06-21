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
import main.java.businessentity.OpenBarOrder;
import main.java.datastorage.DatabaseConnection;
import main.java.datastorage.OpenBarOrdersDAO;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailsFrameBar {

    private JFrame frame = new JFrame("Details bar bestellingen");
    private JButton backButton = new JButton("Ga terug");
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jTable1 = new JTable();
    private final JLabel inputLabel1 = new JLabel("ID Bar Order");
    private JTextField input1 = new JTextField();
    private final JButton button = new JButton("Details");
    private final JLabel inputLabel3 = new JLabel("");

    public DetailsFrameBar() {

        inputLabel1.setBounds(850, 650, 180, 20);
        input1.setBounds(1000, 650, 180, 30);

        button.setBounds(1000, 700, 180, 30);
        jTable1.setBounds(600, 100, 600, 700);
        jScrollPane1.setBounds(600, 100, 800, 500);
        backButton.setBounds(1700, 5, 180, 30);
        frame.getContentPane().add(backButton);

        frame.getContentPane().add(button);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);
        jScrollPane1.setViewportView(jTable1);
        frame.getContentPane().add(inputLabel3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ActionListener backButtonListner = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
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

                        // Tabel BarOrders
                        OpenBarOrdersDAO daoBar = new OpenBarOrdersDAO();

                        ArrayList<OpenBarOrder> barOrders = daoBar.getAllOpenBarOrders(null);

                        DefaultTableModel model = new DefaultTableModel();

                        Object[] columnsName = new Object[5];

                        columnsName[0] = "Barorder ID";
                        columnsName[1] = "Drankje";
                        columnsName[2] = "Tafel Nummer";
                        columnsName[3] = "Hoeveelheid";
                        columnsName[4] = "Status";

                        model.setColumnIdentifiers(columnsName);

                        Object[] rowData = new Object[5];

                        for (int i = 0; i < barOrders.size(); i++) {

                            if (orderID == barOrders.get(i).getBarOrderId()) {
                                rowData[0] = barOrders.get(i).getBarOrderId();
                                rowData[1] = barOrders.get(i).getDrinkName();
                                rowData[2] = barOrders.get(i).getTableNr();
                                rowData[3] = barOrders.get(i).getQuantity();
                                rowData[4] = barOrders.get(i).getStatusName();

                                model.addRow(rowData);
                            }
                        }

                        jTable1.setModel(model);
                        frame.getContentPane().add(jScrollPane1);
                        frame.getContentPane().add(inputLabel3);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
