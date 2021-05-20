package Fichas.src.Testes;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Try {

  public abstract class animal{
    public animal() { }

  }

  public class guarda_tudo{

    private Map<String,animal> map;
    //private Map<String, List<String>> algo;

    public List<? extends animal>  devolve_so_dessa_coisa(Class<? extends  animal> classe){
      // List<? extends animal> lista = new ArrayList<>();
      //return this.map.values().stream().filter(e-> classe.isInstance(e) ).map(e-> classe.cast(e).clone() ).collect(Collectors.toList());
      return this.map.values().stream().filter(e-> classe.isInstance(e) ).map(e-> classe.cast(e) ).collect(Collectors.toList());
    }

    public List<animal>  devolve_so_dessa_coisa(String classe){
      List<animal> lista = new ArrayList<>();
      this.map.values().stream().filter(e-> e.getClass().getSimpleName().equals(classe)).map(e->lista.add( e )).collect(Collectors.toList());
      return lista;
    }
  }


  public class cao extends animal{
    public cao() {super(); }

    public cao clone(cao ola){
      return new cao();
    }
  }

  public class gato extends animal{
    public gato() {super(); }

    public gato clone(gato ola){
      return new gato();
    }
  }
}
