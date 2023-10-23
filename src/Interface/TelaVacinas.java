package Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import programavacinacao.Vacina;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import programavacinacao.Agentes;
import programavacinacao.Vacina;
/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */
public class TelaVacinas extends javax.swing.JFrame {
    public static void importarCSV(String nomeArq){
           
    try{
        Reader reader = new InputStreamReader(new FileInputStream(nomeArq), "UTF-8");
        BufferedReader entrada = new BufferedReader(reader);
        
        while(entrada.ready()){
        String linha = entrada.readLine();
        String[] info = linha.split(";");
        Login.ListaVacina.add(new Vacina(info[0],Integer.parseInt(info[1]),info[2],info[3]));
        }
    }   catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Valor inválido");
        }
    }
    
     
    public static void exportarCSV(String nomeArq2) {
        try {
            FileWriter arquivo2 = new FileWriter(nomeArq2,false);
            BufferedWriter escrita = new BufferedWriter(arquivo2);

            for (int i = 0; i < Login.ListaVacina.size(); i++) {
                escrita.write(Login.ListaVacina.get(i).toCSVVacina());
            }

            escrita.flush(); // descarga
            escrita.close();

        } catch (IOException ex) {
            System.out.println("erro");
        }
    }
String Modo;
    public void LoadTableVacina(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Fabricante","Lote","Validade", "Quantidade"},0);
        
        for(int i=0;i<Login.ListaVacina.size();i++){
            Object linha2[] = new Object[]{Login.ListaVacina.get(i).getFabricante(),
                                           Login.ListaVacina.get(i).getLote(),
                                           Login.ListaVacina.get(i).getValidade(),
                                           Login.ListaVacina.get(i).getQuantidade()};
            modelo.addRow(linha2);
        }
        
        tbl_vacina.setModel(modelo);
        tbl_vacina.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_vacina.getColumnModel().getColumn(1).setPreferredWidth(200);
        
    }
    public TelaVacinas() {
        initComponents();
        setLocationRelativeTo(null);
        Modo = "Navegar";
        importarCSV("Vacinas.csv");
        LoadTableVacina();
        ManipulaInterface();
    }
    public void ManipulaInterface(){
        switch(Modo){
            case "Navegar":
                btn_vacina_salvar.setEnabled(false);
                btn_vacina_excluir.setEnabled(true);
                c_vacina_fabricante.setEnabled(false);
                c_vacina_lote.setEnabled(false);
                c_vacina_validade.setEnabled(false);
                c_vacina_quantidade.setEnabled(false);
                btn_vacina_novo.setEnabled(true);
                btn_vacina_editar.setEnabled(true);
                break;
            
            case "Novo":                
                btn_vacina_excluir.setEnabled(false);
                c_vacina_fabricante.setEnabled(true);
                c_vacina_lote.setEnabled(true);
                c_vacina_validade.setEnabled(true);
                c_vacina_quantidade.setEnabled(true);
                btn_vacina_novo.setEnabled(false);
                btn_vacina_editar.setEnabled(false);
                btn_vacina_salvar.setEnabled(true);
                btn_vacina_cancelar.setEnabled(true);
                break;
                
            case "Editar":
                btn_vacina_excluir.setEnabled(false);
                c_vacina_fabricante.setEnabled(true);
                c_vacina_lote.setEnabled(true);
                c_vacina_validade.setEnabled(true);
                c_vacina_quantidade.setEnabled(true);
                btn_vacina_novo.setEnabled(false);
                btn_vacina_editar.setEnabled(false);
                btn_vacina_salvar.setEnabled(true);
                btn_vacina_cancelar.setEnabled(true);
                break;
                
            case "Excluir":
                btn_vacina_excluir.setEnabled(false);
                c_vacina_fabricante.setEnabled(false);
                c_vacina_lote.setEnabled(false);
                c_vacina_validade.setEnabled(false);
                c_vacina_quantidade.setEnabled(false);
                btn_vacina_novo.setEnabled(true);
                btn_vacina_editar.setEnabled(false);
                btn_vacina_salvar.setEnabled(false);
                btn_vacina_cancelar.setEnabled(false);
                break;
                
            case "Selecao":
                btn_vacina_excluir.setEnabled(true);
                c_vacina_fabricante.setEnabled(false);
                c_vacina_lote.setEnabled(false);
                c_vacina_validade.setEnabled(false);
                c_vacina_quantidade.setEnabled(false);
                btn_vacina_novo.setEnabled(true);
                btn_vacina_editar.setEnabled(true);
                btn_vacina_salvar.setEnabled(false);
                btn_vacina_cancelar.setEnabled(true);
                break;
                
            default: System.out.println("Modo inválido");
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

        btn_vacina_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vacina = new javax.swing.JTable();
        btn_vacina_salvar = new javax.swing.JButton();
        btn_vacina_editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        c_vacina_fabricante = new javax.swing.JTextField();
        c_vacina_lote = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_vacina_validade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_vacina_quantidade = new javax.swing.JTextField();
        btn_vacina_novo = new javax.swing.JButton();
        btn_vacina_excluir = new javax.swing.JButton();
        btn_vacina_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);

        btn_vacina_voltar.setText("Voltar");
        btn_vacina_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_voltarActionPerformed(evt);
            }
        });

        tbl_vacina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fabricante", "Lote", "Validade", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_vacina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_vacinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_vacina);

        btn_vacina_salvar.setText("Salvar");
        btn_vacina_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_salvarActionPerformed(evt);
            }
        });

        btn_vacina_editar.setText("Editar ");
        btn_vacina_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_editarActionPerformed(evt);
            }
        });

        jLabel1.setText("Fabricante:");

        c_vacina_fabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vacina_fabricanteActionPerformed(evt);
            }
        });

        c_vacina_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vacina_loteActionPerformed(evt);
            }
        });

        jLabel2.setText("Lote:");

        jLabel3.setText("Validade: ");

        c_vacina_validade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vacina_validadeActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        c_vacina_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vacina_quantidadeActionPerformed(evt);
            }
        });

        btn_vacina_novo.setText("Novo");
        btn_vacina_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_novoActionPerformed(evt);
            }
        });

        btn_vacina_excluir.setText("Excluir");
        btn_vacina_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_excluirActionPerformed(evt);
            }
        });

        btn_vacina_cancelar.setText("Cancelar");
        btn_vacina_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacina_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btn_vacina_novo))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_vacina_editar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_vacina_excluir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(c_vacina_lote, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_vacina_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(c_vacina_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(c_vacina_validade, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_vacina_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_vacina_cancelar)))))))
                .addGap(0, 76, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btn_vacina_voltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vacina_novo)
                    .addComponent(btn_vacina_editar)
                    .addComponent(btn_vacina_excluir))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_vacina_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_vacina_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addComponent(btn_vacina_voltar)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(c_vacina_validade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_vacina_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_vacina_salvar)
                            .addComponent(btn_vacina_cancelar))
                        .addGap(48, 48, 48))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vacina_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_voltarActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_vacina_voltarActionPerformed

    private void btn_vacina_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_salvarActionPerformed
        int quant = Integer.parseInt(c_vacina_quantidade.getText());
        if(Modo.equals("Novo")){  
            Vacina A = new Vacina(c_vacina_lote.getText(), quant, c_vacina_validade.getText(), c_vacina_fabricante.getText());
            Login.ListaVacina.add(A);
        }else if(Modo.equals("Editar")){
            int index = tbl_vacina.getSelectedRow();
            Login.ListaVacina.get(index).setFabricante(c_vacina_fabricante.getText());
            Login.ListaVacina.get(index).setLote(c_vacina_lote.getText());
            Login.ListaVacina.get(index).setValidade(c_vacina_validade.getText());
            Login.ListaVacina.get(index).setQuantidade(quant);
       
        }
        LoadTableVacina(); 
        Modo = "Navegar";
        ManipulaInterface();
        c_vacina_fabricante.setText("");
        c_vacina_lote.setText("");
        c_vacina_validade.setText("");
        c_vacina_quantidade.setText("");
        exportarCSV("Vacinas.csv");
    }//GEN-LAST:event_btn_vacina_salvarActionPerformed

    private void btn_vacina_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_editarActionPerformed
        Modo = "Editar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vacina_editarActionPerformed

    private void tbl_vacinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_vacinaMouseClicked
      int index = tbl_vacina.getSelectedRow();
        if(index>=0 && index<Login.ListaVacina.size()){
            Vacina A = Login.ListaVacina.get(index);
            c_vacina_fabricante.setText(A.getFabricante());
            c_vacina_lote.setText(A.getLote());        
            c_vacina_validade.setText(A.getValidade());
            c_vacina_quantidade.setText(String.valueOf(A.getQuantidade()));
            Modo = "Selecao";
            ManipulaInterface();
        }
    }//GEN-LAST:event_tbl_vacinaMouseClicked

    private void c_vacina_fabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vacina_fabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vacina_fabricanteActionPerformed

    private void c_vacina_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vacina_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vacina_loteActionPerformed

    private void c_vacina_validadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vacina_validadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vacina_validadeActionPerformed

    private void c_vacina_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vacina_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vacina_quantidadeActionPerformed

    private void btn_vacina_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_novoActionPerformed
        c_vacina_fabricante.setText("");
        c_vacina_lote.setText("");
        c_vacina_validade.setText("");
        c_vacina_quantidade.setText("");
       
        Modo = "Novo";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vacina_novoActionPerformed

    private void btn_vacina_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_cancelarActionPerformed
        c_vacina_fabricante.setText("");
        c_vacina_lote.setText("");
        c_vacina_validade.setText("");
        c_vacina_quantidade.setText("");
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vacina_cancelarActionPerformed

    private void btn_vacina_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacina_excluirActionPerformed
     int index = tbl_vacina.getSelectedRow();
     if(index>=0 && index<Login.ListaVacina.size()){
            Login.ListaVacina.remove(index);
        }
        LoadTableVacina();
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vacina_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVacinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVacinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVacinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVacinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVacinas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_vacina_cancelar;
    private javax.swing.JButton btn_vacina_editar;
    private javax.swing.JButton btn_vacina_excluir;
    private javax.swing.JButton btn_vacina_novo;
    private javax.swing.JButton btn_vacina_salvar;
    private javax.swing.JButton btn_vacina_voltar;
    private javax.swing.JTextField c_vacina_fabricante;
    private javax.swing.JTextField c_vacina_lote;
    private javax.swing.JTextField c_vacina_quantidade;
    private javax.swing.JTextField c_vacina_validade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_vacina;
    // End of variables declaration//GEN-END:variables
}
