// Parte 1

// (a)
public void add(Entrada ad) throws ExistingEntryException {
	if(entradas.containsKey(ad.getTermo()))
		throw new ExistingEntryException("A entrada que pretende adicionar já existe");
	entradas.put(ad.getTermo(), ad.clone());
}

// (b)
public boolean existe(String termo) {
	return entradas.containsKey(termo);
}

// (c)
public Entrada get(String termo) throws EntryDoesNotExistException {
	if(!this.existe(termo))
		throw new EntryDoesNotExistException("");
	return entradas.get(termo).clone();
}

// (d)
public Collection<Entrada> getAll() {
	return entradas.values().stream()
							.map(Entrada::clone)
							.collect(Collectors.toList());
}

// (e)
public boolean sinonimos(String termo1, String termo2) {
	boolean val = false;

	if(this.existe(termo1) && this.existe(termo2)) {
		val = entradas.get(termo1).getDefinicao().equals(entradas.get(termo2).getDefinicao());
	}

	return val;
}

// Parte 2

// EX2

// (a)
public Map<String, List<String>> getSinonimos() {
	Map<String, List<String>> r = new HashMap<>();
	Iterator<String> it = entradas.values();
	Receita receita;
	List<String> tmp;
	Strign def;

	while(it.hasNext()) {
		receita = it.next();

		def = receita.getDefinicao();

		tmp = entradas.get(def);

		if(tmp == null)
			tmp = new ArrayList<>();

		tmp.add(receita.getTermo());

		entradas.put(def, tmp);
	}

	return r;
}

// (b)
public Map<String, List<String>> getSinonimos() {
	return entradas.values()
				   .stream()
				   .collect(
				   		Collectors.groupingBy(
				   			Entrada::getDefinicao,
				   			Collectors.mapping(
				   				Entrada::getTermo,
				   				Collectors.toList())));
}

// EX3
// Em EntradaBase
public int compareTo(EntradaBase eb) {
	return (-1) * this.getTermo().compareTo(eb.getTermo());
}

// EX4
/*
CLASSES ABSTRATAS:

	Quando se pretende criar um relação de herança no ecossistema.
	Ou seja, classes herdam da dita classe abstrata, sendo que esta classe
	abstrata pode ser visto com um contentor que contem informação
	mutua a duas classes distintas que extendem esta, sendo que essas duas classes
	partilham entao uma raiz na sua hierarquia.

INTERFACES:

	Quando se pretende que classes que não se encontram na mesma hierarquia
	possuam comportamentos similares, podem criar uma heranças multipla
	artificial
*/

// Parte 3

// (a)
public Matriz(int n, int m) {
	linhas = new ArrayList<>(n);

	for(List<Object> l : linhas) {
		l = new ArrayList<>(m);

		for(Object o : l) {
			o = null;
		}
	}
}

// (b)
public Object get(int l, int c) throws ArrayIndexOutOfBoundsException {
	if(l > linhas.size() || c > linhas.get(0).size())
		throw new ArrayIndexOutOfBoundsException("");
	return linhas.get(l - 1).get(c - 1).clone();
}

// (c)
public int size() {
	return linhas.size() * linhas.get(0).size();
}

// (d)
public int count(Object o) {
	return linhas.stream()
				 .flatMap(Collection::stream)
				 .filter(k -> k.equals(o))
				 .count();
}

// (e)
public int getlinhas() {
	return linhas.size();
}

public int getcolunas() {
	return linhas.get(0).size();
}

public boolean equals(Object o) {
	if(this == o) return true;
	if((o == null) || (this.getClass() != o.getClass())) return false;
	Matriz m = (Matriz)o;
	int l, c = this.getcolunas();
	l = this.getlinhas();
	boolean val = l == m.getlinhas() && c == m.getcolunas();
	if(val) {
		for(int i = 0; i < l && val; i++){
			for(int j = 0; j < c && val; j++)
				val = this.get(i, j).equals(m.get(i, j));
		}
	}
	return val;
}

// Parte 4

// EX6

// (a)
public void save(String f) {
	try{
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(this);

		oos.close();
		fos.close();
	} catch(FileNotFoundException ex) {
		// ...
	} catch(IOException ex) {
		// ...
	}
}

// (b)
public class Matriz implements Serializable {
	// ...
}

// EX7

// (a)
public Matriz(int n) {
	linhas = new ArrayList<>(n);
	int i = 1;

	for(List<Object> l : linhas) {
		l = new ArrayList<>(i);

		for(Object o : l) {
			o = null;
		}

		i++;
	}
}

// (b)
public boolean tri() {
	boolean val = true;
	int i = 1;

	for(List<Object> l : linhas) {
		if(l.size() != i) {
			val = false;
			break;
		}
		i++;
	}

	return val;
}