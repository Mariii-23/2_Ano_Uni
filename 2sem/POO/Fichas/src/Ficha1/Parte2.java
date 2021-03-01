package Ficha1;
import java.util.Scanner;

/**
 * Parte 2 da Ficha 1
 *@author Mari
 *@version 0.0
 **/
public class Parte2 {
    /**
     *Métodos para converter Celsius para Farnheit
     *@param graus Temperatura em graus Celsius
     *@return Temperatura em Farnheit
     */
    public double celsiusParaFarenheit(double graus) {
        double farenheit= graus * 1.8 + 32;
        System.out.println(graus+"(graus) -> "+farenheit+" (farenheit)");
        return farenheit;
    }

    /**
     * Determinar o máximo entre dois números
     * @param a Um número
     * @param b Um número
     * @return Máximo.
     * */
    public int maximoNumeros(int a, int b){
        int max= a>b ? a : b;
        System.out.println("O valor máximo entre "+a+" e "+b+" é "+max+".");
        return max;
    }

    /**
     * Método que imprime um nome junto com o saldo
     * @param nome Nome da pessoa a analisar
     * @param saldo Saldo da pessoa
     * @return String com os dados juntos*/
    public String criaDescricaoConta(String nome, double saldo){
        String result = "Senhor(a) " + nome + " o seu saldo é de " + saldo+ " (euros).";
        return result;
    }

    /**
     * Métodos para converter euros em libras
     * @param valor Valor a conveter
     * @param taxaConversao Taxa de conversao
     * @return O valor dado convertido em libras
     * */
    public double eurosParaLibras(double valor, double taxaConversao){
        double resul = (valor*taxaConversao);
        System.out.println(valor + " (euros) -> "+resul+" (libras)");
        return resul;
    }

    /**
     * Método que irá ler dois números, irá escreve-los por ordem decrescente e apresentar a sua média
     * @return void
     */
    public void read_media(){
        Scanner input = new Scanner(System.in); // lê do teclado
        System.out.print("Introduza o primeiro número: ");
        Double num1 = input.nextDouble();
        System.out.print("Introduza o segundo número: ");
        Double num2 = input.nextDouble();
        Double media = (num1+num2)/2d;

        if ( num1 > num2 )
            System.out.println("Os números introduzidos foram: " + num2 + num1 +".");
        else
            System.out.println("Os números introduzidos foram: " + num1 + " e " + num2 +".");
        System.out.println("Sendo a média de: "+media+".");
    }

    /**
     * Método que devolve o fatorial de um determinado número dado
     * @param num Número
     * @return Fatorial do número recebido
     */
    public long factorial(int num){
        long fact=1;
        for(long i = 1; i <= num; i++) fact *= i;
        System.out.println("O fatorial do número "+num+" é "+fact);
        return fact;
    }

    /**
     * Método que determina o tempo que é necessário a calcular o fatorial de 5000.
     */
    public long tempoGasto(){
        long time_start = System.currentTimeMillis();
        factorial(5000);
        long time_end = System.currentTimeMillis();
        long ciclo = time_end - time_start;
        System.out.println("O tempo de execução do fatorial de 5000 foi de "+ciclo);
        return ciclo;
    }
}

