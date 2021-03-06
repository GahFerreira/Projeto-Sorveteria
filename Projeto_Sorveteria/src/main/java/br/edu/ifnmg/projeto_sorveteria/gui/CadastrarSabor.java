package br.edu.ifnmg.projeto_sorveteria.gui;

import br.edu.ifnmg.projeto_sorveteria.entidade.Categoria;
import br.edu.ifnmg.projeto_sorveteria.entidade.Sabor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Felipe
 */
public class CadastrarSabor extends javax.swing.JInternalFrame {

    //private DefaultListModel<Sabor> lstSaborModel;
    
    private static CadastrarSabor instance;
    
    private DefaultComboBoxModel<Categoria> cboCategoriaModel;
    private DefaultListModel<Sabor> lstSaborModel;
    
    /**
     * Creates new form CadastroSabores
     */
    public CadastrarSabor() {
        
        lstSaborModel = new DefaultListModel<>();
        cboCategoriaModel = new DefaultComboBoxModel<>(Categoria.values());
        
        initComponents();
    }

    public static CadastrarSabor getInstance() {
        
        if (instance == null) {
            instance = new CadastrarSabor();
        }
        
        // TODO Carga de todas editoras e todos autores

        return instance;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSabor = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        scrlLstSabor = new javax.swing.JScrollPane();
        lstSabor = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sabor");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPreco.setText("Pre??o");

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCategoria.setText("Categoria");

        cboCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboCategoria.setModel(cboCategoriaModel);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lstSabor.setModel(lstSaborModel);
        scrlLstSabor.setViewportView(lstSabor);

        javax.swing.GroupLayout pnlSaborLayout = new javax.swing.GroupLayout(pnlSabor);
        pnlSabor.setLayout(pnlSaborLayout);
        pnlSaborLayout.setHorizontalGroup(
            pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaborLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaborLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalvar))
            .addComponent(scrlLstSabor, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlSaborLayout.setVerticalGroup(
            pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaborLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSaborLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(scrlLstSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSabor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(pnlSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        Sabor sabor = new Sabor();
        sabor.setNome(txtNome.getText());
        sabor.setPreco(Double.parseDouble(txtPreco.getText()));
        sabor.setCategoria((Categoria) cboCategoria.getSelectedItem());
        
        lstSaborModel.addElement(sabor);
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Categoria> cboCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JList<Sabor> lstSabor;
    private javax.swing.JPanel pnlSabor;
    private javax.swing.JScrollPane scrlLstSabor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
