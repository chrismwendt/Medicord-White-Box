package medicaldatabase;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class viewDoctor extends javax.swing.JFrame {

    /**
     * Creates new form viewDoctor
     */
    String did;
    public viewDoctor(String did) {
        initComponents();
        this.did = did;
        
        try
        {
            ResultSet rsK = Importdb.getUserInfo(did);
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

        basicInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        specialtiesLabel = new javax.swing.JLabel();
        specialtiesTextField = new javax.swing.JTextField();
        companyLabel = new javax.swing.JLabel();
        hospitalTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        genderLabel = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        femaleRadioBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicord");
        setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        nameLabel.setText("Name");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        
        nameTextField.setEditable(false);
        specialtiesTextField.setEditable(false);
        hospitalTextField.setEditable(false);
        phoneTextField.setEditable(false);

        specialtiesLabel.setText("Specialties");

        companyLabel.setText("Hospital");

        phoneLabel.setText("Phone");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        genderLabel.setText("Gender");

        maleRadioBtn.setSelected(true);
        maleRadioBtn.setText("Male");
        maleRadioBtn.setEnabled(false);

        femaleRadioBtn.setText("Female");
        femaleRadioBtn.setEnabled(false);

        javax.swing.GroupLayout basicInfoPanelLayout = new javax.swing.GroupLayout(basicInfoPanel);
        basicInfoPanel.setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(genderLabel))
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(maleRadioBtn)
                                .addGap(18, 18, 18)
                                .addComponent(femaleRadioBtn))
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneLabel)
                            .addComponent(companyLabel)
                            .addComponent(specialtiesLabel))
                        .addGap(89, 89, 89)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specialtiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnClose)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basicInfoPanelLayout.setVerticalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(btnClose)
                .addGap(165, 165, 165))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(basicInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(basicInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField hospitalTextField;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel specialtiesLabel;
    private javax.swing.JTextField specialtiesTextField;
    // End of variables declaration//GEN-END:variables
}
