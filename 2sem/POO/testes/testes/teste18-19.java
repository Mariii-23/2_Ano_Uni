// Parte 1

// EX1

public interface Poly {
	void addMonomio(double coef, int grau);
	double calcula(double x);
	Poly derivada();
}

public class PolyAsList implements Poly {
	private List<Double> poly;

	public void addMonomio(double coef, int grau) {
		double val;
		int maxGrau = poly.size() - 1;

		// extende até o grau indica no argumento
		for(int i = maxGrau; i < grau; i++)
			poly.add(0.0);

		val = poly.get(grau) + coef;
		poly.add(grau, val);
	}

	public double calcula(double x) {
		int maxGrau, r = 0.0;
		maxGrau = poly.size() - 1;

		for(int i = 0; i <= maxGrau; i++)
			r += poly.get(i) * Math.pow(x, i);

		return r;
	}

	public Poly derivada() {
		Poly pe = new PolyAsList();
		int maxGrau = poly.size();

		for(int i = 1; i <= maxGrau; i++)
			pe.addMonomio(poly.get(i) * i, i - 1);

		return pe;
	}
}

// Parte 2

// EX2

// (a)
// Em Apartamento
public double precoDia() {
	return super.getPrecoBase() * factorQualidade;
}

// Em Moradia
public double precoDia() {
	return super.getPrecoBase() * (0.3*areaPrivativa + 0.7*areaExterior)
}

// Em Bungalow
public double precoDia() {
	return super.getPrecoBase() * (0.5*factorQualidade + 0.5*espessuraParede);
}

// (b)
public class ImovelNaoExistente extends Exception {
	public class ImovelNaoExistente(String msg) {
		super(msg)
	}
}

public Imovel getImovel(String codImovel) throws ImovelNaoExistente {
	Imovel v = imoveis.get(codImovel);

	if(v == null)
		throw new ImovelNaoExistente("Nao existe imovel com codigo " + codImovel);

	return v.clone();
}

// (c)
public double valorTotalAluguerCliente(String codCliente) {
	double r = 0.0;

	if(clientes.containsKey(codCliente)) {
		r = clientes.values()
					.stream()
					.map(Cliente::getMeusAlugueres)
					.flatMap(List::stream)
					.mapToDouble(c -> imoveis.get(c.getCodImovel()).precoDia()*Days.between(c.getInicio(),c.getFim()))
					.sum();
	}

	return r;
}

// (d)
public Map<String, Set<String>> clientesPorImovel() {
	return clientes.values()
				   .stream()
				   .map(Cliente::getMeusAlugueres)
				   .flatMap(List::stream)
				   .collect(
				   		groupingBy(Aluguer::getCodImovel, mapping(Aluguer::getCodCliente, toSet())));
}

// Parte 3

// EX3
public class Imovel implements Serializable, Comparable {
	// ...
	public int compareTo(Imovel outro) {
		return Double.comapre(this.precoDia(), outro.precoDia());
	}
	// ...
}

// EX4
public class comparaTipoArea implements Comparator<Imovel> {
	public int compare(Imovel i1, Imovel i2) {
		int r = i1.getClass().getSimpleName().compareTo(i2.getClass().getSimpleName());

		if(r == 0)
			r = Double.compare(i1.getArea(), i2.getArea());

		return r;
	}
}

public List<Imovel> imoveisPorTipoArea() {
	return this.ordenaImovel(new comparaTipoArea());
}


// EX5
public void gravaObj(String nome) throws IOException, FileNotFoundException {
	ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nome));
	os.writeObject(this);
	os.flush();
	os.close();
}

static POOAirBnB carregaObj(String nome) throws IOException, FileNotFoundException, ClassNotFoundException {
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(nome));
	POOAirBnB poo = (POOAirBnB)is.readObject();
	is.close();
	return poo;
}

// Parte 4

// EX6

// (a)
public void addCaminho(String vOrig, String vDest) {
	Set<String> s1, s2;
	s1 = adj.get(vOrig);
	s2 = adj.get(vDest);

	if(s1 == null)
		s1 = new HashSet<>();

	if(s2 == null)
		s2 = new HashSet<>();

	s1.add(vDest);

	adj.put(vOrig, s1);
	adj.put(vDest, s2);
}

// (b)
public int size() {
	int n = adj.size();
	int m = adj.values().stream().mapToInt(Set::size).sum();
	return n + m;
}


// (c)
public boolean haCaminho(String vOrig, String vDest) {
	boolean r = adj.containsKey(vOrig) && adj.containsKey(vDest);
	
	if(r) {
		r = false;
		String act;
		Set<String> tmp, visitados = new HashSet<>();
		List<String> porVisitar = new ArrayList<>();

		porVisitar.add(vOrig);

		while(porVisitar.size() > 0 && !r) {
			act = porVisitar.remove(0);
			visitados.add(act);
			tmp = adj.get(act);

			if(tmp.contains(vDest))
				r = true;
			else {
				for(String sv : tmp) {
					porVisitar.add(sv);
				}
			}
		}
	}

	return r;
}