package br.com.cyberfestival.model;

/*classe que representa a entidade Ingresso no sistema CyberFestival.*/
public class Ingresso {

    // Atributos privados do ingresso (RN01)
    private String codigoId;
    private String tipo;
    private double valor;

    /*construtor completo para inicializar todos os atributos do Ingresso*/
    public Ingresso(String codigoId, String tipo, double valor) {
        this.codigoId = codigoId;
        this.tipo = tipo;
        this.valor = valor;
    }

    // métodos Getters para acesso aos atributos privados
    public String getCodigoId() {
        return codigoId;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}