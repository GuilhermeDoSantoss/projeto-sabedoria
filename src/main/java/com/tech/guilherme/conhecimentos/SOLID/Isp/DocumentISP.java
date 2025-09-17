package com.tech.guilherme.conhecimentos.SOLID.Isp;


/*
Interface Segregation Principle

As classes não dedvem ser forçadas a implementar (depender) de métodos que elas não irão usar.
Interfaces devem ser pequenas e específicas, para que uma classe não
seja obrigada a implementar métodos que não usa.
 */
public interface DocumentISP {

    void print();
    void scan();
    void fax();
    void sendEmail();
}

class BasicPrint implements DocumentISP{

    @Override
    public void print() {
        System.out.println("Implementado a impressão de documento..");
    }

    @Override
    public void scan() {

    }

    @Override
    public void fax() {

    }

    @Override
    public void sendEmail() {

    }
}

interface Printa{
    void print();
}

interface Faxable{
    void fax();
}

interface Scannable{
    void scan();
}

interface Notification{
    void sendMail();
}


class BasicPrinter implements Printa{
    @Override
    public void print() {
        System.out.println("Implementando a impressão");
    }
}

class MultiPrinter implements Printa, Scannable, Notification {

    @Override
    public void sendMail() {
        System.out.println("Enviando email");
    }

    @Override
    public void print() {
        System.out.println("PRINT..");
    }

    @Override
    public void scan() {
        System.out.println("SCAN..");
    }
}
