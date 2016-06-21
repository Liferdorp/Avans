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
import main.java.businessentity.OpenKitchenOrder;
import main.java.datastorage.DatabaseConnection;
import main.java.datastorage.OpenKitchenOrdersDAO;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailsFrameKitchen {

    private JFrame frame = new JFrame("Details keuken bestellingen");
    private JButton backButton = new JButton("Ga terug");
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jTable1 = new JTable();
    private final JLabel inputLabel1 = new JLabel("ID Keuken Order");
    private JTextField input1 = new JTextField();
    private final JButton button = new JButton("Details");
    private final JLabel inputLabel3 = new JLabel("");

    public DetailsFrameKitchen() {

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
                        // Tabel KitchenOrders
                        OpenKitchenOrdersDAO daoKitchen = new OpenKitchenOrdersDAO();

                        ArrayList<OpenKitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);

                        DefaultTableModel model2 = new DefaultTableModel();

                        Object[] columnsName2 = new Object[5];

                        columnsName2[0] = "Keukenorder ID";
                        columnsName2[1] = "Tafelnummer";
                        columnsName2[2] = "Gerecht";
                        columnsName2[3] = "Hoeveelheid";
                        columnsName2[4] = "Status";

                        model2.setColumnIdentifiers(columnsName2);

                        Object[] rowData2 = new Object[5];

                        for (int i = 0; i < kitchenOrders.size(); i++) {
                            if (orderID == kitchenOrders.get(i).getKitchenOrderId()) {
                                rowData2[0] = kitchenOrders.get(i).getKitchenOrderId();
                                rowData2[1] = kitchenOrders.get(i).getTableNr();
                                rowData2[2] = kitchenOrders.get(i).getDishName();
                                rowData2[3] = kitchenOrders.get(i).getQuantity();
                                rowData2[4] = kitchenOrders.get(i).getStatusName();

                                model2.addRow(rowData2);
                            }
                        }

                        jTable1.setModel(model2);
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
