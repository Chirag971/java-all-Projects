/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig;

import java.math.BigDecimal;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class question_5 extends JDialog {

    Connection con;
    Statement stmt;
    private JTextField nameField, haddressField, phoneField, baddressField, bphoneField, faxNumber,
            cellPhone, pager,
            maritialStatus, noOfChildrens, annuakInc;
    private JButton addButton;

    public question_5(JFrame parentFrame) throws ClassNotFoundException {
        super(parentFrame, "Address Book", true); // Set the dialog as modal
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(15, 10));
        inputPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Home Address: "));
        haddressField = new JTextField();
        inputPanel.add(haddressField);
        inputPanel.add(new JLabel("Phone: "));
        phoneField = new JTextField();
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Business Address: "));
        baddressField = new JTextField();
        inputPanel.add(baddressField);
        inputPanel.add(new JLabel("Business Phone Number: "));
        bphoneField = new JTextField();
        inputPanel.add(bphoneField);
        inputPanel.add(new JLabel("Fax Number: "));
        faxNumber = new JTextField();
        inputPanel.add(faxNumber);
        inputPanel.add(new JLabel("Cellular Phone: "));
        cellPhone = new JTextField();
        inputPanel.add(cellPhone);
        inputPanel.add(new JLabel("Pager Number: "));
        pager = new JTextField();
        inputPanel.add(pager);
        inputPanel.add(new JLabel("Marital Status: "));
        maritialStatus = new JTextField();
        inputPanel.add(maritialStatus);
        inputPanel.add(new JLabel("Number of Children: "));
        noOfChildrens = new JTextField();
        inputPanel.add(noOfChildrens);
        inputPanel.add(new JLabel("Annual Income: "));
        annuakInc = new JTextField();
        inputPanel.add(annuakInc);
        addButton = new JButton("Add");
        inputPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addRecordToDatabase();
                } catch (ClassNotFoundException ex) {
                    System.out.println("Failed to load MySQL JDBC driver");
                }
            }
        });
        add(inputPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(parentFrame); // Center the dialog relative to the parent frame
    }

    public static void main(String[] args) throws ClassNotFoundException {
        SwingUtilities.invokeLater(() -> {
            int ch;
            String input;
            try {
                JFrame parentFrame = new JFrame();
                parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (true) {
                    input = JOptionPane.showInputDialog(
                    "Enter One To add \n Enter Two for Delete \n Enter Threefor update \n Enter Four for Show all records {}\nEnter Five for exit.");
 ch = Integer.parseInt(input);
                    question_5 addressBook = new question_5(parentFrame);
                    switch (ch) {
                        case 1:
                            addressBook.setVisible(true); // Display the address book dialog
                            break;
                        case 2:
                            addressBook.deleteRecordFromDatabase();
                            break;
                        case 3:
                            //addressBook.updateRecordInDatabase();
                            System.out.println("Selected Update Option");
                            break;
                        case 4:
                            addressBook.showAllRecordsDialog();
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Wrong Port Selected");
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Failed to load MySQL JDBC driver");
            }
        });
    }

    private void addRecordToDatabase() throws ClassNotFoundException {
        String name = nameField.getText();
        String homeaddress = haddressField.getText();
        String phoneNumber = phoneField.getText();
        String businessAddress = baddressField.getText();
        String businessPhone = bphoneField.getText();
        String faxNumberValue = faxNumber.getText();
        String cellPhoneNumber = cellPhone.getText();
        String pagerNumber = pager.getText();
        String status = maritialStatus.getText();
        String childrenNum = noOfChildrens.getText();
        String annualIncome = annuakInc.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the updated driver class
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/records?useSSL=false", "root",
                    "root");
            con.setAutoCommit(false); // Disable auto-commit
            System.out.println("Database Connected Successfully!!!");
            String insertQuery = "INSERT INTO customer_records (name, home_address, phone_number,business_address, business_phone_number, fax_number, cellular_phone, pager_number, marital_status,number_of_children, annual_income) VALUES( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
 PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, name);
            pstmt.setString(2, homeaddress);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, businessAddress);
            pstmt.setString(5, businessPhone);
            pstmt.setString(6, faxNumberValue);
            pstmt.setString(7, cellPhoneNumber);
            pstmt.setString(8, pagerNumber);
            pstmt.setString(9, status);
            pstmt.setInt(10, Integer.parseInt(childrenNum)); 
             pstmt.setBigDecimal(11, new BigDecimal(annualIncome)); // Set the BigDecimal value
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your Record Added SuccessFully");
            con.commit(); // Commit the transaction manually
            System.out.println("Record added to the database successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect with the database");
        }
    }
    //For Delete Records

    private void deleteRecordFromDatabase() {
        String input = JOptionPane.showInputDialog("Enter the name of the record you want to delete:");
        String nameToDelete = input.trim();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the updated driver class
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/records?useSSL=false", "root",
                    "root");
            con.setAutoCommit(false); // Disable auto-commit
            System.out.println("Database Connected Successfully!!!");
            String deleteQuery = "DELETE FROM customer_records WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setString(1, nameToDelete);
            int rowsAffected = pstmt.executeUpdate();
            con.commit(); // Commit the transaction manually
            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Record not found or could not be deleted.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect with the database");
        }
    }
    //Display data

    private void showAllRecordsDialog() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the updated driver class
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/records?useSSL=false", "root",
                    "root");
            System.out.println("Database Connected Successfully!!!");
            String selectQuery = "SELECT * FROM customer_records";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            // Create a JTextArea to display the records
            JTextArea recordsTextArea = new JTextArea();
            recordsTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(recordsTextArea);
            // Append the records to the JTextArea
            StringBuilder recordsText = new StringBuilder("\n==== All Records ====\n");
            while (rs.next()) {
                String name = rs.getString("name");
                String homeAddress = rs.getString("home_address");
                String phoneNumber = rs.getString("phone_number");
                String businessAddress = rs.getString("business_address");
                String businessPhone = rs.getString("business_phone_number");
                String faxNumberValue = rs.getString("fax_number");
                String cellPhoneNumber = rs.getString("cellular_phone");
                String pagerNumber = rs.getString("pager_number");
                String status = rs.getString("marital_status");
                int childrenNum = rs.getInt("number_of_children");
                BigDecimal annualIncome = rs.getBigDecimal("annual_income");
                recordsText.append("Name: ").append(name).append("\n");
                recordsText.append("Home Address: ").append(homeAddress).append("\n");
                recordsText.append("Phone: ").append(phoneNumber).append("\n");
                recordsText.append("Business Address: ").append(businessAddress).append("\n");
                recordsText.append("Business Phone Number: ").append(businessPhone).append("\n");
                recordsText.append("Fax Number: ").append(faxNumberValue).append("\n");
                recordsText.append("Cellular Phone: ").append(cellPhoneNumber).append("\n");
                recordsText.append("Pager Number: ").append(pagerNumber).append("\n");
                recordsText.append("Marital Status: ").append(status).append("\n");
                recordsText.append("Number of Children: ").append(childrenNum).append("\n");
                recordsText.append("Annual Income: ").append(annualIncome).append("\n");
                recordsText.append("=========================\n");
            }
            rs.close();
            stmt.close();
            con.close();
            // Set the text in the JTextArea
            recordsTextArea.setText(recordsText.toString());
            // Create and show the dialog box with the records
            JOptionPane.showMessageDialog(this, scrollPane, "All Records", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect with the database");
        }
    }
}
