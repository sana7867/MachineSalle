/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import config.Config;
import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecra
 */
public class MachineForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form MachineForm
     */
    
    IDao<Machine> dao1=null;
    IDao<Salle> dao2=null;
    DefaultTableModel model=null;
    int Id= -1;
    public MachineForm() {
        try {
           initComponents();
           model=(DefaultTableModel) jTableMachine.getModel();
          
           dao1 =(IDao<Machine>) Naming.lookup("rmi://"+Config.ip+":"+Config.port+"/dao1");
           dao2 =(IDao<Salle>) Naming.lookup("rmi://"+Config.ip+":"+Config.port+"/dao2");
           loadMachine();
           loadSalle();
           loadFiltreBox();
       
        } catch (NotBoundException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void loadFiltreBox(){
        try {
             FiltreBox.removeAllItems();
             for (Salle s : dao2.findAll()) {
             FiltreBox.addItem(s);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadMachine(){
        try {
            model.setRowCount(0);
            for (Machine m : dao1.findAll())
                model.addRow(new Object[]{
                    m.getId(),
                    m.getRef(),
                    m.getMarque(),
                    m.getPrix(),
                    m.getSalle()
                    
                }); } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
  public void loadSalle() {
    try {
        List<Salle> salles = dao2.findAll(); // Utilisez votre DAO pour récupérer les salles
        listeSalles.removeAllItems(); // Effacez les éléments existants

        // Ajoutez les salles à la liste déroulante
        for (Salle salle : salles) {
            listeSalles.addItem(salle);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        RefText = new javax.swing.JLabel();
        MarqueText = new javax.swing.JLabel();
        PrixText = new javax.swing.JLabel();
        SalleText = new javax.swing.JLabel();
        TextRef = new javax.swing.JTextField();
        listeSalles = new javax.swing.JComboBox();
        TextMarque = new javax.swing.JTextField();
        TextPrix = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        AjouterButton1 = new javax.swing.JButton();
        ModifierButton2 = new javax.swing.JButton();
        SupprimerButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FiltreBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMachine = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("machines");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("informations machine"));

        RefText.setText("Référence:");

        MarqueText.setText("Marque:");

        PrixText.setText("Prix:");

        SalleText.setText("Salle:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(RefText)
                        .addComponent(PrixText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MarqueText, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(SalleText))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextRef)
                    .addComponent(listeSalles, 0, 230, Short.MAX_VALUE)
                    .addComponent(TextPrix)
                    .addComponent(TextMarque, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RefText)
                    .addComponent(TextRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MarqueText)
                    .addComponent(TextMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrixText)
                    .addComponent(TextPrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalleText)
                    .addComponent(listeSalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        AjouterButton1.setText("Ajouter");
        AjouterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterButton1ActionPerformed(evt);
            }
        });

        ModifierButton2.setText("Modifier");
        ModifierButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierButton2ActionPerformed(evt);
            }
        });

        SupprimerButton3.setText("Supprimer");
        SupprimerButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AjouterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ModifierButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SupprimerButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(AjouterButton1)
                .addGap(18, 18, 18)
                .addComponent(ModifierButton2)
                .addGap(18, 18, 18)
                .addComponent(SupprimerButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des machinas"));

        jLabel1.setText("Filterer par Salle");

        jTableMachine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Référence", "Marque", "Prix", "Salle"
            }
        ));
        jTableMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMachineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMachine);

        jCheckBox1.setText("apply");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(FiltreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FiltreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterButton1ActionPerformed
        // TODO add your handling code here:
        String ref=TextRef.getText().toString();
        String marque=TextMarque.getText().toString();
        double prix = Double.parseDouble(TextPrix.getText().toString());
        try {
             JOptionPane.showMessageDialog(this, "Salle ajoutée avec succès");
            dao1.create(new Machine(ref,marque,prix,(Salle) listeSalles.getSelectedItem()));
            loadMachine();
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AjouterButton1ActionPerformed

    private void ModifierButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierButton2ActionPerformed
        // TODO add your handling code here:                                               
     // Code pour le bouton "Modifier"
    int selectedRow = jTableMachine.getSelectedRow();
    if (selectedRow != -1) {
        try {
            String ref = TextRef.getText();
            String marque = TextMarque.getText();
            double prix = Double.parseDouble(TextPrix.getText());
            Salle salle = (Salle) listeSalles.getSelectedItem();
            Machine updatedMachine = new Machine(ref, marque, prix, salle);
            int machineId = (int) jTableMachine.getValueAt(selectedRow, 0);
            updatedMachine.setId(machineId); // Assurez-vous de définir l'ID de la machine mise à jour
            if (dao1.update(updatedMachine)) {
                loadMachine();
                JOptionPane.showMessageDialog(this, "La machine a été modifiée");
            } else {
                JOptionPane.showMessageDialog(this, "La mise à jour de la machine a échoué");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Sélectionnez une machine à modifier.");
    }



    



    }//GEN-LAST:event_ModifierButton2ActionPerformed

    private void SupprimerButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerButton3ActionPerformed
                                                      
    // Code pour le bouton "Supprimer"
    int selectedRow = jTableMachine.getSelectedRow();
    if (selectedRow != -1) {
        try {
            int reponse =JOptionPane.showConfirmDialog(this, "veullez vous vraiment supprimé ?");
            int machineId = (int) jTableMachine.getValueAt(selectedRow, 0);
            Machine machineToDelete = dao1.findById(machineId);
            if (machineToDelete != null) {
                if (dao1.delete(machineToDelete)) {
                    // Suppression réussie, rechargez la liste des machines
                    JOptionPane.showMessageDialog(this, "supprimé");
                    loadMachine();
                } else {
                    // La suppression a échoué, affichez un message d'erreur si nécessaire
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        // Aucune ligne sélectionnée, affichez un message d'erreur si nécessaire
    }


    }//GEN-LAST:event_SupprimerButton3ActionPerformed

    private void jTableMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMachineMouseClicked
                                           
    int selectedRow = jTableMachine.getSelectedRow();
    if (selectedRow != -1) {
        try {
            int id = Integer.parseInt(jTableMachine.getValueAt(selectedRow, 0).toString());
            Machine selectedMachine = dao1.findById(id);
            TextRef.setText(selectedMachine.getRef());
            TextMarque.setText(selectedMachine.getMarque());
            TextPrix.setText(Double.toString(selectedMachine.getPrix()));

            // Assurez-vous d'ajouter la logique pour la sélection de la salle ici.

        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    }//GEN-LAST:event_jTableMachineMouseClicked




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterButton1;
    private javax.swing.JComboBox FiltreBox;
    private javax.swing.JLabel MarqueText;
    private javax.swing.JButton ModifierButton2;
    private javax.swing.JLabel PrixText;
    private javax.swing.JLabel RefText;
    private javax.swing.JLabel SalleText;
    private javax.swing.JButton SupprimerButton3;
    private javax.swing.JTextField TextMarque;
    private javax.swing.JTextField TextPrix;
    private javax.swing.JTextField TextRef;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableMachine;
    private javax.swing.JComboBox listeSalles;
    // End of variables declaration//GEN-END:variables

   
}
