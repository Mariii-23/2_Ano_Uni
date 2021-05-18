package Fichas.src.Testes;

import java.util.*;

public class teste2018_2019 {
  // exercicio 1
  public static class exer1{
    // coisas dadas
    interface Poly {
      void addMonomio(int grau, double coef);
      double calcula(double x);
      int grau();
      Poly derivada();
    }

    // resolucoes
    public class PolyAsList implements Poly{
      private List<Double> list;

      @Override
      public int grau() {
        return list.size()-1;
      }

      @Override
      public void addMonomio(int grau, double coef) {
        int maiorGrau = grau();

        for(int i = maiorGrau; i<grau; i++)
          this.list.add(0.0);

        double novo = ((list.size()-1) >= grau ) ? this.list.get(grau) + coef : coef;
        this.list.set(grau,novo);
      }

      @Override
      public double calcula(double x) {
        double resul=0;
        int maxSize = grau();
        for(int i=0; i<=maxSize;i++)
          resul += list.get(i)* Math.pow(x,i) ;
        return resul;
      }

      @Override
      public Poly derivada() {
        Poly derivada = new PolyAsList();
        for(int i=0; i<=grau();i++)
          derivada.addMonomio(i, i* list.get(i) );
        return derivada;
      }
    }

    // exercicio 2
    public static class exer2{
      public class Grafo {
        // vari´aveis de inst^ancia
        private Map<String, Set<String>> adj;

        public Grafo(){
          adj = new HashMap<>();
        }

        public Grafo(Map<String,Set<String>> self){
          adj = new HashMap<>();
          for (Map.Entry<String,Set<String>> elem : self.entrySet()){
            Set<String> novo = new HashSet<>();
            Set<String> copiar = elem.getValue();
            for(String s : copiar)
              novo.add(s);
            adj.put(elem.getKey(),novo);
          }
          // ou
          //Iterator<Map.Entry<String, Set<String>>> iter = self.entrySet().iterator();
          //Map.Entry<String,Set<String>> elem;
          //while ( iter.hasNext() ){
          //  elem = iter.next();
          //  Set<String> novo = new HashSet<>();
          //  Set<String> copiar = elem.getValue();
          //  for(String s : copiar)
          //    novo.add(s);
          //  adj.put(elem.getKey(),novo);
          //}
        }

        public void addArco(String vOrig, String vDest){
          Set<String> list = this.adj.containsKey(vOrig) ? this.adj.get(vOrig):
              new HashSet<>();
          list.add(vDest);
          this.adj.put(vOrig,list);
          // adicionar vDest ao graficop caso ele nao exista
          if(!this.adj.containsKey(vDest))
            this.adj.put(vDest,new HashSet<>());
        }

        public boolean isSink(String v){
          boolean isSkink = false;
          if (this.adj.containsKey(v) && !this.adj.get(v).isEmpty())
            isSkink = true;
          return isSkink;
        }

        public int size(){
          int contain=0;
          for(Map.Entry<String,Set<String>> elem : this.adj.entrySet())
            contain+=1+elem.getValue().size();
          return contain;

          // ou
          //int n = adj.size();
          //int m = adj.values().stream().mapToInt(Set::size).sum();
          //return n+m;
        }

        public boolean haCaminho(String vOrig, String vDest){
          boolean haCaminho = false;
          if(!this.adj.containsKey(vOrig) || this.adj.get(vOrig).isEmpty())
            return haCaminho;
          Set<String> grafos = this.adj.get(vOrig);
          Iterator<String> iterator = grafos.iterator();
          String elem;
          while( iterator.hasNext() && !haCaminho){
            elem = iterator.next();
            if(elem.equals(vDest)){
              haCaminho=true;
              break;
            }
            haCaminho = this.haCaminho(elem,vDest);
          }
          return haCaminho;
        }

        //public Set<Map.Entry<String,String>> fanOut (String v){
        //  Set<Map.Entry<String,String>> resul = new HashSet<>();
        //  if(!this.adj.containsKey(v) || this.adj.get(v).isEmpty())
        //    return resul ;
        //  Iterator<String> ola = this.adj.get(v).iterator();
        //  String e = null;
        //  while (ola.hasNext()){
        //    e  = ola.next();
        //    Map<String,String> caminho = new HashMap<>();
        //    resul.add(caminho.entrySet());
        //  }
        //  return resul;
        //}
      }

      public static abstract class ex3{
        double getPrecoBase(){
          return 0;
        }
        double factorQualidade =0;
        double areaPrivativa =0;
        double areaExterior =0;
        double espessuraParede =0;
      }
      public class ex3_ extends ex3{
        // (a)
        // Apartamento
        public double precoDia() {
          return super.getPrecoBase() * factorQualidade;
        }

        // Moradia
        public double precoDia2() {
          return super.getPrecoBase() * (0.3*areaPrivativa + 0.7*areaExterior);
        }

        // Bungalow
        public double precoDia3() {
          return super.getPrecoBase() * (0.5*factorQualidade + 0.5*espessuraParede);
        }
        public class Imovel{

        }
        public class ImovelJaExiste extends Exception{
          public ImovelJaExiste(String e) {
            super(e);
          }
        }
        //
        public void insereImovel(Imovel i) throws ImovelJaExiste{
          // ir buscar
          // se ja existir lancar excepcao
          // senao adicionar

          //if( this.lista_de_coisa.get(i.getCode())!=null  )
          //  throw new ImovelJaExiste("Ja existe um codigo");
          //this.lista_de_coisas.put(codigo, i.clone());
        }

        //public double valorTotalAluguerCliente(String codCliente) {
        //  double r = 0.0;
        //  if(clientes.containsKey(codCliente)) {
        //    r = clientes.values()
        //        .stream()
        //        .map(Cliente::getMeusAlugueres)
        //        .flatMap(List::stream)
        //        .mapToDouble(c -> imoveis.get(c.getCodImovel()).precoDia()*Days.between(c.getInicio(),c.getFim()))
        //        .sum();
        //  }

        //  return r;
        //}

        //// (e)
        //public Map<String, Set<String>> clientesPorImovel() {
        //  return clientes.values()
        //      .stream()
        //      .map(Cliente::getMeusAlugueres)
        //      .flatMap(List::stream)
        //      .collect(
        //          groupingBy(Aluguer::getCodImovel, mapping(Aluguer::getCodCliente, toSet())));
        //}
      }
    }
  }
}
