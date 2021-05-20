package Fichas.src.Testes;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.*;

public class teste20180625 {
  public static class parte1 {

    public class TicketSuporte {
      private String nomeO; // quemoriginou o pedido
      private LocalDateTime horaOcorrencia; // instante do report do ticket
      private String assunto;
      private String descricao;
      private String identTecnico; // t´ecnicoqueresolveu o ticket
      private LocalDateTime horaFecho;

      public void setIdentTecnico(String identTecnico) {
        this.identTecnico = identTecnico;
      }

      // instante do fecho do ticket
      // m´etodo queefectua a resolu¸c~ao de um ticket.
//O algoritmo de resolu¸c~aoest´acodificadonestem´etodo.
      public void executaTarefa() {
      }
    }

    public class Tecnico {
      private String ident; // identificador do t´ecnico
      private String nome; // nome do t´ecnico
      private int numTickets; // n´umero de ticketsresolvidos
    }
    public class Supervisor extends Tecnico {
      private List<String> equipa;

      public Supervisor() {
      }
    }

    public class SistemaTickets {
      private Map<String, Tecnico> funcionarios; // funcionarios da empresa
      private List<TicketSuporte> ticketsPorResolver;
      // ticketsainda n~ao tratados
      private List<TicketSuporte> ticketsResolvidos;// tickets j´a satisfeitos

      public void adicionaTicket(TicketSuporte t) {
        ticketsPorResolver.add(t); // por  clone
      }

      public class TecnicoNaoExisteErro extends Exception {
        public TecnicoNaoExisteErro() {
          super();
        }

        public TecnicoNaoExisteErro(String message) {
          super(message);
        }
      }

      public void resolvTicket(String id) throws TecnicoNaoExisteErro {
        if (!funcionarios.containsKey(id))
          throw new TecnicoNaoExisteErro("Tecnico nnao existe\nid: " + id);
        TicketSuporte t = ticketsPorResolver.remove(0);
        t.setIdentTecnico(id);
        t.executaTarefa();
        ticketsResolvidos.add(t);

        this.funcionarios.get(id).numTickets++;
      }

      public Map<String, List<TicketSuporte>> ticketsPorTecnico() {
        Map<String, List<TicketSuporte>> novo = new HashMap<>();
        for (TicketSuporte e : ticketsResolvidos) {
          String id = e.identTecnico;
          List<TicketSuporte> lista;
          if (!novo.containsKey(id)) {
            lista = new ArrayList<>();
          } else lista = novo.get(id);
          lista.add(e);
          novo.put(id, lista);
        }
        return novo;
      }

      public String supervisorTop() {
        String bos = null;
        int max = 0;

        for (Map.Entry<String, Tecnico> e : funcionarios.entrySet()) {
          if (e.getValue() instanceof Supervisor) {
            if (e.getValue().numTickets > max) {
              max = e.getValue().numTickets;
              bos = e.getValue().ident;
            }
          }
          return bos;
        }
        return bos;
      }
  }

  public static class parte2{
    public class Eletrodomestico {
      private String ident;
      private LocalDateTime inicio;
      private LocalDateTime parcial;
      private double consumoLigada;
      private double consumoParcial;
      private boolean estado;

      public Eletrodomestico() {
      }

      public Eletrodomestico (String ident , double consumo) {}
      public void eletrodomesticoOFF() { }

      // liga o eletrodom´estico
      public void EletrodomesticoON () {}
      // desliga o electrodom´estico
      public void EletrodomesticoOFF () {}
      // devolve o consumo desde o in´ıcio
      public double totalConsumo () {return 0;}
      // devolve o consumodesde o ´ultimoreset
      public double periodoConsumo () {return 0;}
      public void efectuarResetConsumo () {}

      protected Eletrodomestico clone() {
        return new Eletrodomestico(this.ident,this.consumoLigada);
      }

    }

    public class EleInteligente extends Eletrodomestico{

      private LocalDateTime turnOn;
      private LocalDateTime turnOff;

      public void turnOn(LocalDateTime d){
        this.turnOn = d;
      }
      public void turnOff(LocalDateTime d){
        turnOff =d;
      }
    }

    public class EleEcologico extends Eletrodomestico{
      private LocalDateTime turnOn;
      private LocalDateTime turnOff;

      public void setPeriodo(LocalDateTime don,LocalDateTime doff){
        turnOff =doff;
        turnOn = don;
      }
    }

    public class SmartHome{
      private Map<String,Eletrodomestico> mapa;

      public SmartHome(Map<String, Eletrodomestico> mapa) {
        this.mapa = new HashMap<>();
        mapa.forEach((key, value) -> this.mapa.put(key, value.clone()));
        // ou seja:
        // for(Map.Entry<String,Eletrodomestico> e: mapa.entrySet()){
        //   this.mapa.put(e.getKey(),e.getValue().clone());
        // }
      }

      public void add (Eletrodomestico e){
        mapa.put(e.ident,e.clone());
      }

      public  void desligaEletrodomestico(String id) throws Exception{
        if(!mapa.containsKey(id))
          throw new Exception("nao ha");
        mapa.get(id).estado=false;
      }
    }
  }
  }
}