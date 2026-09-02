package br.com.cyberfestival.model;

import java.util.HashMap;
import java.util.Map;

/* Gerenciador da bilheteria responsável por vendas e relatórios de receita*/
public class Bilheteria {

    // banco de dados em memória utilizando a estrutura de chave (codigoId) e valor (Ingresso) (RN03)
    private Map<String, Ingresso> ingressosVendidos;

    /*construtor que inicializa o repositório em memória utilizando HashMap*/
    public Bilheteria() {
        this.ingressosVendidos = new HashMap<>();
    }

    /*
     * vende um ingresso garantindo que não haja duplicidade de código (RN03).
     * 
     * @param ingresso Objeto Ingresso a ser vendido
     * @throws IngressoInvalidoException se o codigoId já tiver sido cadastrado
     */
    public void venderIngresso(Ingresso ingresso) {
        // verifica se a chave (codigoId) já existe no mapa
        if (this.ingressosVendidos.containsKey(ingresso.getCodigoId())) {
            throw new IngressoInvalidoException();
        }
        // registra o ingresso utilizando seu codigoId como chave
        this.ingressosVendidos.put(ingresso.getCodigoId(), ingresso);
    }

    /*
     * calcula o valor total arrecadado com ingressos do tipo "VIP" utilizando Stream API (RN04).
     * 
     * @return Soma dos valores dos ingressos VIP*/
    public double calcularReceitaVIP() {
        // acessa os valores do mapa, filtra por tipo VIP, extrai o valor e soma (sem uso de for ou if)
        return this.ingressosVendidos.values()
                .stream() // inicia a Stream com os ingressos
                .filter(i -> "VIP".equalsIgnoreCase(i.getTipo())) // Filtra apenas o tipo "VIP"
                .mapToDouble(Ingresso::getValor) // Mapeia o objeto Ingresso para seu atributo valor (double)
                .sum(); // realiza a soma de todos os valores filtrados
    }
}