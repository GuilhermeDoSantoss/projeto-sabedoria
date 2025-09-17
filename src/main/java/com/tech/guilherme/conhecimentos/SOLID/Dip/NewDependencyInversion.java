package com.tech.guilherme.conhecimentos.SOLID.Dip;

public class NewDependencyInversion {

    public static void main(String[] args) {
        ProductRepository repository = new newMySQLProductRepository();
        NewProductService productService = new NewProductService(repository);
        productService.showProduct(1);
    }

}

class NewProductService{

    private ProductRepository productRepository;

    public NewProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void showProduct(int id){
        this.productRepository.findById(id);
    }
}

interface ProductRepository{
    String findById(int id);
}

class newMySQLProductRepository implements ProductRepository{

    @Override
    public String findById(int id) {
        System.out.println("Indo no banco de dados, buscando produto");
        return "Produto " + id;
    }
}
