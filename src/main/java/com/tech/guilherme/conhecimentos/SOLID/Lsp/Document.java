package com.tech.guilherme.conhecimentos.SOLID.Lsp;

// Liskov Substituion Principle (Princípio de Substituição de Liskov)

// Se você tem uma classe do tipo S que é subtipo de t,
// então eu posso substituir T por S sem ter o funcionamento da minha aplicação sendo afetada

// Objetos de uma classe derivada devem poder substituir
// objetos da classe base sem quebrar o comportamento esperado

public class Document {
    public void print(){
        System.out.println("Imprimindo um doc");
    }
}

class WordDocument extends Document{

    @Override
    public void print(){
        System.out.println("Imprimindo um Word");
    }
}

class PDFDocument extends Document{

    @Override
    public void print(){
        System.out.println("Imprimindo um PDF");
    }
}

class DigitalOnlyDocument extends Document{
    @Override
    public void print(){
        throw new IllegalArgumentException("O documento não podde ser impresso");
    }
}

class TestDocument{
    public static void main(String[] args) {
        Document doc = new PDFDocument();
        doc.print();
    }
}