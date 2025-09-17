package com.tech.guilherme.conhecimentos.SOLID.Ocp;


public class NewPaymentService {

    public static void main(String[] args) {
        Order order = new Order("1", "email@email.com", 10, 100d);
        CardPlayment card = new CardPlayment();
        card.pay(order);

        PixPayment pix = new PixPayment();
        pix.pay(order);

        BoletoPayment boleto = new BoletoPayment();
        boleto.pay(order);
    }


}

interface PaymentProcess {
    void pay(Order order);
}

class CardPlayment implements PaymentProcess{

    @Override
    public void pay(Order order){
        // Solicitar autorização na bandeira do cartão
        // Recuperar info da autorização
        // Salvar no banco de dados
        System.out.println("Pagamento via cartão");
    }
}

class PixPayment implements PaymentProcess{

    @Override
    public void pay(Order order) {
        // Solicitar autorização junto ao banco para verificar saldo ao cliente
        // Recuperar info da autorização
        // Salvar no banco de dados
        System.out.println("Pagamento com pix");
    }
}

class BoletoPayment implements PaymentProcess{

    @Override
    public void pay(Order order) {
        // TODA REGRA DE NEGÓCIO DE PAGAMENTO VIA BOLETO
        System.out.println("Pagamento com boleto");
    }
}
