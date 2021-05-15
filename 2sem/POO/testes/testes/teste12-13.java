// Parte 1

// EX1

public class EmpresaSet {
	private Map<String, Empregado> empregados;

	// ...
}

// (a)
public boolean existeEmpregado(String cod) {
	return empregados.containsKey(cod);
}

// (b)
public Empregado getEmpregado(String code) {
	return empregados.get(code).clone();
}

// (c)
public void addEmpregado(Empregado e) {
	empregados.putIfAbsent(e.getCodigo(), e.clone());
}

// (d)
// Preciso criar um comparador que compara por salario ordem descrescente.
public class ComparaSalarioDec implements Comparator<Empregado> {
	public int compare(Empregado e1, Empregado e2) {
		return (-1)*Double.compare(e1.getSalario(), e2.getSalario());
	}
}

// COm externo e interno

// externo:
public Iterator<Empregado> listaPorOrdemDecrescenteSalario() {
	TreeSet<Empregado> ls = new TreeSet<>(new ComparaSalarioDec());

	empregados.values().forEach(e -> ls.add(e.clone()));

	return ls.iterator();
}

// Parte 2

// EX2
public class CEO extends Empregado {

	public CEO(CEO c) {
		super(c.getCodigo(), c.getNome(), c.getDias());
	}

	@Override
	public double salario() {
		return super.getSalDia()*3;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CEO{codigo=").append(getCodigo());
		sb.append(",nome=").append(getNome());
		sb.append(",salario=").append(this.salario());
		sb.append("};");
		return sb.toString();
	}

	@Override
	public Empregado clone() {
		return new CEO(this);
	}

}

// EX3

// (a) e (b)
/*
Contribuinte é um interface que implica a definição de uma função getNIF
As alterações que teriam de ser feitas era:

em Empregado: implementar o interface Contribuinte
			  Adicionar variavel de instância que implique indicar o NIF.

Em EmpresaSet: Definir um metódo que permita obter o conjunto de todos os contribuintes(talvez Set<Contribuinte>)

*/

public interface Contribuinte {
	String getNIF();
}


// Parte 3

// EX4

// (a)
public class Receita {
	private String nome;
	private String descricao;
	private Set<Ingrediente> ingredientes;
	private List<String> preparacao;

	// ...
}

public class LivroDeReceitas {
	private Map<String, Receita> receitas;

	// ...
}

// (b)
public Receita(String nome, String descricao, Set<Ingrediente> ingredientes, List<String> preparacao) {
	this.nome = nome;
	this.descricao = descricao;
	this.ingredientes = ingredientes.stream().map(Receita::clone).collect(Collectors.toList());
	this.preparacao = preparacao.clone();
}

// (c)
public int totalCalorias(String nomeReceita) throws ReceitaInexistenteException {
	Receita receita = receitas.get(nomeReceita);

	if(receita == null)
		throw new ReceitaInexistenteException("A receita " + nomeReceita + " não está neste livro");

	return receita.getIngredientes().stream()
									.mapToInt(Ingrediente::getCalorias)
									.sum();
}

// Parte 4

// EX5

// (a)
public Map<String, Set<String>> receitasPorIngrediente() {
	Map<String, Set<String>> rpi = new HashMap<>();
	Set<String> tmp1;
	Set<Receita> tmp2;

	receitas.forEach((k, v) -> {
		tmp2 = v.getIngredientes();

		for(Ingrediente i : tmp2) {
			tmp1 = rpi.get(i.getNome());

			if(tmp1 == null)
				tmp1 = new HashSet<>();

			tmp1.add(k);

			rpi.put(i, tmp1);
		}
	});

	return rpi;
}

// (b)
public void gravaObj(String filename, int calorias) {
	try{
		FileOutputSteam fos = new FileOutputSteam(filename);
		ObjectOutputSteam oos = new ObjectOutputSteam(fos);

		List<Receita>l = receitas.values()
						 .stream()
						 .filter(r -> r.totalCalorias() >= calorias)
						 .collect(Collectors.toList());

		oos.writeObject(l);
		
		oos.close();
		fos.close();

	}
	catch(FileNotFoundException ex) {
		// ...
	}
	catch(IOException ex) {
		// ...
	}
}