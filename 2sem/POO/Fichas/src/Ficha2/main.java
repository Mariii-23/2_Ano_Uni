package Ficha2;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        //String path = "./Ficha2/notas.txt";
        //String path = "notas.txt";

        int linhas=20,colunas=6;

        int[][] array = new int[linhas][colunas];
        int i,j;
        for(i=0; i<linhas;i++){
            for(j=0; j<colunas;j++)
                array[i][j]=i+j;
        }

        int id_aluno = 0;
        int id_uc = 0;
        int voltas = 0;

        Alunos Alunos = new Alunos(array);

        while(voltas==0 || voltas==1){
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("ALUNOS -> "+linhas+" $$ CADEIRAS -> "+colunas);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

            // Testar Uma coluna
            System.out.println("Coluna "+id_uc+" da matrix Turma:");
            System.out.println(Arrays.toString(Alunos.get_one_coluna(id_uc)));
            System.out.println();
            // Nota maxima e mínima dessa cadeira
            System.out.println("Nota mínima da cadeira com id: "+id_uc+" -> "+ Alunos.min_nota_cadeira(id_uc));
            System.out.println("Nota máxima da cadeira com id: "+id_uc+" -> "+ Alunos.max_nota_cadeira(id_uc));
            System.out.println();
            // Somar todos os elementos de uma cadeira.
            System.out.println("Soma de todas as notas da cadeira com id = "+id_uc+" : "+ Alunos.somar_notas_cadeira(id_uc));
            // Media dessa cadeira
            System.out.println("Média das notas da cadeira com id = "+id_uc+" : "+ Alunos.media_uc(id_uc));
            System.out.println();

            // Notas de um aluno
            System.out.println("Aluno "+id_aluno+" da matrix Turma:");
            System.out.println(Arrays.toString(Alunos.get_one_Linha(id_aluno)));
            System.out.println();

            // Nota maxima e mínima desse aluno
            System.out.println("Nota mínima desse aluno com id: "+id_uc+" -> "+ Alunos.min_nota_aluno(id_aluno));
            System.out.println("Nota máxima desse aluno com id: "+id_uc+" -> "+ Alunos.max_nota_aluno(id_aluno));

            // Média das notas do aluno
            System.out.println("Média das notas do aluno com id = "+id_aluno+" : "+ Alunos.media_aluno(id_aluno) + "\n");
            System.out.println();

            // Array com as medias das ucs
            System.out.println("Média de todas as cadeiras:");
            System.out.println(Arrays.toString(Alunos.media_all_uc()));

            System.out.println("Notas MÁXIMAS de todas as cadeiras:");
            System.out.println(Arrays.toString(Alunos.max_nota_cadeiras()));
            System.out.println("O índice com a média mais elevada é -> "+Alunos.media_max_cadeiras());
            System.out.println("Notas MÍNIMAS de todas as cadeiras:");
            System.out.println(Arrays.toString(Alunos.min_nota_cadeiras()));
            System.out.println();


            linhas=5; colunas=10;
            id_aluno=2;
            id_uc=4;
            array = new int[linhas][colunas];
            for(i=0; i<linhas;i++){
                for(j=0; j<colunas;j++)
                    array[i][j]=i;
            }
            Alunos.setTurma(array);
            voltas++;
        }

        //int x=0,y=0;
        //Scanner sc2 = null;
        //try {
        //    sc2 = new Scanner(new File((new File(System.getProperty("./Ficha2"))),"notas.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        //while (sc2.hasNextLine() && x<linhas) {
        //    Scanner s2 = new Scanner(sc2.nextLine());
        //    y=0;
        //    while (s2.hasNext() && y<colunas) {
        //        String s = s2.next();
        //        System.out.print(s);
        //        y++;
        //    }
        //    x++;
        //}

        // Scanner sc2 = null;
       // try {
       //     sc2 = new Scanner(new File((new File(System.getProperty("./Ficha2"))),"notas.txt"));
       // } catch (FileNotFoundException e) {
       //     e.printStackTrace();
       // }
       // while (sc2.hasNextLine()) {
       //     String string = new sc2.nextLine();
       //     String[] words = string.split(" ");
       //     from (String s : words)
       //         System.out.println(s);
       // }

        //String path = "/home/mari/2_Ano_Uni/2sem/POO/Fichas/src/Ficha2/notes.txt";

    }
}
