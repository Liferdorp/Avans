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
import businessentity.OpenBarOrder;
import businessentity.OpenKitchenOrder;
import datastorage.DatabaseConnection;
import datastorage.OpenBarOrdersDAO;
import datastorage.OpenKitchenOrdersDAO;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReceiptFrame {

    private JFrame frame = new JFrame("Bon");
    private JButton backButton = new JButton("Ga terug");
    private JTextPane jTextPane = new JTextPane();
    private final JLabel inputLabel1 = new JLabel("ID Restaurant Order");
    static private JTextField input1 = new JTextField();
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

        String[] choices = {"Jessie", "Mark", "Bas", "Sean"};

        final JComboBox<String> cb = new JComboBox<String>(choices);

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

        ActionListener backButtonListner = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                frame.setVisible(false);
                ScreenInfoFrame ui = new ScreenInfoFrame();
                ui.setVisible(true);
            }
        };

        ActionListener printReceiptListner = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ID = input1.getText();
                String sql = "SELECT sum((barorder_drink.quantity * drink.price)) + sum((kitchenorder_dish.quantity * dish.price)) as sumprice, drink.price"
                        + " FROM barorder, barorder_drink, drink, kitchenorder, kitchenorder_dish, dish, restaurantorder"
                        + " WHERE barorder.restaurantOrderId = restaurantorder.id"
                        + " AND kitchenorder.restaurantOrderId = restaurantorder.id"
                        + " AND barorder_drink.barorderId = barorder.id"
                        + " AND barorder_drink.drinkId = drink.id"
                        + " AND kitchenorder_dish.kitchenOrderId = kitchenorder.id"
                        + " AND kitchenorder_dish.dishId = dish.id"
                        + " AND restaurantorder.id ='" + ID + "' ;";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://145.48.6.147:3306/23ivp4a", "hha2_1user", "hha2pass");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()) {

                        double totalPrice = rs.getDouble("sumprice");
                        int orderID = Integer.parseInt(ID);
                        if (orderID > 0) {
                            String firstName = (String) cb.getSelectedItem();

                            if (firstName == "Jessie") {
                                int employeeId = 36;
                                String checkoutDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                                DatabaseConnection connection = new DatabaseConnection();
                                if (connection.openConnection()) {
                                    // If a connection was successfully setup, execute the SELECT statement.
                                    boolean resultset = true;
                                    resultset = connection.executeSqlDmlStatement("INSERT INTO `receipt` (`employeeId`, `price`, `restaurantOrderId`, `checkoutDate`) VALUES (" + employeeId + ", " + totalPrice + ", " + orderID + ", " + checkoutDate + ");");
                                    frame.dispose();
                                    frame.setVisible(false);
                                    ScreenInfoFrame ui = new ScreenInfoFrame();
                                    ui.setVisible(true);
                                }
                            }
                            if (firstName == "Mark") {
                                int employeeId = 38;
                                String checkoutDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                                DatabaseConnection connection = new DatabaseConnection();
                                if (connection.openConnection()) {
                                    // If a connection was successfully setup, execute the SELECT statement.
                                    boolean resultset = true;
                                    resultset = connection.executeSqlDmlStatement("INSERT INTO `receipt` (`employeeId`, `price`, `restaurantOrderId`, `checkoutDate`) VALUES (" + employeeId + ", " + totalPrice + ", " + orderID + ", " + checkoutDate + ");");
                                    frame.dispose();
                                    frame.setVisible(false);
                                    ScreenInfoFrame ui = new ScreenInfoFrame();
                                    ui.setVisible(true);
                                }

                            }
                            if (firstName == "Bas") {
                                int employeeId = 39;
                                String checkoutDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                                DatabaseConnection connection = new DatabaseConnection();
                                if (connection.openConnection()) {
                                    // If a connection was successfully setup, execute the SELECT statement.
                                    boolean resultset = true;
                                    resultset = connection.executeSqlDmlStatement("INSERT INTO `receipt` (`employeeId`, `price`, `restaurantOrderId`, `checkoutDate`) VALUES (" + employeeId + ", " + totalPrice + ", " + orderID + ", " + checkoutDate + ");");
                                    frame.dispose();
                                    frame.setVisible(false);
                                    ScreenInfoFrame ui = new ScreenInfoFrame();
                                    ui.setVisible(true);
                                }

                            }
                            if (firstName == "Sean") {
                                int employeeId = 37;
                                String checkoutDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                                DatabaseConnection connection = new DatabaseConnection();
                                if (connection.openConnection()) {
                                    // If a connection was successfully setup, execute the SELECT statement.
                                    boolean resultset = true;
                                    resultset = connection.executeSqlDmlStatement("INSERT INTO `receipt` (`employeeId`, `price`, `restaurantOrderId`, `checkoutDate`) VALUES (" + employeeId + ", " + totalPrice + ", " + orderID + ", " + checkoutDate + ");");
                                    frame.dispose();
                                    frame.setVisible(false);
                                    ScreenInfoFrame ui = new ScreenInfoFrame();
                                    ui.setVisible(true);
                                }

                            }

                        }
                    }

                } catch (ClassNotFoundException | SQLException k) {
                    JOptionPane.showMessageDialog(null, k.getMessage());
                }
            }
        };

        ActionListener myActionListener;
        myActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ID = input1.getText();
                String sql = "SELECT sum((barorder_drink.quantity * drink.price)) + sum((kitchenorder_dish.quantity * dish.price)) as sumprice, drink.price"
                        + " FROM barorder, barorder_drink, drink, kitchenorder, kitchenorder_dish, dish, restaurantorder"
                        + " WHERE barorder.restaurantOrderId = restaurantorder.id"
                        + " AND kitchenorder.restaurantOrderId = restaurantorder.id"
                        + " AND barorder_drink.barorderId = barorder.id"
                        + " AND barorder_drink.drinkId = drink.id"
                        + " AND kitchenorder_dish.kitchenOrderId = kitchenorder.id"
                        + " AND kitchenorder_dish.dishId = dish.id"
                        + " AND restaurantorder.id ='" + ID + "' ;";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://145.48.6.147:3306/23ivp4a", "hha2_1user", "hha2pass");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()) {

                        double totalPrice = rs.getDouble("sumprice");
                        int orderID = Integer.parseInt(ID);
                        if (orderID > 0) {
                            String overview = "";
                            overview += " Factuur van order nummer: " + orderID + "\n";
                            overview += "\n";
                            overview += " Prijs per product                                               "
                                    + "Hoeveelheid                                                      "
                                    + "Product  \n";
                            overview += " ================================  ================================  ================================\n";

                            OpenBarOrdersDAO daoBar = new OpenBarOrdersDAO();

                            ArrayList<OpenBarOrder> barOrders = daoBar.getAllOpenBarOrders(null);

                            for (int i = 0; i < barOrders.size(); i++) {
                                if (orderID == barOrders.get(i).getRestaurantOrder()) {

                                    overview += "" + barOrders.get(i).getDrinkPrice() + "                                                                     "
                                            + "" + barOrders.get(i).getQuantity() + "                                                                            "
                                            + "" + barOrders.get(i).getDrinkName() + "\n";

                                }
                            }
                            OpenKitchenOrdersDAO daoKitchen = new OpenKitchenOrdersDAO();

                            ArrayList<OpenKitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);

                            for (int i = 0; i < kitchenOrders.size(); i++) {
                                if (orderID == kitchenOrders.get(i).getRestaurantOrderId() && kitchenOrders.get(i).getStatus() == 4) {

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
                } catch (ClassNotFoundException | SQLException k) {
                    JOptionPane.showMessageDialog(null, k.getMessage());
                }

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
