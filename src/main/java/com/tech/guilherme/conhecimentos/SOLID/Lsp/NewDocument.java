package com.tech.guilherme.conhecimentos.SOLID.Lsp;

public interface NewDocument {
        String getContent();
}


interface PrintableDocument extends NewDocument{
    void print();
}

class NewWordDocument implements PrintableDocument{

    @Override
    public void print() {
        System.out.println("Imprimindo do word " + getContent());
    }

    @Override
    public String getContent() {
        return "Conteúdo do word";
    }
}


class NewPDFDocument implements PrintableDocument{

    @Override
    public void print() {
        System.out.println("Imprimindo do PDF " + getContent());
    }

    @Override
    public String getContent() {
        return "Conteúdo do PDF";
    }
}

class NewDigitalOnlyDocument implements NewDocument{

    @Override
    public String getContent() {
        return "Conteúdo do arquivo";
    }
}

class TestNewDocument{
    public static void main(String[] args) {
        PrintableDocument doc = new NewWordDocument();
        doc.print();

        NewDocument newDoc = new NewDigitalOnlyDocument();
        System.out.println(newDoc.getContent());
    }
        }