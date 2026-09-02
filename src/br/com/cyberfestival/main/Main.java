package br.com.cyberfestival.main;

import br.com.cyberfestival.model.Bilheteria;
import br.com.cyberfestival.model.Ingresso;
import br.com.cyberfestival.model.IngressoInvalidoException;

/* classe principal para execução dos testes automatizados da aplicação*/
public class Main {

    public static void main(String[] args) {
        // 1. instanciar o motor da Bilheteria
        Bilheteria bilheteria = new Bilheteria();

        // 2. criação dos ingressos para teste
        Ingresso ing1 = new Ingresso("A-01", "VIP", 500.00);
        Ingresso ing2 = new Ingresso("A-02", "PISTA", 200.00);
        Ingresso ing3Clone = new Ingresso("A-01", "PISTA", 200.00); // Tentativa de fraude (código A-01 duplicado)

        // 3. venda dos ingressos válidos
        bilheteria.venderIngresso(ing1);
        bilheteria.venderIngresso(ing2);
        System.out.println("Ingressos 1 e 2 vendidos com sucesso!");

        // 4. teste de falha (tentativa de vender o cambista)
        try {
            bilheteria.venderIngresso(ing3Clone);
        } catch (IngressoInvalidoException e) {
           
            System.out.println("Alerta de Exceção Capturado: " + e.getMessage());
        }

        // 5. teste da Stream API: Exibir a receita total apenas dos ingressos VIP
        double receitaVIP = bilheteria.calcularReceitaVIP();
        System.out.println("Receita Total de Ingressos VIP: R$ " + receitaVIP);
    }
}