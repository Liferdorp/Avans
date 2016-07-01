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
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import main.java.businessentity.BarOrder;
import main.java.businessentity.KitchenOrder;
import main.java.datastorage.BarOrdersDAO;
import main.java.datastorage.KitchenOrdersDAO;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.businessentity.Employee;
import main.java.businessentity.Receipt;
import main.java.businessentity.RestaurantOrder;
import main.java.businesslogic.SystemManager;
import main.java.datastorage.EmployeeDAO;

public class ReceiptFrame {

    private JFrame frame = new JFrame("Bon");
    private final JButton backButton = new JButton("Ga terug");
    private JTextPane jTextPane = new JTextPane();
    private final JLabel inputLabel1 = new JLabel("ID Restaurant Order");
    private final JTextField input1 = new JTextField();
    private final JButton showReceiptButton = new JButton("Laat bon zien");
    private final JButton printReceiptButton = new JButton("Print bon");
    private final JLabel inputLabel3 = new JLabel("");

    public ReceiptFrame() {

        inputLabel1.setBounds(750, 850, 180, 20);
        input1.setBounds(900, 850, 180, 30);
        showReceiptButton.setBounds(750, 900, 180, 30);
        printReceiptButton.setBounds(950, 900, 180, 30);
        jTextPane.setBounds(600, 100, 800, 700);
        backButton.setBounds(1700, 5, 180, 30);
        frame.getContentPane().add(backButton);

        String[] rowData = new String[8];

        EmployeeDAO daoEmployee = new EmployeeDAO();

        ArrayList<Employee> employees = daoEmployee.getAllEmployees(null);

        for (int i = 0; i < employees.size(); i++) {

            rowData[i] = employees.get(i).getFirstName();
        }

        final JComboBox<String> cb = new JComboBox<>(rowData);

        cb.setBounds(1150, 850, 180, 30);
        frame.add(cb);

        frame.getContentPane().add(showReceiptButton);
        frame.getContentPane().add(printReceiptButton);
        frame.getContentPane().add(inputLabel1);
        frame.getContentPane().add(input1);
        frame.getContentPane().add(jTextPane);
        frame.setFont(new Font("monospaced", Font.PLAIN, 15));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ActionListener backButtonListner = (ActionEvent) -> {
            frame.dispose();
            frame.setVisible(false);
            ScreenInfoFrame ui = new ScreenInfoFrame();
            ui.setVisible(true);
        };
        RestaurantOrder sqlRestaurantOrder = new RestaurantOrder();
        ActionListener printReceiptListner;
        printReceiptListner = (ActionEvent) -> {

            try {
                int ID = Integer.parseInt(input1.getText());
                SystemManager manager = new SystemManager();
                ResultSet rs = manager.stmt.executeQuery(sqlRestaurantOrder.setIdSql(ID));

                while (rs.next()) {

                    double totalPrice = rs.getDouble("sumprice");
                    if (ID > 0) {
                        Receipt receiptSql = new Receipt();
                        String firstName = (String) cb.getSelectedItem();
                        String checkoutDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                        ResultSet rs2 = manager.stmt.executeQuery(receiptSql.getEmployeeId(firstName));
                        while (rs2.next()) {
                            int employeeId = rs2.getInt("id");

                            Receipt receiptSql2 = new Receipt();
                            String statement = receiptSql2.SetStatusReceipt(employeeId, checkoutDate, ID, totalPrice);
                            int rs3 = manager.stmt.executeUpdate(statement);
                            // step 1
                            Document document = new Document();
                            String filename = "Factuur order " + ID + ".pdf";
                            // step 2
                            PdfWriter.getInstance(document, new FileOutputStream(filename));
                            // step 3
                            document.open();
                            // step 4
                            document.add(new Paragraph(" Factuur van order nummer: " + ID + "\n"));
                            document.add(new Paragraph("\n"));
                            document.add(new Paragraph("Prijs per product                     "
                                    + "Hoeveelheid                                 "
                                    + "Product\n"));
                            document.add(new Paragraph("=====================  ========================  =====================\n"));

                            BarOrdersDAO daoBar = new BarOrdersDAO();

                            ArrayList<BarOrder> barOrders = daoBar.getAllOpenBarOrders(null);

                            for (int i = 0; i < barOrders.size(); i++) {
                                if (ID == barOrders.get(i).getRestaurantOrder()) {

                                    document.add(new Paragraph("" + barOrders.get(i).getDrinkPrice() + "                                         "
                                            + "" + barOrders.get(i).getQuantity() + "                                                   "
                                            + "" + barOrders.get(i).getDrinkName() + "\n"));

                                }
                            }
                            
                            KitchenOrdersDAO daoKitchen = new KitchenOrdersDAO();

                            ArrayList<KitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);

                            for (int i = 0; i < kitchenOrders.size(); i++) {
                                if (ID == kitchenOrders.get(i).getRestaurantOrderId()) {

                                    document.add(new Paragraph("" + kitchenOrders.get(i).getKitchenOrderPrice() + "                                         "
                                            + "" + kitchenOrders.get(i).getQuantity() + "                                                   "
                                            + "" + kitchenOrders.get(i).getDishName() + "\n"));

                                }
                            }
                            
                            document.add(new Paragraph("\n"));
                            document.add(new Paragraph("De totaalprijs van de order: €" + totalPrice + ""));
                            if (totalPrice >= 200) {
                                document.add(new Paragraph("\nOmdat dit bedrag hoger dan €200,- is, zal hier 10% vanaf gehaald worden. De prijs die u betaalt is: €"));
                                document.add(new Paragraph("" + totalPrice * 0.9 + ""));
                            }

                            // step 5
                            document.close();
                            manager.con.close();
                            manager.stmt.close();
                            frame.dispose();
                            frame.setVisible(false);
                            ScreenInfoFrame ui = new ScreenInfoFrame();
                            ui.setVisible(true);

                        }

                    }
                }

            } catch (NumberFormatException k) {
                JOptionPane.showMessageDialog(null, "       Geen geldig getal");
            } catch (SQLException k) {
                JOptionPane.showMessageDialog(null, "          Bon geprint");
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(ReceiptFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        ActionListener myActionListener;
        myActionListener = (ActionEvent) -> {
            try {
                int ID = Integer.parseInt(input1.getText());
                SystemManager manager = new SystemManager();
                ResultSet rs = manager.stmt.executeQuery(sqlRestaurantOrder.setIdSql(ID));

                while (rs.next()) {

                    double totalPrice = rs.getDouble("sumprice");
                    if (ID > 0) {
                        String overview = "";
                        overview += " Factuur van order nummer: " + ID + "\n";
                        overview += "\n";
                        overview += " Prijs per product                                               "
                                + "Hoeveelheid                                                      "
                                + "Product  \n";
                        overview += " ================================  ================================  ================================\n";

                        BarOrdersDAO daoBar = new BarOrdersDAO();

                        ArrayList<BarOrder> barOrders = daoBar.getAllOpenBarOrders(null);

                        for (int i = 0; i < barOrders.size(); i++) {
                            if (ID == barOrders.get(i).getRestaurantOrder()) {

                                overview += "" + barOrders.get(i).getDrinkPrice() + "                                                                     "
                                        + "" + barOrders.get(i).getQuantity() + "                                                                            "
                                        + "" + barOrders.get(i).getDrinkName() + "\n";

                            }
                        }
                        KitchenOrdersDAO daoKitchen = new KitchenOrdersDAO();

                        ArrayList<KitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);

                        for (int i = 0; i < kitchenOrders.size(); i++) {
                            if (ID == kitchenOrders.get(i).getRestaurantOrderId()) {

                                overview += "" + kitchenOrders.get(i).getKitchenOrderPrice() + "                                                                     "
                                        + "" + kitchenOrders.get(i).getQuantity() + "                                                                            "
                                        + "" + kitchenOrders.get(i).getDishName() + "\n";

                            }
                        }
                        overview += "\n";
                        overview += "De totaalprijs van de order: €" + totalPrice + "";
                        if (totalPrice >= 200) {
                            overview += "\nOmdat dit bedrag hoger dan €200,- is, zal hier 10% vanaf gehaald worden. De prijs die u betaalt is: €";
                            overview += (totalPrice * 0.9);
                        }

                        jTextPane.setText(overview);

                    }
                }
            } catch (NumberFormatException k) {
                JOptionPane.showMessageDialog(null, "       Geen geldig getal");
            } catch (SQLException k) {
                JOptionPane.showMessageDialog(null, k.getMessage());
            }
        };

        backButton.addActionListener(backButtonListner);
        frame.getContentPane().add(inputLabel3);
        printReceiptButton.addActionListener(printReceiptListner);
        showReceiptButton.addActionListener(myActionListener);
        input1.addActionListener(myActionListener);
        frame.setVisible(true);

    }

}
