package Fichas.src.Ficha2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Alunos {

  // Construtores

  /**
   * Construtor que inicia os Alunos a null.
   */
  public Alunos() {
    linhas = 0;
    colunas = 0;
    turma = null;
  }

  /**
   * Construtor que cria uma classe Alunos consoante o número de linhas e colunas dadas.
   * A matriz (turma) será inicializada a 0 (zero).
   *
   * @param linhas  Número de alunos.
   * @param colunas Número de cadeiras.
   */
  public Alunos(int linhas, int colunas) {
    this.linhas = linhas;
    this.colunas = colunas;
    this.turma = new int[this.linhas][this.colunas];
  }

  /**
   * Construtor que inicializa uma classe Alunos consoante  uma dada matriz dada.
   *
   * @param v Matriz a ser copiada.
   */
  public Alunos(int[][] v) {
    this.linhas = v.length;
    this.colunas = v[0].length;
    this.turma = new int[this.linhas][this.colunas];
    int j = 0;
    for (int[] v_linhas : v) {
      System.arraycopy(v_linhas, 0, this.turma[j++], 0, v_linhas.length);
    }
  }

  // é suposto ler um file e criar uma classe alunos
  // nao funciona
  public Alunos(String text, int linhas, int colunas) {
    int x = 0, y = 0;
    int[][] turma = new int[linhas][colunas];
    Scanner sc2 = null;
    try {
      sc2 = new Scanner(new File(text));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (sc2.hasNextLine()) {
      Scanner s2 = new Scanner(sc2.nextLine());
      y = 0;
      while (s2.hasNext()) {
        String s = s2.next();

        turma[x][y] = Integer.parseInt(s);
        y++;
      }
      x++;
    }
    this.turma = turma;
    this.colunas = colunas;
    this.linhas = linhas;
  }

  // Variáveis de instânca

  /**
   * Corresponde ao número de alunos existentes.
   */
  private int linhas;
  /**
   * Corresponde ao número de cadeiras existentes.
   */
  private int colunas;
  /**
   * Uma turma.
   * Cada linha corresponde a um determinado aluno.
   * Cada coluna corresponde a uma determinada cadeira.
   */
  private int[][] turma;

  // Métodos de instância

  /**
   * @return Devolve o número de alunos
   */
  public int getLinhas() {
    return linhas;
  }

  /**
   * @return Devolve o número de cadeiras
   */
  public int getColunas() {
    return colunas;
  }

  /**
   * @return Devolve a matriz com os dados.
   */
  public int[][] getTurma() {
    return turma.clone();
  }

  /**
   * Método que devolve uma determinada linha da matriz.
   *
   * @param linha Id de um aluno.
   * @return Devolve as informações de um certo aluno.
   */
  public int[] get_one_Linha(int linha) {
    if (turma != null && linha < turma.length)
      return turma[linha].clone();
    else
      return null;
  }

  /**
   * Método que devolve uma determinada coluna da matriz.
   * Neste caso, devolve toda a informação acerca de uma certa cadeira.
   * Cada índice do array criado correspondera ao id de cada aluno.
   *
   * @param uc Id da cadeira a ser analisada.
   * @return Array com os dados dessa cadeira.
   */
  public int[] get_one_coluna(int uc) {
    if (turma != null && uc < turma[0].length) {
      int[] array = new int[turma.length];
      int i = 0;
      for (int[] aux : this.turma)
        array[i++] = aux[uc];
      return array.clone();
    } else
      return null;
  }

  /**
   * Devolve um determinado elemento da Matriz.
   *
   * @param x O número da linha.
   * @param y O número da coluna.
   * @return Informação correspondente.
   */
  public int getElem(int x, int y) {
    return turma[x][y];
  }

  /**
   * Atualiza apenas o número de cadeiras (colunas).
   *
   * @param colunas Número de cadeiras.
   */
  public void setColunas(int colunas) {
    this.colunas = colunas;
  }

  /**
   * Atualiza apenas o número de alunos (linhas).
   *
   * @param linhas Número de linhas.
   */
  public void setLinhas(int linhas) {
    this.linhas = linhas;
  }

  /**
   * Método que atualiza as informações da classe dada, consoante uma dada matriz.
   *
   * @param turma Matrix com as informações a atualizar.
   */
  public void setTurma(int[][] turma) {
    setLinhas(turma.length);
    setColunas(turma[0].length);
    this.turma = new int[this.linhas][this.colunas];
    int j = 0;
    for (int[] v_linhas : turma) {
      System.arraycopy(v_linhas, 0, this.turma[j++], 0, v_linhas.length);
    }
  }

  // Funcoes

  /**
   * Método que soma todas as notas dos alunos de uma determinada cadeira.
   *
   * @param uc Número da coluna correspondente a essa Uc.
   * @return Inteiro.
   */
  public int somar_notas_cadeira(int uc) {
    int result = 0;
    if (uc < 0 || uc > getColunas()) return result;

    int[] aux = this.get_one_coluna(uc);
    for (int elem : aux)
      result += elem;
    //for(int i=0; i < this.getLinhas(); i++)
    //   result+=getElem(i , uc);
    return result;
  }

  /**
   * Método que cálcula todas as motas de todos os alunos e cadeiras.
   * @return Somatório.
   */
  public int soma_notas(){
    int resul=0;
    if( turma != null ){
      for(int[] linha : getTurma())
        for(int elem: linha)
        resul += elem;
    }
    return resul;
  }

  /**
   * Método que calcula a média de um determinado aluno.
   *
   * @param id Número de identificação do aluno a ser analisado.
   * @return Média.
   */
  public double media_aluno(int id) {
    double resul = 0;
    if (id < 0 || id > getLinhas()) return resul;
    for (int elem : get_one_Linha(id))
      resul += elem;
    return resul / getColunas();
  }

  /**
   * Método que calcula a média de uma determinada cadeira(UC)
   *
   * @param id Número de identificação da cadeira a ser analisada.
   * @return Média.
   */
  public double media_uc(int id) {
    double resul = somar_notas_cadeira(id);
    return resul / getLinhas();
  }

  /**
   * Método que determina a nota mais alta de uma determinada cadeira.
   *
   * @param id Número de identificação da cadeira a ser analisada.
   * @return Nota mais alta.
   */
  public int max_nota_cadeira(int id) {
    int resul = getElem(0, id);
    for (int i = 1; i < getLinhas(); i++) {
      int x = getElem(i, id);
      if (resul < x) resul = x;
    }
    return resul;
  }

  /**
   * Método que determina a nota mais baixa de uma determinada cadeira.
   *
   * @param id Número de identificação da cadeira a ser analisada.
   * @return Nota mais baixa.
   */
  public int min_nota_cadeira(int id) {
    int resul = getElem(0, id);
    for (int i = 1; i < getLinhas(); i++) {
      int x = getElem(i, id);
      if (resul > x) resul = x;
    }
    return resul;
  }

  /**
   * Método que calcula a nota mais alta de cada cadeira.
   *
   * @return Array em que a cada id de uma certa cadeira correspode
   * a sua nota mais elevada.
   */
  public int[] max_nota_cadeiras() {
    int[] array = new int[getColunas()];
    for (int i = 0; i < getColunas(); i++) {
      array[i] = max_nota_cadeira(i);
    }
    return array;
  }

  /**
   * Método que calcula a nota mais baixa de cada cadeira.
   *
   * @return Array em que a cada id de uma certa cadeira correspode
   * a sua nota mais baixa.
   */
  public int[] min_nota_cadeiras() {
    int[] array = new int[getColunas()];
    for (int i = 0; i < getColunas(); i++) {
      array[i] = min_nota_cadeira(i);
    }
    return array;
  }

  /**
   * Método que devolve a nota mais alta desse aluno.
   *
   * @param id Id do respetivo aluno a ser analizado.\
   * @return Inteiro.
   */
  public int max_nota_aluno(int id) {
    return Arrays.stream(get_one_Linha(id)).max().getAsInt();
  }

  /**
   * Método que devolve a nota baixa alta desse aluno.
   *
   * @param id Id do respetivo aluno a ser analizado.\
   * @return Valor.
   */
  public int min_nota_aluno(int id) {
    return Arrays.stream(get_one_Linha(id)).min().getAsInt();
  }

  /**
   * Método que calcula todas as médias de todas as cadeiras.
   * Cada índice do array devolvido, corresponde ao id de uma cadeira.
   * Sendo que o conteúdo de cada posição corresponde à média da cadeira correspondente.
   *
   * @return Array com as médias.
   */
  public int[] media_all_uc() {
    int[] array = new int[getColunas()];
    for (int i = 0; i < getColunas(); i++) {
      array[i] = (int) media_uc(i);
    }
    return array;
  }

  /**
   * Método que determina qual é o indice da cadeira com a média mais elevada.
   *
   * @return Índice
   */
  public int media_max_cadeiras() {
    int[] array = media_all_uc();
    int result = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > result) result = i;
    }
    return result;
  }

  /**
   * Método que devolve todas as notas superios a um dado valor.
   * @param value Valor a ser analisado.
   * @return Array com as notas superiores a esse valor dado.
   */
  public int[] get_notas_acima_de(int value) {
    int[] resul = new int[getColunas()*getLinhas()];
    int i =0;
    for (int[] linha: getTurma()){
      for(int elem : linha){
        if(elem > value)
          resul[i++]=elem;
      }
    }
    int[] final_ = new int[i];
    System.arraycopy(resul, 0, final_, 0, i);
    return final_;
  }

  /**
   * @param args
   * @return
   */
  public int somatorio(int... args) {
    int result = 0;
    for (int elem : args) result += elem;
    return result;
  }

}
