package ex3;
public class Ex3 {
    public String criaDescricaoConta(String nome,double saldo)
    {
        return "O "+nome+" tem "+ saldo;
    }
    public double eurosParaLibras (double valor,double taxaConversao)
    {
        return valor * taxaConversao;
    }
    public String ex5 (int n1, int n2)
    {
        int maior;
        if (n1 >= n2) maior = n1;
        else maior = n2;
        return "O maior é "+maior+ " e a média e "+(n1+n2)/2;
    }
    public long factorial(int num)
    {
        long fact = 1;
    for (int i = 1; i < num; i++) fact *= i;
    return fact;
    }
    public long tempoGasto(int num)
    {
        long start = System.currentTimeMillis();
        factorial(num);
        long fim = System.currentTimeMillis();
        return fim-start;
    }

}

