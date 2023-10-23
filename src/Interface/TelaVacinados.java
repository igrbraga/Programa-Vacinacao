package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import programavacinacao.Pessoa;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import programavacinacao.Agentes;

/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */
public class TelaVacinados extends javax.swing.JFrame {
        public static void importarCSV(String nomeArq){
           
    try{
        Reader reader = new InputStreamReader(new FileInputStream(nomeArq), "UTF-8");
        BufferedReader entrada = new BufferedReader(reader);
        
        while(entrada.ready()){
        String linha = entrada.readLine();
        String[] info = linha.split(";");
        Login.ListaPessoa.add(new Pessoa(info[0], info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],info[9],info[10]));
        
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

            for (int i = 0; i < Login.ListaPessoa.size(); i++) {
                escrita.write(Login.ListaPessoa.get(i).toCSVPessoa());
            }

            escrita.flush(); // descarga
            escrita.close();

        } catch (IOException ex) {
            System.out.println("erro");
        }
    }
    

    String Modo;
    
    public void LoadTablePessoa(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome","CPF","Data","Número do SUS","Telefone","Rua","Número","Bairro","Sexo","Agente","Dose"},0);
        
        for(int i=0;i<Login.ListaPessoa.size();i++){
            Object linha4[] = new Object[]{Login.ListaPessoa.get(i).getNome(),
                                          Login.ListaPessoa.get(i).getCPF(),
                                          Login.ListaPessoa.get(i).getDataNasc(),
                                          Login.ListaPessoa.get(i).getNumeroSUS(),
                                          Login.ListaPessoa.get(i).getTelefone(),
                                          Login.ListaPessoa.get(i).getRua(),
                                          Login.ListaPessoa.get(i).getNumero(),
                                          Login.ListaPessoa.get(i).getBairro(),
                                          Login.ListaPessoa.get(i).getSexo(),
                                          Login.ListaPessoa.get(i).getAgente(),
                                          Login.ListaPessoa.get(i).getStatus()};
                                          
            modelo.addRow(linha4);
        }
        
        tbl_pessoa.setModel(modelo);
        tbl_pessoa.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbl_pessoa.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_pessoa.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbl_pessoa.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_pessoa.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbl_pessoa.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbl_pessoa.getColumnModel().getColumn(6).setPreferredWidth(50);
        tbl_pessoa.getColumnModel().getColumn(7).setPreferredWidth(80);
        tbl_pessoa.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbl_pessoa.getColumnModel().getColumn(9).setPreferredWidth(150);
        tbl_pessoa.getColumnModel().getColumn(10).setPreferredWidth(80);
        
    }
    


    /**
     * Creates new form Vacinados
     */
    public TelaVacinados() {
        initComponents();
        setLocationRelativeTo(null);
        Modo = "Navegar";
        importarCSV("Pessoas.csv");
        LoadTablePessoa();
        ManipulaInterface();
    }
    
