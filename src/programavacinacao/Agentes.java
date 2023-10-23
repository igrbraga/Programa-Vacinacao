package programavacinacao;

import java.util.ArrayList;
/**
 * PROJETO FINAL DE MTP
* @Autores: Gabriel Melo, Igor Braga e Marcio Alexandre.
 */

public class Agentes {

    private String NomeAgente;
    private String codigo;
 
    public Agentes(String NomeAgente, String codigo) {
        this.NomeAgente = NomeAgente;
        this.codigo = codigo;
    }

    public String getNomeAgente() {
        return NomeAgente;
    }

    public void setNomeAgente(String NomeAgente) {
        this.NomeAgente = NomeAgente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   
    
    public String toCSVAgente() {
        return NomeAgente + ";" + codigo + "\n";
    }
}
