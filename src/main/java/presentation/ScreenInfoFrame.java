/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.presentation;

import main.java.businessentity.BarOrder;
import main.java.businessentity.KitchenOrder;
import main.java.businessentity.RestaurantOrder;
import main.java.datastorage.BarOrdersDAO;
import main.java.datastorage.KitchenOrdersDAO;
import main.java.datastorage.RestaurantOrdersDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 23IVP4A2
 */
public class ScreenInfoFrame extends javax.swing.JFrame {

    public ScreenInfoFrame() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame("Informatie frame");
        buttonAcceptKitchen = new javax.swing.JButton();
        buttonDeliveredKitchen = new javax.swing.JButton();
        buttonAcceptBar = new javax.swing.JButton();
        buttonDeliveredBar = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonReceipt = new javax.swing.JButton();
        buttonReceiptPayed = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jFrame1.setVisible(true);
        buttonBarDetails = new javax.swing.JButton();
        buttonKitchenDetails = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        buttonLogOut.setText("Uitloggen");
        buttonLogOut.addActionListener((java.awt.event.ActionEvent evt) -> {
            jFrame1.dispose();
            jFrame1.setVisible(false);
            LoginFrame uiLoguit = new LoginFrame();
        });

        buttonAcceptBar.setText("Accepteren");
        buttonAcceptBar.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            AcceptFrameBar uiAcceptBar = new AcceptFrameBar();
        });
        buttonAcceptKitchen.setText("Accepteren");
        buttonAcceptKitchen.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            AcceptFrameKitchen uiAcceptKitchen = new AcceptFrameKitchen();
        });

        buttonDeliveredKitchen.setText("<html>Bezorgd<br>Melden</html>");
        buttonDeliveredKitchen.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            DeliveredFrameKitchen uiDeliveredKitchen = new DeliveredFrameKitchen();
        });

        buttonDeliveredBar.setText("<html>Bezorgd<br>Melden</html>");
        buttonDeliveredBar.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            DeliveredFrameBar uiDeliveredBar = new DeliveredFrameBar();
        });

        buttonReceiptPayed.setText("<html>Betaald<br>Melden</html>");
        buttonReceiptPayed.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            PayedFrame uiPayed = new PayedFrame();
        });

        buttonReceipt.setText("Accepteren");
        buttonReceipt.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            ReceiptFrame uiPayed = new ReceiptFrame();
        });

        buttonBarDetails.setText("Details");
        buttonBarDetails.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            DetailsFrameBar uiPayedKitchen = new DetailsFrameBar();
        });

        buttonKitchenDetails.setText("Details");
        buttonKitchenDetails.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
            jFrame1.dispose();
            jFrame1.setVisible(false);
            DetailsFrameKitchen uiPayedKitchen = new DetailsFrameKitchen();
        });

        // Tabel BarOrders
        BarOrdersDAO daoBar = new BarOrdersDAO();

        ArrayList<BarOrder> barOrders = daoBar.getAllOpenBarOrders(null);

        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[2];

        columnsName[0] = "Barorder ID";
        columnsName[1] = "Status";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[2];

        for (int i = 0; i < barOrders.size(); i++) {
            if (barOrders.get(i).getStatus() == 1 || barOrders.get(i).getStatus() == 2) {

                rowData[0] = barOrders.get(i).getBarOrderId();
                rowData[1] = barOrders.get(i).getStatusName();

                model.addRow(rowData);
            }
        }

        jTable1.setModel(model);

        // Tabel KitchenOrders
        KitchenOrdersDAO daoKitchen = new KitchenOrdersDAO();

        ArrayList<KitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);

        DefaultTableModel model2 = new DefaultTableModel();

        Object[] columnsName2 = new Object[2];

        columnsName2[0] = "Keukenorder ID";
        columnsName2[1] = "Status";

        model2.setColumnIdentifiers(columnsName2);

        Object[] rowData2 = new Object[2];

        for (int i = 0; i < kitchenOrders.size(); i++) {
            if (kitchenOrders.get(i).getStatus() == 2 || kitchenOrders.get(i).getStatus() == 3) {

                rowData2[0] = kitchenOrders.get(i).getKitchenOrderId();
                rowData2[1] = kitchenOrders.get(i).getStatusName();

                model2.addRow(rowData2);
            }
        }

        jTable2.setModel(model2);

        RestaurantOrdersDAO daoRestaurant = new RestaurantOrdersDAO();

        ArrayList<RestaurantOrder> restaurantOrders = daoRestaurant.getAllRestaurantOrders(null);

        DefaultTableModel model3 = new DefaultTableModel();

        Object[] columnsName3 = new Object[5];

        columnsName3[0] = "Restaurantorder ID";
        columnsName3[1] = "Tafelnummer";
        columnsName3[2] = "Datum";
        columnsName3[3] = "Tijd";
        columnsName3[4] = "Status";

        model3.setColumnIdentifiers(columnsName3);

        Object[] rowData3 = new Object[5];

        for (int i = 0; i < restaurantOrders.size(); i++) {

            rowData3[0] = restaurantOrders.get(i).getId();
            rowData3[1] = restaurantOrders.get(i).getTableNumber();
            rowData3[2] = restaurantOrders.get(i).getOrderDate();
            rowData3[3] = restaurantOrders.get(i).getOrderTime();
            rowData3[4] = restaurantOrders.get(i).getStatusName();

            model3.addRow(rowData3);
        }

        jTable3.setModel(model3);

        jScrollPane3.setViewportView(jTable3);

        jScrollPane1.setViewportView(jTable2);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonDeliveredKitchen, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(buttonAcceptKitchen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonKitchenDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonBarDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDeliveredBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAcceptBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(638, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(buttonReceiptPayed, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                .addComponent(buttonReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(462, 462, 462))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonLogOut)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(buttonAcceptKitchen)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(buttonDeliveredKitchen)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(buttonKitchenDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(buttonAcceptBar)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(buttonDeliveredBar)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(buttonBarDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(90, 90, 90)
                                        .addComponent(buttonReceipt)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonReceiptPayed)
                                        .addContainerGap(232, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>           

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonAcceptKitchen;
    private javax.swing.JButton buttonDeliveredKitchen;
    private javax.swing.JButton buttonAcceptBar;
    private javax.swing.JButton buttonDeliveredBar;
    private javax.swing.JButton buttonReceipt;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonReceiptPayed;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton buttonBarDetails;
    private javax.swing.JButton buttonKitchenDetails;
    private javax.swing.JTable jTable3;
    private javax.swing.JScrollPane jScrollPane3;

    // End of variables declaration                   
}
