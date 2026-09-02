package br.com.cyberfestival.model;

/*exceção personalizada Unchecked para tratar fraudes e duplicidades de ingressos (RN02)*/
public class IngressoInvalidoException extends RuntimeException {

    /*construtor que repassa a mensagem padrão de erro de segurança para a superclasse RuntimeException*/
    public IngressoInvalidoException() {
        super("Erro de Segurança: Ingresso já validado ou código duplicado!");
    }
}