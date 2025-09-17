package com.tech.guilherme.conhecimentos.SOLID.Srp;
// Single Responsabillity Principle (Princípio da reesponsabilidade única)

public class NewOrderService {

    public void processOrder(NewOrder order){
       boolean isValid = ValidatorOrder.isValid(order);
       if(!isValid) throw new IllegalArgumentException("Erro no processsamento no order");

       PaymentOrder.processsPay(order);
       ShippingOrder.calculateSphipping(order.total());
       SendNotification.sendEmail(order);

    }

}

class ValidatorOrder{
    public static boolean isValid(NewOrder order){
        if(order.itens() <= 0){
            return false;
        } else if(order.email().isBlank()){
            return false;
        }

        return true;
    }
}

class PaymentOrder{
    static double processsPay(NewOrder order){
        double calculateTotal = order.itens() * order.total();
        return calculateTotal;
    }
}

class ShippingOrder{
    static double calculateSphipping(double total){
        return total > 100 ? 0 : 20;
    }
}

class SendNotification{
    static void sendEmail(NewOrder order){
        System.out.println("Enviando o e-mail " + order.email());
    }
}

record NewOrder(String email, int itens, double total){

}
