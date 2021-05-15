// Parte 1

// (a)
public ListaEleitoral(String partido, Collection<Candidato> candidatos) {
	this.partidoPolitico = partido;
	this.eleitos = new HashSet<>();
	this.porEleger = candidatos.stream()
							   .map(Candidato::clone)
							   .collect(Collectors.toList());
}

// (b)
public Candidato aEleger() {
	// Dever retornar exceção se não houver mais a eleger
	return porEleger.get(0).clone();
}

// (c)
public void elege() {
	eleitos.add(porEleger.remove(0));
}

// (d)
public void elege(int n) {
	for(int i = 0; i < n; i++)
		this.elege();
}

// (e)
public Collection<Candidato> candidatos() {
	List<Candidato> l = new ArrayList<>();

	eleitos.forEach(c -> l.add(c.clone()));
	porEleger.forEach(c -> l.add(c.clone()));

	return l;
}

// Parte 2


// (a) e (b)
// EM Candidato
public int compareTo(Candidato outro) {
	return nome.compareTo(outro.getNome());
}

public TreeSet<Candidato> eleitos() {
	return eletios.stream()
				  .map(Candidato::clone)
				  .collect(Collectors.toCollection(() -> new TreeSet<>()));
}

// (c)
public class ComparaPorIdade implements Comparator<Candidato> {
	public int compare(Candidato c1, Candidato c2) {
		int r = Integer.compare(c1.getIdade(), c2.getIdade());

		// Se a idade for igual, compara por nome
		if(r == 0) {
			r = c1.compareTo(c2);
		}

		return r;
	}
}

public TreeSet<Candidato> eleitosPorIdade() {
	return eletios.stream()
				  .map(Candidato::clone)
				  .collect(Collectors.toCollection(() -> new TreeSet<>(new ComparaPorIdade())));
}

// Parte 3

// EX3

public class LLCandidato {

	private LinkedList<Candidato> ll;

	// (a)
	public LLCandidato() {
		this.ll = new LinkedList<>();
	}

	// (b)
	public int size() {
		return ll.size();
	}

	// (c)
	public void add(Candidato c) {
		ll.add(c.clone());
	}

	// (d)
	public Candidato get(int i) throws CandidatoException {
		if(i > this.size())
			throw new CandidatoException("O candidato que pretende obter é inválido");
		return ll.get(i).clone();
	}

	// (e)
	public boolean(Object o) {
		if(this == o) return true;
		if((o == null) || (this.getClass() != o.getClass())) return false;
		LLCandidato lc = (LLCandidato)o;
		boolean val = ll.size() == lc.size();

		for(int i = 0; i < ll.size() && i < lc.size() && val; i++) {
			if(!ll.get(i).equals(lc.get(i)))
				val = false;
		}

		return val;
	}
}

// Parte 4

// EX4
public class ParqueComRecusados extends Parque implements IParque {

	private Map<String, Set<String>> recusas;

	@Override
	public void entra(String cartao, String matricula)
							throws SemPermissaoException {
		Set<String> strSet;

		try {
			super.entra(cartao, matricula);
		} catch(SemPermissaoException exc) {
			strSet = recusas.get(matricula);

			if(strSet == null)
				strSet = new HashSet<>();

			strSet.add(cartao);

			recusas.put(matricula, strSet);

			throw exc;
		}

	}

}

// Parte 5

// EX5
public double qtsKmsTotal() {
	double total = 0.0;
	Iterator<Empregado> it = empregados.values().iterator();
	Empregado tmp;

	while(it.hasNext()) {
		tmp = it.next();

		if(tmp instanceof Motorista)
			total += ((Motorista)tmp).getNKms();
	}

	return total;
}

// Parte 6

// EX6
/*
A escrita de código para iteradores internos requer menos código e é menos
propenso a erros, com uma escrita sucinta e legível.

Iteradores externos, noutra mão por vezes são mais úteis quando se pretende
trabalhar com várias coleções ao mesmo tempo.
*/