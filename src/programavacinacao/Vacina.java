package programavacinacao;

import java.util.ArrayList;
/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */
public class Vacina {
    private String lote;
    private int quantidade; 
    private String validade;
    private String fabricante;

    public Vacina(String lote, int quantidade, String validade, String fabricante) {
        this.lote = lote;
        this.quantidade = quantidade;
        this.validade = validade;
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String toCSVVacina() {
        return lote +";"+ quantidade +";"+ validade+";"+fabricante+"\n";
    }
}
