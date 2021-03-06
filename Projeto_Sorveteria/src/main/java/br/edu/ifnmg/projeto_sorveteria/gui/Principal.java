
package br.edu.ifnmg.projeto_sorveteria.gui;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Felipe
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        dskPrincipal = new javax.swing.JDesktopPane();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuGerencial = new javax.swing.JMenu();
        mnuGerencialUsuario = new javax.swing.JMenuItem();
        mnuFuncionarioItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuProdutos = new javax.swing.JMenu();
        mnuProdutosSabor = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuProdutosRecipiente = new javax.swing.JMenuItem();
        mnuProdutosAdicional = new javax.swing.JMenuItem();
        mnuCopo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAtendimentoPedido = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1320, 780));
        setSize(getPreferredSize());

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPrincipal)
        );

        mnuGerencial.setText("Gerencial");

        mnuGerencialUsuario.setText("Usu??rio");
        mnuGerencial.add(mnuGerencialUsuario);

        mnuFuncionarioItem.setText("Funcion??rio");
        mnuGerencial.add(mnuFuncionarioItem);
        mnuGerencial.add(jSeparator1);

        mnuPrincipal.add(mnuGerencial);

        mnuProdutos.setText("Produtos");

        mnuProdutosSabor.setText("Sabor");
        mnuProdutosSabor.setDisplayedMnemonicIndex(0);
        mnuProdutosSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosSaborActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuProdutosSabor);
        mnuProdutos.add(jSeparator2);

        mnuProdutosRecipiente.setText("Recipiente");
        mnuProdutosRecipiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosRecipienteActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuProdutosRecipiente);

        mnuProdutosAdicional.setText("Adicional");
        mnuProdutosAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosAdicionalActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuProdutosAdicional);

        mnuCopo.setText("Copo Milkshake");
        mnuCopo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCopoActionPerformed(evt);
            }
        });
        mnuProdutos.add(mnuCopo);

        mnuPrincipal.add(mnuProdutos);

        jMenu2.setText("Atendimento");

        mnuAtendimentoPedido.setText("Pedido");
        mnuAtendimentoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendimentoPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAtendimentoPedido);

        mnuPrincipal.add(jMenu2);

        jMenu1.setText("Relat??rio");
        mnuPrincipal.add(jMenu1);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuProdutosSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosSaborActionPerformed
        
        CadastrarSabor interna = CadastrarSabor.getInstance();

        // Se a janela ainda n??o foi adicionada ?? ??rea de trabalho...
        if (!Arrays
                .asList(dskPrincipal.getAllFrames())
                .contains(interna)) {
            dskPrincipal.add(interna);
        }

        anexarJanela(interna);
    }//GEN-LAST:event_mnuProdutosSaborActionPerformed

    private void mnuProdutosRecipienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosRecipienteActionPerformed
        
        CadastrarRecipiente interna = CadastrarRecipiente.getInstance();

        // Se a janela ainda n??o foi adicionada ?? ??rea de trabalho...
        if (!Arrays
                .asList(dskPrincipal.getAllFrames())
                .contains(interna)) {
            dskPrincipal.add(interna);
        }
       
        anexarJanela(interna);
    }//GEN-LAST:event_mnuProdutosRecipienteActionPerformed

    private void mnuProdutosAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosAdicionalActionPerformed
        
        CadastrarAdicional interna = CadastrarAdicional.getInstance();

        // Se a janela ainda n??o foi adicionada ?? ??rea de trabalho...
        if (!Arrays
                .asList(dskPrincipal.getAllFrames())
                .contains(interna)) {
            dskPrincipal.add(interna);
        }
        
        anexarJanela(interna);    }//GEN-LAST:event_mnuProdutosAdicionalActionPerformed

    private void mnuCopoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCopoActionPerformed
  
        CadastrarCopoMilkshake interna = CadastrarCopoMilkshake.getInstance();

        // Se a janela ainda n??o foi adicionada ?? ??rea de trabalho...
        if (!Arrays
                .asList(dskPrincipal.getAllFrames())
                .contains(interna)) {
            dskPrincipal.add(interna);
        }
        
        anexarJanela(interna);        }//GEN-LAST:event_mnuCopoActionPerformed

    private void mnuAtendimentoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendimentoPedidoActionPerformed
                
        CadastrarPedido interna = CadastrarPedido.getInstance();

        // Se a janela ainda n??o foi adicionada ?? ??rea de trabalho...
        if (!Arrays
                .asList(dskPrincipal.getAllFrames())
                .contains(interna)) {
            dskPrincipal.add(interna);
        }

        anexarJanela(interna);
    }//GEN-LAST:event_mnuAtendimentoPedidoActionPerformed

     private void anexarJanela(JInternalFrame janela) {
        // Verifica????o de janela v??lida
        if (janela == null) {
            return;
        }
        
        //Centraliza janela
        Dimension desktopSize = dskPrincipal.getSize();
        Dimension jInternalFrameSize = janela.getSize();
        janela.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        
        // Torna a janela vis??vel
        janela.setVisible(true);

        try {
            // Restaura a janela caso esteja minimizada
            janela.setIcon(false);

            // Leva o foco para a janela
            janela.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Traz a janela para o primeiro plano
        janela.toFront();
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mnuAtendimentoPedido;
    private javax.swing.JMenuItem mnuCopo;
    private javax.swing.JMenuItem mnuFuncionarioItem;
    private javax.swing.JMenu mnuGerencial;
    private javax.swing.JMenuItem mnuGerencialUsuario;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuProdutos;
    private javax.swing.JMenuItem mnuProdutosAdicional;
    private javax.swing.JMenuItem mnuProdutosRecipiente;
    private javax.swing.JMenuItem mnuProdutosSabor;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
