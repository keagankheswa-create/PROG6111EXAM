/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui.application;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author keaga
 */
public class ProductGUI extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProducts;
    private JButton btnProcess;

    
public ProductGUI() {

    setTitle("Product App");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(4, 2, 10, 10));

    // Menu bar
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenuItem exitItem = new JMenuItem("Exit");

    JMenu toolsMenu = new JMenu("Tools");
    JMenuItem processItem = new JMenuItem("Process");
    JMenuItem clearItem = new JMenuItem("Clear");

    exitItem.addActionListener(e -> System.exit(0));

    fileMenu.add(exitItem);
    toolsMenu.add(processItem);
    toolsMenu.add(clearItem);

    menuBar.add(fileMenu);
    menuBar.add(toolsMenu);

    setJMenuBar(menuBar);

    // Customer name
    add(new JLabel("Customer Name:"));
    txtCustomerName = new JTextField();
    add(txtCustomerName);

    // Product selection
    add(new JLabel("Select Product:"));

    String[] products = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    cmbProducts = new JComboBox<>(products);
    add(cmbProducts);

    // Price
    add(new JLabel("Enter Price:"));
    txtPrice = new JTextField();
    add(txtPrice);

    // Process button
    add(new JLabel(""));
    btnProcess = new JButton("PROCESS");
    add(btnProcess);

    // Button actions
    btnProcess.addActionListener(e -> processSale());
    processItem.addActionListener(e -> processSale());

    clearItem.addActionListener(e -> {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0);
    });
}

    
    private void processSale() {

        try {
            String name = txtCustomerName.getText();
            String product = (String) cmbProducts.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);

            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + name
                    + "\nProduct: " + product
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;
            
             JOptionPane.showMessageDialog(this, message);

            saveToFile(name, product, vat, commission, total);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    }
    
    private void saveToFile(String name, String product,
            double vat, double commission, double total) {

        try {
            FileWriter writer = new FileWriter("data.txt", true);

            writer.write("DATA LOG\n");
            writer.write("***************************\n");
            writer.write("Customer Name: " + name + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("***************************\n\n");
              writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file.");
        }
    }
    public static void main(String[] args) {

        ProductGUI gui = new ProductGUI();
        gui.setVisible(true);

    }
}
    

        


