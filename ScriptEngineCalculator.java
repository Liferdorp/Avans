/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptenginecalculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

// script package introduced in Java 1.6
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class ScriptEngineCalculator implements ActionListener, KeyListener {

    private JTextField io;
    private ScriptEngine engine;
    private ArrayList<JButton> controls;
    private JPanel ui;

    ScriptEngineCalculator() {
        initUI();
    }

    public final void initUI() {
        // obtain a reference to the JS engine
        engine = new ScriptEngineManager().
                getEngineByExtension("js");

        ui = new JPanel(new BorderLayout(2, 2));
        controls = new ArrayList<JButton>();

        JPanel text = new JPanel(new GridLayout(0, 1, 3, 3));
        ui.add(text, BorderLayout.PAGE_START);
        io = new JTextField(15);
        Font font = io.getFont();
        font = font.deriveFont(font.getSize() * 1.8f);
        io.setFont(font);
        io.setHorizontalAlignment(SwingConstants.TRAILING);
        io.setFocusable(false);
        text.add(io);

        JPanel buttons = new JPanel(new GridLayout(4, 4, 2, 2));
        ui.add(buttons, BorderLayout.CENTER);
        String[] keyValues = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "/", "C", "="
        };

        for (String keyValue : keyValues) {
            addButton(buttons, keyValue);
        }

        
    }

    public JComponent getUI() {
        return ui;
    }

    public void addButton(Container c, String text) {
        JButton b = new JButton(text);
        configureButton(b);
        c.add(b);
    }

    public void configureButton(JButton b) {
        Font f = b.getFont();
        b.setFont(f.deriveFont(f.getSize() * 1.5f));
        b.addActionListener(this);
        b.addKeyListener(this);
        controls.add(b);
    }

    public void calculateResult() {
        try {
            Object result = engine.eval(io.getText());
            if (result == null) {
                io.setText("Output was 'null'");
            } else {
                io.setText(result.toString());
            }
        } catch (ScriptException se) {
            io.setText(se.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("C")) {
            io.setText("");
        } else if (command.equals("=")) {
            calculateResult();
        } else {
            io.setText(io.getText() + command);
        }
    }

    private JButton getButton(String text) {
        for (JButton button : controls) {
            String s = button.getText();
            if (text.endsWith(s)
                    || (s.equals("=")
                    && (text.equals("Equals") || text.equals("Enter")))) {

                return button;
            }
        }
        return null;
    }

    /* START - Because I hate mice. */
    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        String s = KeyEvent.getKeyText(ke.getKeyCode());
        JButton b = getButton(s);
        if (b != null) {
            b.requestFocusInWindow();
            b.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
    /* END - Because I hate mice. */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScriptEngineCalculator sc = new ScriptEngineCalculator();
                JFrame f = new JFrame("Calculet");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(sc.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }
}