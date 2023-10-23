package programavacinacao;

import java.util.ArrayList;

/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */
public class Pessoa {
    private String nome;
    private String CPF;
    private String dataNasc;
    private String numeroSUS;
    private String sexo;
    private String rua;
    private String numero;
    private String bairro;
    private String telefone;
    private String status;
    private String agente;
    
     private ArrayList<Pessoa> ListaPessoa;
     
        public Pessoa() {
        ListaPessoa = new ArrayList();
    }
    public Pessoa(String nome, String CPF, String dataNasc, String numeroSUS, String telefone, String rua, String Numero, String bairro, String sexo, String agente, String Status) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.numeroSUS = numeroSUS;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = Numero;
        this.bairro = bairro;
        this.sexo = sexo;
        this.agente = agente;
        this.status = Status;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNumeroSUS() {
        return numeroSUS;
    }

    public void setNumeroSUS(String numeroSUS) {
        this.numeroSUS = numeroSUS;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
    public String getRua() {
        return rua;
    }

   
    public void setRua(String rua) {
        this.rua = rua;
    }

   
    public String getNumero() {
        return numero;
    }

   
    public void setNumero(String numero) {
        this.numero = numero;
    }

   
    public String getBairro() {
        return bairro;
    }

    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getAgente() {
        return agente;
    }
    public void setAgente(String agente) {
        this.agente = agente;
    }
        public void addPessoa(Pessoa P){
        ListaPessoa.add(P);
    }
        public String toCSVPessoa() {
        return nome +";" +CPF+";" +dataNasc+";" + numeroSUS+";" + telefone+";" + rua+";" + numero+";" + bairro+";" + sexo+";" + agente+";" + status+ "\n";
    }
}
