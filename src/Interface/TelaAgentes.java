package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import programavacinacao.Agentes;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;

/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */
public class TelaAgentes extends javax.swing.JFrame {
    
    public static void importarCSV(String nomeArq){
           
    try{
        Reader reader = new InputStreamReader(new FileInputStream(nomeArq), "UTF-8");
        BufferedReader entrada = new BufferedReader(reader);
        
        while(entrada.ready()){
        String linha = entrada.readLine();
        String[] info = linha.split(";");
        Login.ListaAgente.add(new Agentes(info[0], info[1]));
        
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

            for (int i = 0; i < Login.ListaAgente.size(); i++) {
                escrita.write(Login.ListaAgente.get(i).toCSVAgente());
            }

            escrita.flush(); // descarga
            escrita.close();

        } catch (IOException ex) {
            System.out.println("erro");
        }
    }
    

    public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String Modo;
    
    public void LoadTableAgente(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome","Código"},0);
        
        for(int i=0;i<Login.ListaAgente.size();i++){
            Object linha[] = new Object[]{Login.ListaAgente.get(i).getNomeAgente(),
                                          Login.ListaAgente.get(i).getCodigo()};
            modelo.addRow(linha);
        }
        
        tbl_agente.setModel(modelo);
        tbl_agente.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_agente.getColumnModel().getColumn(1).setPreferredWidth(200);
        
    }
    
    public TelaAgentes() {
       
        initComponents();
        setLocationRelativeTo(null);
        Modo = "Navegar";
        importarCSV("AgentesArq.CSV");
        LoadTableAgente();
        ManipulaInterface();
    }
    public void ManipulaInterface(){
        switch(Modo){
            case "Navegar":
                btn_agente_salvar.setEnabled(false);
                btn_agente_cancelar.setEnabled(false);
                c_agente_codigo.setEnabled(false);
                c_agente_nome.setEnabled(false);
                btn_agente_novo.setEnabled(true);
                btn_agente_editar.setEnabled(true);
                btn_agente_excluir.setEnabled(true);
                break;
            
            case "Novo":
                btn_agente_salvar.setEnabled(true);
                btn_agente_cancelar.setEnabled(true);
                c_agente_codigo.setEnabled(true);
                c_agente_nome.setEnabled(true);
                btn_agente_novo.setEnabled(false);
                btn_agente_editar.setEnabled(false);
                btn_agente_excluir.setEnabled(false);
                break;
                
            case "Editar":
                btn_agente_salvar.setEnabled(true);
                btn_agente_cancelar.setEnabled(true);
                c_agente_codigo.setEnabled(true);
                c_agente_nome.setEnabled(true);
                btn_agente_novo.setEnabled(true);
                btn_agente_editar.setEnabled(false);
                btn_agente_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                btn_agente_salvar.setEnabled(false);
                btn_agente_cancelar.setEnabled(false);
                c_agente_codigo.setEnabled(false);
                c_agente_nome.setEnabled(false);
                btn_agente_novo.setEnabled(true);
                btn_agente_editar.setEnabled(false);
                btn_agente_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                btn_agente_salvar.setEnabled(false);
                btn_agente_cancelar.setEnabled(false);
                c_agente_codigo.setEnabled(false);
                c_agente_nome.setEnabled(false);
                btn_agente_novo.setEnabled(true);
                btn_agente_editar.setEnabled(true);
                btn_agente_excluir.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        btn_agente_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_agente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_agente_nome = new javax.swing.JTextField();
        c_agente_codigo = new javax.swing.JTextField();
        btn_agente_salvar = new javax.swing.JButton();
        btn_agente_cancelar = new javax.swing.JButton();
        btn_agente_novo = new javax.swing.JButton();
        btn_agente_editar = new javax.swing.JButton();
        btn_agente_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_agente_voltar.setText("Voltar");
        btn_agente_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_voltarActionPerformed(evt);
            }
        });

        tbl_agente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_agente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_agenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_agente);
        if (tbl_agente.getColumnModel().getColumnCount() > 0) {
            tbl_agente.getColumnModel().getColumn(0).setPreferredWidth(200);
            tbl_agente.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agentes"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Código:");

        btn_agente_salvar.setText("Salvar");
        btn_agente_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_salvarActionPerformed(evt);
            }
        });

        btn_agente_cancelar.setText("Cancelar");
        btn_agente_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_agente_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(c_agente_nome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_agente_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_agente_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_agente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_agente_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agente_salvar)
                    .addComponent(btn_agente_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_agente_novo.setText("Novo");
        btn_agente_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_novoActionPerformed(evt);
            }
        });

        btn_agente_editar.setText("Editar");
        btn_agente_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_editarActionPerformed(evt);
            }
        });

        btn_agente_excluir.setText("Excluir");
        btn_agente_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_agente_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btn_agente_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_agente_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_agente_voltar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agente_excluir)
                    .addComponent(btn_agente_editar)
                    .addComponent(btn_agente_novo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btn_agente_voltar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agente_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_voltarActionPerformed
        new Menu().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btn_agente_voltarActionPerformed

    private void btn_agente_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_novoActionPerformed
       c_agente_codigo.setText("");
       c_agente_nome.setText("");
       
       Modo = "Novo";
       ManipulaInterface();
       
    }//GEN-LAST:event_btn_agente_novoActionPerformed

    private void btn_agente_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_salvarActionPerformed
        if(Modo.equals("Novo")){  
            Agentes A = new Agentes(c_agente_nome.getText(), c_agente_codigo.getText());
            Login.ListaAgente.add(A);
        }else if(Modo.equals("Editar")){
            int index = tbl_agente.getSelectedRow();
            Login.ListaAgente.get(index).setCodigo(c_agente_codigo.getText());
            Login.ListaAgente.get(index).setNomeAgente(c_agente_nome.getText());
        }
        LoadTableAgente(); 
        Modo = "Navegar";
        ManipulaInterface();
        c_agente_codigo.setText("");
        c_agente_nome.setText("");
        exportarCSV("AgentesArq.CSV");
    }//GEN-LAST:event_btn_agente_salvarActionPerformed

    private void btn_agente_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_cancelarActionPerformed
        c_agente_codigo.setText("");
        c_agente_nome.setText("");
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_agente_cancelarActionPerformed

    private void btn_agente_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_editarActionPerformed
        Modo = "Editar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_agente_editarActionPerformed

    private void tbl_agenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_agenteMouseClicked
        int index = tbl_agente.getSelectedRow();
        if(index>=0 && index<Login.ListaAgente.size()){
            Agentes A = Login.ListaAgente.get(index);
            c_agente_codigo.setText(String.valueOf(A.getCodigo()));
            c_agente_nome.setText(A.getNomeAgente());
            Modo = "Selecao";
            ManipulaInterface();
        }
    }//GEN-LAST:event_tbl_agenteMouseClicked

    private void btn_agente_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_excluirActionPerformed
     int index = tbl_agente.getSelectedRow();
     if(index>=0 && index<Login.ListaAgente.size()){
        Login.ListaAgente.remove(index);}
        LoadTableAgente();
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_agente_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAgentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agente_cancelar;
    private javax.swing.JButton btn_agente_editar;
    private javax.swing.JButton btn_agente_excluir;
    private javax.swing.JButton btn_agente_novo;
    private javax.swing.JButton btn_agente_salvar;
    private javax.swing.JButton btn_agente_voltar;
    private javax.swing.JTextField c_agente_codigo;
    private javax.swing.JTextField c_agente_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_agente;
    // End of variables declaration//GEN-END:variables
}
