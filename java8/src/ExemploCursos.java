import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
	}
	
	
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));

		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		// cursos.forEach(c -> System.out.println(c.getNome()));

		// Stream utiliza o desing = fluent interface (Sempre retorna ele mesmo)

		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));

		cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(c -> c.getAlunos())
				// .forEach(total -> System.out.println(total)); //lambda
				.forEach(System.out::println); // metodo reference

		int sum = cursos.stream()
					.filter(c -> c.getAlunos() > 100)
					.mapToInt(c -> c.getAlunos())
					.sum();
		System.out.println(sum);

		OptionalDouble average = cursos.stream()
									.filter(c -> c.getAlunos() > 100)
									.mapToInt(c -> c.getAlunos())
									.average();
		System.out.println(average.getAsDouble());

		// Optional é um classe do java 8 e ajuda trabalhar com null.
		// sem precisar verificar se o objeto é null
		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

		optionalCurso.ifPresent(System.out::println);
		System.out.println(optionalCurso.get());
		Curso curso = optionalCurso.orElse(null);
		
		System.out.println(curso);
		
		// pegando primeiro resultado da lista
		System.out.println("Pegando o primeiro resultado da list - .findFirst");
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst().ifPresent(System.out::println);;
		
		
		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

		System.out.println("\nPrint lista de cursos");
		cursos.stream().forEach(c -> System.out.println(c.getNome()));
		
		//retorna os itens de acordo com o filter
		System.out.println("\nretorna os itens de acordo com o filter " + "c -> c.getAlunos() >=100");
		List<Curso> collect = cursos.stream().filter(c -> c.getAlunos() >=100)
				.collect(Collectors.toList());
		collect.stream().forEach(c-> System.out.println(c.getNome()));
		 
		// retorna to map
		System.out.println("\nretorna os itens de acordo com o filter " + "c -> c.getAlunos() >=100 e convertendo para toMap" );
		cursos.stream().filter(c -> c.getAlunos() >=100)
		.collect(Collectors
						.toMap(
							c -> c.getNome(), // chave
							c -> c.getAlunos()) // valor
						).forEach((nome,alunos) -> System.out.println(nome + " Tem " + alunos + " alunos "));
		
		
		
		
		System.out.println("\nDICAS");
		System.out.println("ESTUDAR parallelStream()");
		System.out.println("ESTUDAR optional -> http://docs.oracle.com/javase/8/docs/api/java/util/Optional.html");
	}
}
