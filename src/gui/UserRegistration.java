/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

//import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author virulnirmala
 */
public class UserRegistration extends javax.swing.JFrame {

    public static HashMap<String, Integer> countryMap = new HashMap();

    /**
     * Creates new form UserRegistration
     */
    public UserRegistration() {
        initComponents();
        LoadCountry();
        TableLoad();

    }

    private void LoadCountry() {
        try {
            String username = "root";
            String Password = "200528100634@Vn";
            String Database = "db5";

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + Database, username, Password);

            Statement statment = connection.createStatement();

            ResultSet resultSet = statment.executeQuery("SELECT * FROM `country`");
            Vector<String> countryDataVector = new Vector();
            countryDataVector.add("Select");

            DefaultComboBoxModel model1 = new DefaultComboBoxModel(countryDataVector);
            while (resultSet.next()) {
                countryDataVector.add(resultSet.getString("country"));
                countryMap.put(resultSet.getString("country"), resultSet.getInt("country_id"));
//                System.out.println(countryName);

            }
            jComboBox1.setModel(model1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        buttonGroup1.clearSelection();
    }

    private void TableLoad() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db5", "root", "200528100634@Vn");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM db5.user INNER JOIN `db5`.`gender` ON `gender_id` = `gender_gender_id` INNER JOIN `db5`.`country` ON `country_country_id` = `country_id` ORDER by `user_id` ASC");
            DefaultTableModel userTableModel = (DefaultTableModel) jTable1.getModel();
            userTableModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> tableVector = new Vector();
                tableVector.add(resultSet.getString("user_id"));
                tableVector.add(resultSet.getString("first_namr"));
                tableVector.add(resultSet.getString("last_name"));
                tableVector.add(resultSet.getString("username"));
                tableVector.add(resultSet.getString("password"));
                tableVector.add(resultSet.getString("gender"));
                tableVector.add(resultSet.getString("country"));

                userTableModel.addRow(tableVector);
                jTable1.setModel(userTableModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setText("Country");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");

        jButton1.setText("Create New User Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update User Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete User Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/8665352_eye_slash_icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jRadioButton1)
                            .addGap(67, 67, 67)
                            .addComponent(jRadioButton2))
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "First Name", "Last Name", "Username", "Password", "Gender", "Country"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String firstname = jTextField1.getText();
            String lastname = jTextField2.getText();
            String username = jTextField3.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String country = String.valueOf(jComboBox1.getSelectedItem());
            ButtonModel genderSelection = buttonGroup1.getSelection();

            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Invalid First Name");
            } else if (lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Invalid Last Name");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Username", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Invalid Username");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Password", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Invalid Password");
            } else if (country.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Select country", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Select Your Country");
            } else if (genderSelection == null) {
                JOptionPane.showMessageDialog(this, "Select gender", "Warning", JOptionPane.ERROR_MESSAGE);
//                System.out.println("Invalid Gender");
            } else {
                String genderId = buttonGroup1.getSelection().getActionCommand();
//                System.out.println(genderId);
                int country_id = countryMap.get(country);

                try {
                    String Username = "root";
                    String Password = "200528100634@Vn";
                    String Database = "db5";

                    Class.forName(
                            "com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/" + Database, Username, Password);

                    Statement statment = connection.createStatement();
                    statment.executeUpdate("INSERT INTO `user` (`first_namr`,`last_name`,`username`,`password`,`gender_gender_id`,`country_country_id`) VALUES ('" + firstname + "','" + lastname + "','" + username + "','" + password + "','" + genderId + "','" + country_id + "')");
                    JOptionPane.showMessageDialog(this, "Registration Done", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    TableLoad();
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jTable1.setEnabled(false);
            jButton1.setEnabled(false);
            int selectedRowData = jTable1.getSelectedRow();
            String Fname = String.valueOf(jTable1.getValueAt(selectedRowData, 1));
            String lname = String.valueOf(jTable1.getValueAt(selectedRowData, 2));
            String userString = String.valueOf(jTable1.getValueAt(selectedRowData, 3));
            String passwordString = String.valueOf(jTable1.getValueAt(selectedRowData, 4));
            String genderString = String.valueOf(jTable1.getValueAt(selectedRowData, 5));
            String countryString = String.valueOf(jTable1.getValueAt(selectedRowData, 6));

            jTextField1.setText(Fname);
            jTextField2.setText(lname);
            jTextField3.setText(userString);
            jPasswordField1.setText(passwordString);
            jComboBox1.setSelectedItem(countryString);

            if (genderString.equals("Male")) {
                jRadioButton1.setSelected(true);
            }
            if (genderString.equals("Female")) {
                jRadioButton2.setSelected(true);
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowData = jTable1.getSelectedRow();
        if (selectedRowData == -1) {
            JOptionPane.showMessageDialog(this, "Select Row First", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRowData, 0));
            String firstname = jTextField1.getText();
            String lastname = jTextField2.getText();
            String username = jTextField3.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String country = String.valueOf(jComboBox1.getSelectedItem());
            ButtonModel genderSelection = buttonGroup1.getSelection();
            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Invalid First Name");
            } else if (lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Invalid Last Name");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Username", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Invalid Username");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Password", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Invalid Password");
            } else if (country.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Select Your Country", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Select Your Country");
            } else if (genderSelection == null) {
                JOptionPane.showMessageDialog(this, "Invalid Gender", "Warning", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Invalid Gender");
            } else {
                String genderId = buttonGroup1.getSelection().getActionCommand();
                int country_id = countryMap.get(country);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db5", "root", "200528100634@Vn");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("UPDATE `user` SET `first_namr` = '" + firstname + "',`last_name` = '" + lastname + "' ,`username` = '" + username + "', `password` = '" + password + "', `gender_gender_id` = '" + genderId + "' , `country_country_id` = '" + country_id + "' WHERE `user_id` = '" + id + "'");
//                System.out.println("done");
                    JOptionPane.showMessageDialog(this, "Update is Done", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    TableLoad();

                    jTable1.setEnabled(true);
                    jButton1.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRowData = jTable1.getSelectedRow();
        if (selectedRowData == -1) {
            JOptionPane.showMessageDialog(this, "Please Select Row", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRowData, 0));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db5", "root", "200528100634@Vn");
                Statement statement = connection.createStatement();

                statement.executeUpdate("DELETE FROM `user` WHERE `user_id` = '" + id + "'");
                JOptionPane.showMessageDialog(this, "User Deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
                reset();
                TableLoad();

                jTable1.setEnabled(true);
                jButton1.setEnabled(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        if (jPasswordField1.echoCharIsSet()) {
            jPasswordField1.setEchoChar('\u0000');
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/8530610_eye_icon.png")));
        } else {
            jPasswordField1.setEchoChar('\u2022');
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/8665352_eye_slash_icon.png")));
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatAtomOneDarkIJTheme.setup();
//        FlatDarkLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
