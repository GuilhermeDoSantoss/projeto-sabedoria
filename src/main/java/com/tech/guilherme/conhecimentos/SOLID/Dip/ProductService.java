package com.tech.guilherme.conhecimentos.SOLID.Dip;

public class ProductService {

    MYSQLProductRepository mysqlProductRepository = new MYSQLProductRepository();

    public void showProduct(int id){
        // ir no banco de dados
        this.mysqlProductRepository.findById(id);
    }
}

class MYSQLProductRepository{
    String findById(int id){
        System.out.println("Indo no banco de dados, buscando produto");
        return "Produto " + id;
    }
}
