// Parte 1

// EX1
// (a)

/*
RESPOSTA:

	L.4.: Verifica se o objeto ao qual se pretende comparar não é nulo, e para além disso,
	verifica também se os dois objetos em questão (o proprio, e o outro) são da mesma classe
	em runtime. Por que se não se verificarem os dois predicados acima, então as classes são
	diferentes.

	L.7.: Após verificar que em runtime são da mesma classe, é efetuado um cast de forma a poder
	referenciar o objeto que se passou como argumento, como uma instância da classe atual
	proprimente dita, tendo assim acesso aos metõdos desta, permitindo obter informação sobre este objeto.

	L.8.: É feita a comparação propriamente dita, e parametro a parametro cada um dos campos é comparado
	verificando se de facto os objetos são iguais em todos os seus campos.

*/

// (b)

/*
RESPOSTA:
	
	Ao contrário do que se pensa, o metódo getClass() não retorna diretamente a classe do objeto que se pretende verificar
	O metódo getClass() retorna a qual classe a dita esta atribuida em runtime. Ou seja, de que forma é apelidada
	no programa, daí a linha 4 de AlunoTE e a linha4 da sua super classe dão o mesmo resultado
	Pois o metódo getClass() vai retornar sempre "AlunoTE" pois ambos os objetos que se pretende comparar, são vistos com AlunoTE
	em runtime, e não como Aluno.

*/

// Parte 2

// EX1
// (a)

public class VOR {
	private Map<String, Equipa> equipas;

	// ...
}

// (b)

// EM VOR
public Barco getBarco(String idEquipa, String idBarco) throws InvalidBoatException {
	return equipas.get(idEquipa).getBarco(idBarco);
}

// EM EQUIPA
public Barco getBarco(String idBarco) throws InvalidBoatException {
	Barco barco = barcos.get(idBarco);

	if(barco == null) {
		throw new InvalidBoatException("O barco " + idBarcos + " não existe");
	}

	return barco.clone();
}

// (c)

// EM VOR
public List<Barco> getBarcos(String idEquipa, double milhas) {
	return equipas.get(idEquipa).getBarcos(milhas);
}

// EM EQUIPA
public List<Barco> getBarcos(double milhas) {
	return barcos.values().stream()
						  .filter(b -> b.getMilhas() > milhas)
						  .map(Barco::clone)
						  .collect(Collectors.toList());
}

// (d)

// EM VOR
public void removeBarco(String idEquipa, String idBarco) throws InvalidBoatException {
	equipas.get(idEquipa).removeBarco(idBarco);
}

// EM EQUIPA
public void removeBarco(String idBarco) throws InvalidBoatException {
	if(barcos.remove(idBarco) == null) {
		throw new InvalidBoatException("O barco " + idBarcos + " não existe");	
	}
}

// PARTE 3

// EX3
// (a)
// EM RegistoEtapa
// duracao em horas
public double duracao() {
	return ((double)(fim.getTimeInMilis() - inicio.getTimeInMilis()))/(3.6e4);
}

// EM BARCOS
public double totalEmProva() {
	return registos.stream()
				   .mapToDouble(RegistoEtapa::duracao);
				   .sum();
}

// EM EQUIPA
public double totalEmProva(String idBarco) {
	return barcos.get(idBarco).totalEmProva();
}

// (b)
public double registoMaisLong() {
	OptionalDouble od = barcos.values().stream()
									   .mapToDouble(Barco::totalEmProva)
									   .max();
	return od.isPresent() ? od.getAsDouble() : 0.0;									   
}

// EX4
// (a)
public class BarcoHibrido extends Barco {
	private double capacidadeMax;
	private double potencia;
	private double autonomia;

	public BarcoHibrido(String id, double milhas, String categoria, double autonomiaC, Pessoa skipper, Set<Pessoa> tripulantes, double capacidadeMax, double potencia, double autonomiaE) {
		super(id, milhas, categoria, autonomiaC, skipper, tripulantes);
		this.capacidadeMax = capacidadeMax;
		this.potencia = potencia;
		this.autonomia = autonomiaE;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BarcoHibrido{");
		sb.append("id=").append(getId());
		sb.append(",milhas=").append(getMilhas());
		sb.append(",categoria=").append(getCategoria());
		sb.append(",autonomiaCombustao=").append(super.getAutonomia());
		sb.append(",skipper=").append(getSkipper().toString());
		sb.append(",tripulantes=").append(getTripulantes().toString());
		sb.append(",capacidadeMax=").append(capacidadeMax);
		sb.append(",potencia=").append(potencia);
		sb.append(",autonomia=").append(autonomia);
		sb.append("}");
	}

	@Override
	public double getAutonomia() {
		return autonomia + super.getAutonomia();
	}
}

// Parte 4
// EX5
// (a)

//1) Criar interface "Seguravel" que implica definir o metódo calcSeguro() que calcula o montante a pagar.
public interface Seguravel {
	double calcSeguro();
}

//2) Os tipos de barcos indicados devem implementar este interface.
public class BarcoCatamaran extends Barco implements Seguravel {
	// ...
	public double calcSeguro() {
		//...
	}
	// ...
}

public class BarcoHibrido extends Barco implements Seguravel {
	// ...
	public double calcSeguro() {
		//...
	}
	// ...
}

// (b)

// 1) Cria um comparador que compara 2 objetos seguraveis
public class comparaSeguro implements Comparator<Seguravel> {
	public int compare(Seguravel s1, Seguravel s2) {
		return Double.compare(s1.calcSeguro(),s2.calcSeguro());
	}
}

// EM EQUIPA
public List<Barco> getListSeguraveis() {
	return barcos.values().stream()
						  .filter(b -> b instanceof Seguravel)
						  .map(Barco::clone)
						  .collect(Collectors.List());
}

// EM VOR
public List<Barco> getListSeguraveis() {
	List<Barco> l = new ArrayList<>();
	equipas.forEach((n,e) -> l.addAll(e.getListSeguraveis()));
	Collections.sort(l, new ComparaSeguro());
	return l;
}

// (c)
public void gravaFicheiroTextoSeguraveis(String fich) throws IOException{
	BufferedWriter writer = new BufferedWriter(new FileWriter(fich));
	this.getListSeguraveis().stream()
							.forEach(b -> writer.append(b.getId()));
	writer.close();
}