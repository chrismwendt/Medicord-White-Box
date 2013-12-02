/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medicaldatabase;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import oracle.sql.DATE;

/**
 *
 * @author Seth
 */
public class frmDoctor extends javax.swing.JFrame {

    Login loginForm = null;
    frmDoctorApptInfo doctorApptForm = null;
    
    ArrayList <String> appDates;
    ArrayList<String> appIds;
    ArrayList<String> patientNames;
    String userId;    
    
    public frmDoctor(Login frm){
        initComponents();
        this.loginForm = frm;
        userId = loginForm.getUserId();
        appIds = new ArrayList<String>();
        appDates = new ArrayList<String>();
        patientNames = new ArrayList<String>();
        populate(userId);
    }

    public frmDoctor(String userId)
    {
        initComponents();
        appIds = new ArrayList<String>();
        appDates = new ArrayList<String>();
        patientNames = new ArrayList<String>();
        populate(userId);
    }
    
    private void populate(String userId)
    {
        //setting the basic information tab
        try
        {
            ResultSet rsK = Importdb.getUserInfo(userId);
            if (rsK==null)
            {
                throw new Exception("null result set");
            }
            while (rsK.next())
            {
                if (rsK.getString("name") != null && rsK.getString("name").isEmpty()==false)
                {
                    nameTextField.setText(rsK.getString("name"));
                }
                
                if(nameTextField.getText() == null || nameTextField.getText().isEmpty())
                {
                    welcomeLabel.setText("Welcome, please fill out your information.");
                }
                else welcomeLabel.setText("Welcome "+nameTextField.getText()+"!");
                
                String gender;
                if (rsK.getString("gender") != null && rsK.getString("gender").isEmpty()==false)
                {
                    gender = rsK.getString("gender");
                    if (gender.toUpperCase().contains("M"))
                    {
                        maleRadioBtn.setSelected(true);
                    }
                    else
                    {
                        femaleRadioBtn.setSelected(true);
                    }
                }
                if (rsK.getString("SPECIALIZATION") != null && rsK.getString("SPECIALIZATION").isEmpty()==false)
                {
                    specialtiesTextField.setText(rsK.getString("SPECIALIZATION"));
                }
                if (rsK.getString("HOSPITAL") != null && rsK.getString("HOSPITAL").isEmpty()==false)
                {
                    hospitalTextField.setText(rsK.getString("HOSPITAL"));
                }                
                if (rsK.getString("DPHONE") != null && rsK.getString("DPHONE").isEmpty()==false)
                {
                    phoneTextField.setText(rsK.getString("DPHONE"));
                }                
            }
            
            //set the appointment tab
            rsK = Importdb.viewAppointments(userId);
            int rowNum=1;
            //DefaultTableModel model = new DefaultTableModel();  
            if (rsK!=null)
            {
                DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
                while(rsK.next())
                {
                    appIds.add(rsK.getString("aid"));
                    String patientId = rsK.getString("pid");
                    String patientName = Importdb.getName(patientId);
                    String appDate = rsK.getString("dates");                    
                    model.addRow(new Object[]{rowNum ,patientName ,appDate});
                    rowNum++;
                }
            }
            //tblAppointments.setModel(model);
            
        }
        catch(Exception e)
        {
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

          
       MaskFormatter phoneMask = null;
       try {
          phoneMask = new MaskFormatter("(###) ###-####");
       }
       catch(Exception e) {}

        buttonGroup1 = new javax.swing.ButtonGroup();
        welcomeLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        basicInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        specialtiesLabel = new javax.swing.JLabel();
        specialtiesTextField = new javax.swing.JTextField();
        companyLabel = new javax.swing.JLabel();
        hospitalTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JFormattedTextField(phoneMask);
        saveInfoButton = new javax.swing.JButton();
        genderLabel = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        femaleRadioBtn = new javax.swing.JRadioButton();
        patientListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        buttonGroup1.add(maleRadioBtn);
        buttonGroup1.add(femaleRadioBtn);

        setBounds(0, 0, 600, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicord");
        setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        welcomeLabel.setText("Welcome!");

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 153));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nameLabel.setText("Name:");
        
        nameTextField.setDocument(new JTextFieldLimit(20));

        specialtiesLabel.setText("Specialties:");

        specialtiesTextField.setDocument(new JTextFieldLimit(20));

        companyLabel.setText("Hospital:");

        hospitalTextField.setDocument(new JTextFieldLimit(20));

        phoneLabel.setText("Phone Number:");

        saveInfoButton.setText("Save");
        saveInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInfoButtonActionPerformed(evt);
            }
        });

        genderLabel.setText("Gender:");

        maleRadioBtn.setSelected(true);
        maleRadioBtn.setText("Male");

        femaleRadioBtn.setText("Female");

        javax.swing.GroupLayout basicInfoPanelLayout = new javax.swing.GroupLayout(basicInfoPanel);
        basicInfoPanel.setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specialtiesLabel)
                            .addComponent(companyLabel)
                            .addComponent(phoneLabel))
                        .addGap(47, 47, 47)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(specialtiesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(hospitalTextField)
                            .addComponent(phoneTextField)))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(genderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addComponent(maleRadioBtn)
                                .addGap(23, 23, 23)
                                .addComponent(femaleRadioBtn))
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        basicInfoPanelLayout.setVerticalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(femaleRadioBtn)
                    .addComponent(maleRadioBtn)
                    .addComponent(genderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialtiesLabel)
                    .addComponent(specialtiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyLabel)
                    .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveInfoButton)
                .addGap(165, 165, 165))
        );

        jTabbedPane1.addTab("Basic Information", basicInfoPanel);

        tblAppointments.setRowSelectionAllowed(true);
        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Patient Name", "Appointment Date"
            }){
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }

            }

        );
        tblAppointments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblAppointments);

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientListPanelLayout = new javax.swing.GroupLayout(patientListPanel);
        patientListPanel.setLayout(patientListPanelLayout);
        patientListPanelLayout.setHorizontalGroup(
            patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientListPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientListPanelLayout.setVerticalGroup(
            patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientListPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientListPanelLayout.createSequentialGroup()
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientListPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        jTabbedPane1.addTab("Patient List", patientListPanel);
        
        jTabbedPane1.addChangeListener(new ChangeListener() {
           public void stateChanged(ChangeEvent e) {
              if(jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()).equals("Patient List"))
              {
                 updateApptTable();
              }
          }
      });

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeLabel)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        if(tblAppointments.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Select an appointment to view.");
            return;
        }
        String apptId = appIds.get(Integer.parseInt(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 0).toString()) - 1);
        if(apptId != null){
            frmDoctorApptInfo apptInfo = new frmDoctorApptInfo(this, userId, apptId);
            apptInfo.setVisible(true);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInfoButtonActionPerformed
        // TODO add your handling code here:

       Pattern p = Pattern.compile("[^a-zA-Z\\s]");
       boolean hasSpecialChar = p.matcher(nameTextField.getText()).find();
       if (hasSpecialChar)
       {
          JOptionPane.showMessageDialog(this,
                "Name must be only letters and spaces");
          return;
       }
       if(nameTextField.getText().length() > 19)
       {
          nameTextField.setText(nameTextField.getText().substring(0, 19));
          JOptionPane.showMessageDialog(this,
                "Name can only be 20 characters");
          return;
       }
       
       if(phoneTextField.getText().length() != 10) {
    	   JOptionPane.showMessageDialog(this,
                   "Phone number must be 10 digits long");
             return;
       }
       
            if (maleRadioBtn.isSelected())
            {
                Importdb.setDoctorProfile(userId, nameTextField.getText(), hospitalTextField.getText(), specialtiesTextField.getText(), "M", phoneTextField.getText());
            }
            else
            {
                Importdb.setDoctorProfile(userId, nameTextField.getText(), hospitalTextField.getText(), specialtiesTextField.getText(), "F", phoneTextField.getText());
            }

            if(nameTextField.getText().isEmpty())
            {
                welcomeLabel.setText("Welcome, please fill out your information.");
            }
            else welcomeLabel.setText("Welcome "+nameTextField.getText()+"!");

            JOptionPane.showMessageDialog(null, "Information has been saved!");
    }//GEN-LAST:event_saveInfoButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        if(tblAppointments.getSelectedRow() != -1){
            //Row is selected
            Importdb.deleteAppointment(appIds.get(tblAppointments.getSelectedRow()));
            updateApptTable();
           JOptionPane.showMessageDialog(null, "Appointment Deleted!");

        }else{
            JOptionPane.showMessageDialog(null, "Please select an appointment to delete.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void updateApptTable() {
        DefaultTableModel model = (DefaultTableModel)tblAppointments.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        
        try{
            ResultSet r=Importdb.viewAppointments(userId);
            if(r!=null){
                int rowNum = 1;
                appIds.clear();
                appDates.clear();
                patientNames.clear();
                while(r.next()){
                   
                    appIds.add(r.getString("aid"));
                    appDates.add(r.getString("dates"));
                    patientNames.add(Importdb.getName(r.getString("pid")));
                    model.addRow(new Object[]{rowNum,patientNames.get(rowNum-1) ,appDates.get(rowNum-1)});
                    rowNum++;
                }
                r.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDoctor("d2").setVisible(true);
            }
        });
        * */
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.JButton btnView;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField hospitalTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel patientListPanel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton saveInfoButton;
    private javax.swing.JLabel specialtiesLabel;
    private javax.swing.JTextField specialtiesTextField;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