    public void ManipulaInterface(){
        switch(Modo){
            case "Navegar":
                btn_pessoa_salvar.setEnabled(false);
                btn_pessoa_cancelar.setEnabled(false);
                c_pessoa_CPF.setEnabled(false);
                c_pessoa_SUS.setEnabled(false);
                c_pessoa_bairro.setEnabled(false);
                c_pessoa_datanasc.setEnabled(false);
                c_pessoa_nome.setEnabled(false);
                c_pessoa_numero.setEnabled(false);
                c_pessoa_rua.setEnabled(false);
                c_pessoa_telefone.setEnabled(false);
                btn_pessoa_novo.setEnabled(true);
                btn_pessoa_editar.setEnabled(true);
                btn_pessoa_excluir.setEnabled(true);
                c_pessoa_agente.setEnabled(false);
                break;
            
            case "Novo":
                btn_pessoa_salvar.setEnabled(true);
                btn_pessoa_cancelar.setEnabled(true);
                c_pessoa_CPF.setEnabled(true);
                c_pessoa_SUS.setEnabled(true);
                c_pessoa_bairro.setEnabled(true);
                c_pessoa_datanasc.setEnabled(true);
                c_pessoa_nome.setEnabled(true);
                c_pessoa_numero.setEnabled(true);
                c_pessoa_rua.setEnabled(true);
                c_pessoa_telefone.setEnabled(true);
                btn_pessoa_novo.setEnabled(false);
                btn_pessoa_editar.setEnabled(false);
                btn_pessoa_excluir.setEnabled(false);
                c_pessoa_agente.setEnabled(true);
                break;
                
            case "Editar":
                btn_pessoa_salvar.setEnabled(true);
                btn_pessoa_cancelar.setEnabled(true);
                c_pessoa_CPF.setEnabled(true);
                c_pessoa_SUS.setEnabled(true);
                c_pessoa_bairro.setEnabled(true);
                c_pessoa_datanasc.setEnabled(true);
                c_pessoa_nome.setEnabled(true);
                c_pessoa_numero.setEnabled(true);
                c_pessoa_rua.setEnabled(true);
                c_pessoa_telefone.setEnabled(true);
                btn_pessoa_novo.setEnabled(true);
                btn_pessoa_editar.setEnabled(false);
                btn_pessoa_excluir.setEnabled(false);
                c_pessoa_agente.setEnabled(true);
                break;
                
            case "Excluir":
                btn_pessoa_salvar.setEnabled(false);
                btn_pessoa_cancelar.setEnabled(false);
                c_pessoa_CPF.setEnabled(false);
                c_pessoa_SUS.setEnabled(false);
                c_pessoa_bairro.setEnabled(false);
                c_pessoa_datanasc.setEnabled(false);
                c_pessoa_nome.setEnabled(false);
                c_pessoa_numero.setEnabled(false);
                c_pessoa_rua.setEnabled(false);
                c_pessoa_telefone.setEnabled(false);
                btn_pessoa_novo.setEnabled(true);
                btn_pessoa_editar.setEnabled(false);
                btn_pessoa_excluir.setEnabled(false);
                c_pessoa_agente.setEnabled(true);
                break;
                
            case "Selecao":
                btn_pessoa_salvar.setEnabled(false);
                btn_pessoa_cancelar.setEnabled(false);
                c_pessoa_CPF.setEnabled(false);
                c_pessoa_SUS.setEnabled(false);
                c_pessoa_bairro.setEnabled(false);
                c_pessoa_datanasc.setEnabled(false);
                c_pessoa_nome.setEnabled(false);
                c_pessoa_numero.setEnabled(false);
                c_pessoa_rua.setEnabled(false);
                c_pessoa_telefone.setEnabled(false);
                btn_pessoa_novo.setEnabled(true);
                btn_pessoa_editar.setEnabled(true);
                btn_pessoa_excluir.setEnabled(true);
                c_pessoa_agente.setEnabled(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btn_agente_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pessoa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_pessoa_nome = new javax.swing.JTextField();
        c_pessoa_CPF = new javax.swing.JTextField();
        btn_pessoa_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        c_pessoa_datanasc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_pessoa_SUS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_pessoa_telefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_pessoa_rua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        c_pessoa_bairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        c_pessoa_numero = new javax.swing.JTextField();
        btn_pessoa_salvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cb_pessoa_sexo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cb_pessoa_status = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        c_pessoa_agente = new javax.swing.JTextField();
        btn_pessoa_novo = new javax.swing.JButton();
        btn_pessoa_editar = new javax.swing.JButton();
        btn_pessoa_excluir = new javax.swing.JButton();
        btn_consulta_vacinados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_agente_voltar.setText("Voltar");
        btn_agente_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agente_voltarActionPerformed(evt);
            }
        });

