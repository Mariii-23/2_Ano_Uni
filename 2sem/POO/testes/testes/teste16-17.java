// Parte 1

// EX1

// (a)
// Assumindo que os getters estão feitos.
public Faixa(Faixa f) {
	nome = f.getNome();
	autor = f.getAutor();
	duracao = f.getDuracao();
	classificacao = f.getClassificacao();
	letra = f.getLetra();
	numeroVezesTocada = f.getNumeroVezesTocada();
	ultimaVez = f.getUltimaVez();
}

// (b)
public boolean equals(Object o) {
	if(this == o) return true;
	if((o == null) || (this.getClass() != o.getClass())) return false;
	Faixa f = (Faixa)o;
	return 	nome.equals(f.getNome()) &&
			autor.equals(f.getAutor()) &&
			Double.compare(duracao,f.getDuracao()) == 0 &&
			classificacao == f.getClassificacao() &&
			letra.equals(f.getLetra()) &&
			numeroVezesTocada == f.getNumeroVezesTocada();
			ultimaVez.equals(f.getUltimaVez());
}

// (c)
public int compareTo(Faixa outraFaixa) {
	return Integer.compare(numeroVezesTocada, outraFaixa.getNumeroVezesTocada());
}

// (d)
// Criar um comparador para faixas e de seguida utilização num algoritmo de ordenação que tenha em conta todas as faixas.
public class ComparaUltimaVez implements Comparator<Faixa> {

	public int compare(Faixa f1, Faixa f2) {
		f1.getUltimaVez().compareTo(f2.getUltimaVez());
	}

}

// EX2

// Metodos privado, só usado como auxiliar noutros metodos.
private List<Faixa> getAutorInfo(String autor) throws AutorInexistenteException {
	List<Faixa> faixas = musicas.get(autor);

	if(faixas == null)
		throw new AutorInexistenteException("O autor " + autor + " não se encontra na base de dados");

	return faixas;
}

private List<Faixa> copyList(List<Faixa> l) {
	return l.stream()
			.map(Faixa::clone)
			.collect(Collectors.toList());
}

private void addFaixa(Faixa f, Map<Integer, List<Faixa>> m) {
	int class = f.getClassificacao();
	List<Faixa> l = m.get(class);

	if(l == null) {
		l = new ArrayList<>();
		l.add(f.clone);
	}

	m.put(class,l);
}

// (a)
public List<Faixa> getFaixas(String autor) throws AutorInexistenteException {
	List<Faixa> faixas = this.getAutorInfo(autor);
	return this.copyList(faixas);
}

// (b)
public double tempoTotal(String autor) throws AutorInexistenteException {
	List<Faixa> faixas = this.getAutorInfo(autor);
	return fixas.stream()
				.mapToDouble(Faixa::getDuracao)
				.sum();
}

// Parte 2
// EX3

// (a)
public List<Faixa> todasAsFaixas() {
	List<Faixas> l = new ArrayList<>();
	musicas.forEach((k, v) -> l.addAll(this.copyList(v)));
	return l;
}

// (b)
public Map<Integer, List<Faixa>> faixasPorClass() {
	Map<Integer, List<Faixa>> class = new HashMap<>()
	musicas.values().stream()
					.forEach( k -> k.stream()
									.forEach(f -> this.addFaixa(f, class)));
}

// (c)
public class Faixa implements Playable {
	// ...

	public void play() {
		letra.forEach(s -> System.audio.play(s));
	}

	// ...
}

// EX4

// (a), (b) e (c)
public class MusicaComVideo extends Faixa implements Playable {
	String carateres;

	public MusicaComVideo(String nome, String autor, double duracao,
						 int classificacao, ArrayList<String> letra,
						 int numeroVezesTocada, LocalDateTime ultimaVez,
						 String carateres) {
		super(nome, autor, duracao, classificacao, letra, numeroVezesTocada, ultimaVez);
		this.carateres = carateres.clone();
	}

	// ...

	public void play() {
		System.out.println(carateres);
		super.play();
	}

	// ...
}

// Parte 3

// (a)
public class AgenciaViagens {
	Map<String, Integer> nifClientes;
	Map<String, Hotel> parceiras;

	// ...
}

// (b)
public void gravaFicheiroHoteisUsados(String fichtxt, String tipo) throws IOEception {
	BufferedWriter bw = new BufferedWriter(new FileWriter(fichtxt));

	parceiras.values().stream()
					  .filter(h -> h.getClass().getSimpleName().equals(tipo))
					  .filter(h -> nifClientes.get(h.getCodigo()).size() > 0);
					  .forEach(h -> bw.append(h.getCodigo()));

	bw.close();
}

// (c) e (d)
// Para funcionar o hotel e agencia de viagens devem ambos implementar o interface Serializable
public class AgenciaViagens implements Serializable {

	// ...

	public AgenciaViagens buildAgencia(String fich) {
		AgenciaViagens agencia = null;

		try {
			FileOuputStream file = new FileInputStream(fich);
			ObjectInputStream in = new ObjectInputStream(file);

			agencia = (AgenciaViagens)in.readObject();

			in.close();
			file.close();
		}
		catch(Exception ex) {
			agencia = new AgenciaViagens();
		}
	}

	// ...

}
