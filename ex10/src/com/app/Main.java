package com.app;

public class Main {

    public static void main(String[] args) {
        Calcula soma = new Calcula(15, 20, "soma");
        Calcula sub = new Calcula(15, 20, "sub");
        Calcula mult = new Calcula(15, 20, "mult");
        Calcula div = new Calcula(15, 20, "div");

        Thread t1 = new Thread(soma);
        Thread t2 = new Thread(sub);
        Thread t3 = new Thread(mult);
        Thread t4 = new Thread(div);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Calcula implements Runnable {

    double n1, n2;
    String operacao;

    public Calcula(double n1, double  n2, String operacao) {
        this.n1 = n1;
        this.n2 = n2;
        this.operacao = operacao;
    }

    @Override
    public void run() {
        calculo(this.n1, this.n2, this.operacao);
    }

    public static void calculo(double n1, double n2, String operacao) {
        double resultado = 0;

        switch (operacao){
            case "soma":
                resultado = n1 + n2;
                break;
            case "sub":
                resultado = n1 - n2;
                break;

            case "mult":
                resultado = n1 * n2;
                break;

            case "div":
                resultado = n1 / n2;
                break;
        }
        System.out.println(operacao + ": " + resultado);
    }
}
