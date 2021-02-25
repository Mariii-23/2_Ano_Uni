package ex3;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Ex3 f = new Ex3();

      /*  //pergunta3
        System.out.println("Introduz nome:");
        String n1 = scanner.next();
        System.out.println("Introduza valor:");
        int n2 = scanner.nextInt();

        String maior = f.criaDescricaoConta(n1,n2);
        System.out.println(maior); */
        //pergunta 4
        /*
        System.out.println(" Introdus valor: ");
        double n1 = scanner.nextDouble();
        System.out.println("Introduza valor:");
        double n2 = scanner.nextDouble();

        double maior = f.eurosParaLibras(n1,n2);
        System.out.println("São "+maior+ "euros");
        */
        //pergunta 5

/*        System.out.println(" Introdus valor: ");
        int n1 = scanner.nextInt();
        System.out.println("Introduza valor:");
        int n2 = scanner.nextInt();

        String maior = f.ex5(n1,n2);
        System.out.println(maior); */

        //pergunta 6 e 7

        long maior = f.tempoGasto(Integer.parseInt(args[1]));
        System.out.println("Tempo gasto "+maior);
    }
}