        tbl_pessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Data de Nascimento", "Num.  SUS", "Telefone", "Rua", "Número", "Bairro", "Sexo", "Agente", "Dose"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pessoa);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Agentes"));

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        c_pessoa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pessoa_nomeActionPerformed(evt);
            }
        });

        btn_pessoa_cancelar.setText("Cancelar");
        btn_pessoa_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pessoa_cancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de nasc.:");

        c_pessoa_datanasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pessoa_datanascActionPerformed(evt);
            }
        });

        jLabel4.setText("Num. SUS:");

        c_pessoa_SUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pessoa_SUSActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone: ");

        jLabel6.setText("Rua:");

        jLabel7.setText("Número:");

        jLabel8.setText("Bairro: ");

        btn_pessoa_salvar.setText("Salvar");
        btn_pessoa_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pessoa_salvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Agente de Saúde:");

        cb_pessoa_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        cb_pessoa_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pessoa_sexoActionPerformed(evt);
            }
        });

        jLabel10.setText("Sexo:");

        cb_pessoa_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Vacinado", "Primeira Dose", "Segunda Dose" }));

        jLabel11.setText("Dose:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_pessoa_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(425, 425, 425))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_pessoa_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_pessoa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_pessoa_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_pessoa_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(c_pessoa_agente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_pessoa_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_pessoa_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_pessoa_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_pessoa_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_pessoa_status, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_pessoa_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_pessoa_SUS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_pessoa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(c_pessoa_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(c_pessoa_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(c_pessoa_SUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_pessoa_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(c_pessoa_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(c_pessoa_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(c_pessoa_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_pessoa_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cb_pessoa_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(c_pessoa_agente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pessoa_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pessoa_cancelar)))
        );

        btn_pessoa_novo.setText("Novo");
        btn_pessoa_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pessoa_novoActionPerformed(evt);
            }
        });

        btn_pessoa_editar.setText("Editar");
        btn_pessoa_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pessoa_editarActionPerformed(evt);
            }
        });

        btn_pessoa_excluir.setText("Excluir");
        btn_pessoa_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pessoa_excluirActionPerformed(evt);
            }
        });

        btn_consulta_vacinados.setText("Consulta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_agente_voltar)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btn_pessoa_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_pessoa_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_pessoa_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_consulta_vacinados)
                        .addGap(109, 109, 109))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_agente_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pessoa_novo)
                    .addComponent(btn_pessoa_editar)
                    .addComponent(btn_pessoa_excluir)
                    .addComponent(btn_consulta_vacinados))
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Vacinados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agente_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agente_voltarActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agente_voltarActionPerformed

    private void btn_pessoa_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pessoa_salvarActionPerformed
        String Sexo = String.valueOf(cb_pessoa_sexo.getSelectedItem());
        String Status = String.valueOf(cb_pessoa_status.getSelectedItem());

        if(Modo.equals("Novo")){  
            Pessoa P = new Pessoa(c_pessoa_nome.getText(), c_pessoa_CPF.getText(), c_pessoa_datanasc.getText(), c_pessoa_SUS.getText(), c_pessoa_telefone.getText(), c_pessoa_rua.getText(), c_pessoa_numero.getText(), c_pessoa_bairro.getText(), Sexo, c_pessoa_agente.getText(), Status);
            Login.ListaPessoa.add(P);
        }else if(Modo.equals("Editar")){
            int index = tbl_pessoa.getSelectedRow();
            Login.ListaPessoa.get(index).setNome(c_pessoa_nome.getText());
            Login.ListaPessoa.get(index).setCPF(c_pessoa_CPF.getText());
            Login.ListaPessoa.get(index).setDataNasc(c_pessoa_datanasc.getText());
            Login.ListaPessoa.get(index).setNumeroSUS(c_pessoa_SUS.getText());
            Login.ListaPessoa.get(index).setTelefone(c_pessoa_telefone.getText());
            Login.ListaPessoa.get(index).setRua(c_pessoa_rua.getText());
            Login.ListaPessoa.get(index).setNumero(c_pessoa_numero.getText());
            Login.ListaPessoa.get(index).setBairro(c_pessoa_bairro.getText());
            Login.ListaPessoa.get(index).setSexo(Sexo);
            Login.ListaPessoa.get(index).setAgente(c_pessoa_agente.getText());
            Login.ListaPessoa.get(index).setStatus(Status);         
        }
        LoadTablePessoa(); 
        Modo = "Navegar";
        ManipulaInterface();
        c_pessoa_CPF.setText("");
        c_pessoa_SUS.setText("");
        c_pessoa_bairro.setText("");
        c_pessoa_datanasc.setText("");
        c_pessoa_nome.setText("");
        c_pessoa_numero.setText("");
        c_pessoa_rua.setText("");
        c_pessoa_telefone.setText("");
        exportarCSV("Pessoas.csv");
        
    }//GEN-LAST:event_btn_pessoa_salvarActionPerformed

    private void btn_pessoa_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pessoa_cancelarActionPerformed
        c_pessoa_CPF.setText("");
        c_pessoa_SUS.setText("");
        c_pessoa_bairro.setText("");
        c_pessoa_datanasc.setText("");
        c_pessoa_nome.setText("");
        c_pessoa_numero.setText("");
        c_pessoa_rua.setText("");
        c_pessoa_telefone.setText("");
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_pessoa_cancelarActionPerformed

    private void btn_pessoa_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pessoa_novoActionPerformed
        c_pessoa_CPF.setText("");
        c_pessoa_SUS.setText("");
        c_pessoa_bairro.setText("");
        c_pessoa_datanasc.setText("");
        c_pessoa_nome.setText("");
        c_pessoa_numero.setText("");
        c_pessoa_rua.setText("");
        c_pessoa_telefone.setText("");
       
        Modo = "Novo";
        ManipulaInterface();

    }//GEN-LAST:event_btn_pessoa_novoActionPerformed

    private void c_pessoa_SUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pessoa_SUSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pessoa_SUSActionPerformed

    private void c_pessoa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pessoa_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pessoa_nomeActionPerformed

    private void c_pessoa_datanascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pessoa_datanascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pessoa_datanascActionPerformed

    private void cb_pessoa_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pessoa_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pessoa_sexoActionPerformed

    private void btn_pessoa_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pessoa_editarActionPerformed
    Modo = "Editar";
    ManipulaInterface();
    }//GEN-LAST:event_btn_pessoa_editarActionPerformed

    private void btn_pessoa_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pessoa_excluirActionPerformed
 int index = tbl_pessoa.getSelectedRow();
     if(index>=0 && index<Login.ListaPessoa.size()){
            Login.ListaPessoa.remove(index);
        }
        LoadTablePessoa();
        Modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_pessoa_excluirActionPerformed

    private void tbl_pessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pessoaMouseClicked
        int index = tbl_pessoa.getSelectedRow();
        if(index>=0 && index<Login.ListaPessoa.size()){
        Pessoa P = Login.ListaPessoa.get(index);        
        c_pessoa_CPF.setText(P.getCPF());
        c_pessoa_SUS.setText(P.getNumeroSUS());
        c_pessoa_bairro.setText(P.getBairro());
        c_pessoa_datanasc.setText(P.getDataNasc());
        c_pessoa_nome.setText(P.getNome());
        c_pessoa_numero.setText(P.getNumero());
        c_pessoa_rua.setText(P.getRua());
        c_pessoa_telefone.setText(P.getTelefone());
        Modo = "Selecao";
        ManipulaInterface();}
    }//GEN-LAST:event_tbl_pessoaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaVacinados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVacinados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVacinados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVacinados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVacinados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agente_voltar;
    private javax.swing.JButton btn_consulta_vacinados;
    private javax.swing.JButton btn_pessoa_cancelar;
    private javax.swing.JButton btn_pessoa_editar;
    private javax.swing.JButton btn_pessoa_excluir;
    private javax.swing.JButton btn_pessoa_novo;
    private javax.swing.JButton btn_pessoa_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JTextField c_pessoa_CPF;
    private javax.swing.JTextField c_pessoa_SUS;
    private javax.swing.JTextField c_pessoa_agente;
    private javax.swing.JTextField c_pessoa_bairro;
    private javax.swing.JTextField c_pessoa_datanasc;
    private javax.swing.JTextField c_pessoa_nome;
    private javax.swing.JTextField c_pessoa_numero;
    private javax.swing.JTextField c_pessoa_rua;
    private javax.swing.JTextField c_pessoa_telefone;
    private javax.swing.JComboBox<String> cb_pessoa_sexo;
    private javax.swing.JComboBox<String> cb_pessoa_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_pessoa;
    // End of variables declaration//GEN-END:variables
}
