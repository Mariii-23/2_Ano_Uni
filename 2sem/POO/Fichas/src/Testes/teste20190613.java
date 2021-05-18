package Fichas.src.Testes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class teste20190613 {
  public static class Parte2 {
    public abstract class Actividade implements Serializable, Comparable<Actividade> {
      private String designacao;
      private double caloriasPorUnidadeTreino; // calorias

      public String getDesignacao() {
        return designacao;
      }

      public double getCaloriasPorUnidadeTreino() {
        return caloriasPorUnidadeTreino;
      }

      // por unidade de treino
      public abstract double caloriasGastas(); //o consumo de
      // calorias depende de cadaactividadeespec´ıfica


      @Override
      public int compareTo(Actividade o) {
        return (int) (this.caloriasGastas() - o.caloriasGastas());
      }
    }

    public class Corrida extends Actividade implements ComDistancia {
      private double kmsPercorridos;
      private double elevacao;
      private double velocidade;

      @Override
      public double caloriasGastas() {
        return (1 + 0.25 * kmsPercorridos) * getCaloriasPorUnidadeTreino();
      }

      @Override
      public double getKmsPercorridos() {
        return kmsPercorridos;
      }
    }

    public class Eliptica extends Actividade implements ComDistancia {
      private double kmsPercorridos;
      private double nivelEsforco;
      private double minutos;

      @Override
      public double caloriasGastas() {
        return kmsPercorridos * getCaloriasPorUnidadeTreino() +
            minutos * ((nivelEsforco < 4 ? 0.20 : 0.5 * nivelEsforco) * getCaloriasPorUnidadeTreino());
      }

      @Override
      public double getKmsPercorridos() {
        return kmsPercorridos;
      }
    }

    public class Abdominais extends Actividade {
      private int numeroRepeticoes;
      private String tipoExercicio;

      @Override
      public double caloriasGastas() {
        return numeroRepeticoes * getCaloriasPorUnidadeTreino();
      }
    }

    public class Cliente implements Serializable {
      private String nome;
      private String codCliente;
      private Map<LocalDate, List<Exercicio>> meusExercicios;

      public String getNome() {
        return nome;
      }

      public String getCodCliente() {
        return codCliente;
      }

      public Map<LocalDate, List<Exercicio>> getMeusExercicios() {
        return meusExercicios;
      }
    }

    public class Exercicio implements Serializable {
      private Actividade actividade;
      private String professor;
      private String codExercicio;

      public Actividade getActividade() {
        return actividade;
      }
    }

    public interface ComDistancia {
      public double getKmsPercorridos();
    }

    public class NAOexisteCliente extends Exception {
      public NAOexisteCliente() {
        super();
      }

      public NAOexisteCliente(String message) {
        super(message);
      }
    }

    public class NAOexisteExercicio extends Exception {
      public NAOexisteExercicio() {
        super();
      }

      public NAOexisteExercicio(String message) {
        super(message);
      }
    }

    public class GinasioPOO implements Serializable {
      private Map<String, Cliente> clientes;

      public double valorTotalCaloriasGastas(String cod) throws NAOexisteCliente {
        double resul = 0;
        if (!clientes.containsKey(cod))
          throw new NAOexisteCliente("Cliente nao existe");

        //stream
        //resul += clientes.get(cod).getMeusExercicios().values().stream().flatMap(Collection::stream).map(Exercicio::getActividade).mapToDouble(Actividade::caloriasGastas).sum();

        for (List<Exercicio> l : clientes.get(cod).getMeusExercicios().values()) {
          for (Exercicio e : l) {
            Actividade a = e.getActividade();
            resul += a.caloriasGastas();
          }
        }
        return resul;
      }

      public double totalKmsCliente(String codCliente, LocalDate dataExercicio) throws NAOexisteCliente, NAOexisteExercicio {
        double resul = 0;
        if (!clientes.containsKey(codCliente))
          throw new NAOexisteCliente("Cliente nao existe");

        Map<LocalDate, List<Exercicio>> c = clientes.get(codCliente).getMeusExercicios();

        if (!c.containsKey(dataExercicio))
          throw new NAOexisteExercicio("Nao existe nada nessa data");

        //resul = c.get(dataExercicio).stream().flatMap(Collection::stream).map(Exercicio::getActividade).filter(e->)
        for (Exercicio e : clientes.get(codCliente).getMeusExercicios().get(dataExercicio)) {
          if (e instanceof ComDistancia) {
            resul += ((ComDistancia) e).getKmsPercorridos();
          }
        }
        return resul;
      }

      public boolean existeProfessor(String prof) {
        Boolean resul = false;

        for (Cliente e : clientes.values()) {
          for (List<Exercicio> l : e.getMeusExercicios().values()) {
            for (Exercicio exercicio : l) {
              if (exercicio.professor.equals(prof))
                return (resul = true);
            }
          }
        }
        return resul;
      }

      public Map<String, List<Exercicio>> exerciciosPorProf() {
        Map<String, List<Exercicio>> resul = new HashMap<>();

        for (Cliente e : clientes.values()) {
          for (List<Exercicio> l : e.getMeusExercicios().values()) {
            for (Exercicio exercicio : l) {
              List<Exercicio> lista = null;
              if (resul.containsKey(exercicio.professor)) {
                lista = resul.get(exercicio.professor);
              } else {
                lista = new ArrayList<>();
              }
              lista.add(exercicio);
              resul.put(exercicio.professor, lista);
            }
          }
        }
        resul.values().stream().sorted();
        return resul;
      }

      public String profMaisExigente() {
        String resul = null;
        double maior = 0;
        Map<String, List<Exercicio>> map = exerciciosPorProf();
        for (Map.Entry<String, List<Exercicio>> aux : map.entrySet()) {
          double sera_maior = aux.getValue().stream().mapToDouble(e -> e.getActividade().caloriasGastas()).sum();
          if (sera_maior > maior) {
            resul = aux.getKey();
            maior = sera_maior;
          }
        }
        return resul;
      }

      public class GrowingArrayOfActividade implements Serializable, Comparable {
        // vari´aveis de inst^ancia
        private Actividade[] lista;
        private int tamanho;

        @Override
        public int compareTo(Object o) {
          return 0;
        }

        public Actividade get(int indice) throws IndexOutOfBoundsException{
          return this.lista[indice];
        }

        public void add(Actividade a){
          Actividade[] ola = new Actividade[lista.length+1];
          System.arraycopy(lista, 0, ola, 0, lista.length);
          ola[lista.length]=a;
          lista = ola;
        }
      }
      public GrowingArrayOfActividade toInput(String name) throws Exception{
        GrowingArrayOfActividade result = null;
          ObjectInputStream is = new ObjectInputStream(new FileInputStream(name));
          result = (GrowingArrayOfActividade) is.readObject();
          is.close();
        return result;
      }
    }
  }
}