package com.app;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        ContaLetras cl = new ContaLetras("Testando o numero de vogais");
        Thread t = new Thread(cl);
        t.start();
    }
}

class ContaLetras implements Runnable {

    String frase;

    public ContaLetras(String frase) {
        this.frase = frase.strip().toLowerCase(Locale.ROOT);
    }

    @Override
    public void run() {
        consoantes(vogais(frase), frase.length());
    }

    public static int vogais(String frase) {
        int numVogais = 0;

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == 'a'||
               frase.charAt(i) == 'e'||
               frase.charAt(i) == 'i'||
               frase.charAt(i) == 'o'||
               frase.charAt(i) == 'u'){
               numVogais++;
            }
        }

        return numVogais;
    }

    public static void consoantes(int numVogais, int numLetras){
        int numConsoantes = numLetras - numVogais;

        System.out.println("Vogais: " + numVogais);
        System.out.println("Consoantes: " + numConsoantes);
    }
}
