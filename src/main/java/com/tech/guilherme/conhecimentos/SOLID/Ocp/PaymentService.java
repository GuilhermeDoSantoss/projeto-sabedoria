package com.tech.guilherme.conhecimentos.SOLID.Ocp;
// Open-Closed Principle (Princípio da responsabilidade única)


import org.hibernate.query.Order;

public class PaymentService {

    public void processPayment(Order order, String method) {
        if ("card".equalsIgnoreCase(method)) {
            // Solicitar autorização na bandeira do cartão
            // Recuperar info da autorização
            // Salvar no banco de dados
            System.out.println("Pagamento com cartão");
        } else if ("pix".equalsIgnoreCase(method)) {
            // Solicitar autorização junto ao banco para verificar saldo ao cliente
            // Recuperar info da autorização
            // Salvar no banco de dados
            System.out.println("Pagamento com pix");
        } else if ("boleto".equalsIgnoreCase(method)) {
            // TODA REGRA DE NEGÓCIO DE PAGAMENTO VIA BOLETO
            System.out.println("Pagamento com boleto");


        }
    }
}

record NewOrder(String email, int itens, double total){
}