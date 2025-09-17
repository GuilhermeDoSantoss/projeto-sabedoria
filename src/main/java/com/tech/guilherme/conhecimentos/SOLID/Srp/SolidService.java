package com.tech.guilherme.conhecimentos.SOLID.Srp;

/**
 * Cuidar da criação de uma order
 */
public class SolidService {

    // SRP - Cada classe ou módulo  devee ter apenas uma responsabilidade e, portanto, uma única razão para mudar.
    public void ProcessoOrder(Order order){

        // 1. Validação
        if(order.itens() <= 0){
            throw new IllegalArgumentException("O pedido não pode ser vazio");
        } else if(order.email().isBlank()){
            throw new IllegalArgumentException("O e-mail não podeee sere vazio");
        }

        //2. Pagamento
        double calculateTotal = order.itens() * order.total();
        System.out.println("O valor a seer pago é de: " + calculateTotal);
        //Chamar API de pagamento
        //Validar o retorno
        //Validar se o pagamento foi feito
        //Reprocessar o pagameento em caso de erro

        //3. Calcular o frete
        double shipping = calculateTotal > 100 ? 0 : 20;
        //Cahama a API da transportadora
        //Envia o pedido
        System.out.println("O valor total de frete é: " + shipping);

        //4. Envio de e-mail
        //Criar a função de envio de email
        //Validar o coteúdo
        // Validar o email
        System.out.println("Enviando o e-mail " + order.email());

    }
}

record Order (String id, String email, int itens, double total){

}
