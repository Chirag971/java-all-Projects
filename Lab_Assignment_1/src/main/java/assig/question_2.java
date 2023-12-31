/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Address {
    private String personName;
    private String homeAddress;
    private String homePhone;
    private String businessAddress;
    private String businessPhone;
    private String faxNumber;
    private String cellPhone;
    private String pagerNumber;

    public Address(String personName, String homeAddress, String homePhone,
                   String businessAddress, String businessPhone,
                   String faxNumber, String cellPhone, String pagerNumber) {
        this.personName = personName;
        this.homeAddress = homeAddress;
        this.homePhone = homePhone;
        this.businessAddress = businessAddress;
        this.businessPhone = businessPhone;
        this.faxNumber = faxNumber;
        this.cellPhone = cellPhone;
        this.pagerNumber = pagerNumber;
    }

    // Getters and setters for all fields
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPagerNumber() {
        return pagerNumber;
    }

    public void setPagerNumber(String pagerNumber) {
        this.pagerNumber = pagerNumber;
    }
}

public class question_2 extends JFrame{
    private ArrayList<Address> addressList;
    private JList<String> addressListUI;
    private DefaultListModel<String> listModel;

    private JTextField nameField, homeAddressField, homePhoneField, businessAddressField, businessPhoneField,
            faxField, cellPhoneField, pagerField;

    public question_2() {
        addressList = new ArrayList<>();
        listModel = new DefaultListModel<>();

        addressListUI = new JList<>(listModel);
        addressListUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addressListUI.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                displaySelectedAddress();
            }
        });

        nameField = new JTextField(20);
        homeAddressField = new JTextField(20);
        homePhoneField = new JTextField(20);
        businessAddressField = new JTextField(20);
        businessPhoneField = new JTextField(20);
        faxField = new JTextField(20);
        cellPhoneField = new JTextField(20);
        pagerField = new JTextField(20);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAddress();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editAddress();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAddress();
            }
        });

        JButton findButton = new JButton("Find");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findAddress();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Home Address:"));
        inputPanel.add(homeAddressField);
        inputPanel.add(new JLabel("Home Phone:"));
        inputPanel.add(homePhoneField);
        inputPanel.add(new JLabel("Business Address:"));
        inputPanel.add(businessAddressField);
        inputPanel.add(new JLabel("Business Phone:"));
        inputPanel.add(businessPhoneField);
        inputPanel.add(new JLabel("Fax:"));
        inputPanel.add(faxField);
        inputPanel.add(new JLabel("Cell Phone:"));
        inputPanel.add(cellPhoneField);
        inputPanel.add(new JLabel("Pager:"));
        inputPanel.add(pagerField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(addressListUI), BorderLayout.WEST);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Address Book");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
    }

    public void addAddress() {
        String name = nameField.getText();
        if (!name.isEmpty()) {
            Address address = new Address(name, homeAddressField.getText(), homePhoneField.getText(),
                    businessAddressField.getText(), businessPhoneField.getText(),
                    faxField.getText(), cellPhoneField.getText(), pagerField.getText());

            addressList.add(address);
            listModel.addElement(name);
            clearInputFields();
        }
    }

    public void editAddress() {
        int selectedIndex = addressListUI.getSelectedIndex();
        if (selectedIndex >= 0) {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                Address address = addressList.get(selectedIndex);
                address.setPersonName(name);
                address.setHomeAddress(homeAddressField.getText());
                address.setHomePhone(homePhoneField.getText());
                address.setBusinessAddress(businessAddressField.getText());
                address.setBusinessPhone(businessPhoneField.getText());
                address.setFaxNumber(faxField.getText());
                address.setCellPhone(cellPhoneField.getText());
                address.setPagerNumber(pagerField.getText());

                listModel.set(selectedIndex, name);
                clearInputFields();
            }
        }
    }

    public void deleteAddress() {
        int selectedIndex = addressListUI.getSelectedIndex();
        if (selectedIndex >= 0) {
            addressList.remove(selectedIndex);
            listModel.remove(selectedIndex);
            clearInputFields();
        }
    }

    public void findAddress() {
        String query = nameField.getText();
        for (int i = 0; i < addressList.size(); i++) {
            Address address = addressList.get(i);
            if (address.getPersonName().equalsIgnoreCase(query)) {
                addressListUI.setSelectedIndex(i);
                displaySelectedAddress();
                return;
            }
        }
        clearInputFields();
    }

    public void displaySelectedAddress() {
        int selectedIndex = addressListUI.getSelectedIndex();
        if (selectedIndex >= 0) {
            Address address = addressList.get(selectedIndex);
            nameField.setText(address.getPersonName());
            homeAddressField.setText(address.getHomeAddress());
            homePhoneField.setText(address.getHomePhone());
            businessAddressField.setText(address.getBusinessAddress());
            businessPhoneField.setText(address.getBusinessPhone());
            faxField.setText(address.getFaxNumber());
            cellPhoneField.setText(address.getCellPhone());
            pagerField.setText(address.getPagerNumber());
        }
    }

    public void clearInputFields() {
        nameField.setText("");
        homeAddressField.setText("");
        homePhoneField.setText("");
        businessAddressField.setText("");
        businessPhoneField.setText("");
        faxField.setText("");
        cellPhoneField.setText("");
        pagerField.setText("");
        addressListUI.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            question_2 app = new question_2();
            app.setVisible(true);
        });
    }
}
