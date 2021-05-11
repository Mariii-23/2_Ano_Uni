package Fichas.src.Notas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class InterfacesFunctionais {

  public static class Function_example {
    public static class Utils {
      public static Function<Integer, Integer> incIntPorX(Integer inc) {
        return i -> i + inc;
      }
    }

    public static void runFunction() {
      Function<Integer, Function<Integer, Integer>> incrementa = Utils::incIntPorX;

      Function<Integer, Integer> incPor10 = incrementa.apply(10);
      // i-> i + 10
      System.out.println(incPor10.apply(20)); // i = 20

      // ou
      Function<Integer, Function<Integer, Integer>> fIncIntPorX;
      fIncIntPorX = i -> (inc -> i + inc);

      System.out.println(fIncIntPorX.apply(20).apply(10));
    }
  }


  public static class Consumer_Example{
    public static class Pessoa{
      private int age;
      private String name;

      public Pessoa(int age, String name) {
        this.age = age;
        this.name = name;
      }
      public int getAge() {
        return age;
      }
      public void setAge(int age) {
        this.age = age;
      }
      public String getName() {
        return name;
      }
      public void setName(String name) {
        this.name = name;
      }
    }

    public static void acceptAllPessoas(List<Pessoa> ps, Consumer<Pessoa> printPessoa){
      for(Pessoa elem : ps)
        printPessoa.accept(elem);
    }

    public static void run(){
      List<Pessoa> pessoas = new ArrayList<>();
      pessoas.add(new Pessoa(20,"Maria"));
      pessoas.add( new Pessoa(23,"Joao"));

      acceptAllPessoas(pessoas,p-> System.out.println(p.getName()));
      System.out.println("-------------");
      acceptAllPessoas(pessoas,p-> System.out.println(p.getAge()));
    }
  }

  public static class UnaryOperator_Example{
    public  static List<String> mudaString(List<String> list, UnaryOperator<String> func){
      List<String> new_list = new ArrayList<>();
      for(String elem: list)
        new_list.add(func.apply(elem));
      return new_list;
    }

    // funcao q muda o a por z
    public  static UnaryOperator<String> mudaAZ = s->s.replace('a','z');
    // devolve os 2 primeiros caracteres
    public  static UnaryOperator<String> tresFirst =  s-> s.length()>2? s.substring(0,2) : s;

    public static void printAlgo(List<String> list){
      for(String e:list)
        System.out.printf(e +" - ");
    }

    public static void run(){
      List<String> novasPalavras = new ArrayList<>();
      List<String> lista = Arrays.asList("Programar","por","objetos","usando","a","linguagem","java");

      System.out.println("Substituir a por z");
      novasPalavras = mudaString(lista,mudaAZ);
      printAlgo(novasPalavras);

      novasPalavras.clear();
      System.out.println("Primeiros 3 elems");
      novasPalavras = mudaString(lista,tresFirst);
      printAlgo(novasPalavras);
    }
  }

  public static void main(String[] args) {
    System.out.println("Function Example");
    Function_example.runFunction();
    System.out.println("Consumer Example");
    Consumer_Example.run();
    System.out.println("Unary Operator Example");
    UnaryOperator_Example.run();
  }
}