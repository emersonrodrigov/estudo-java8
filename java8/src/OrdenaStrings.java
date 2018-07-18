import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
	 
		List<String> palavras = new ArrayList<>();
		palavras.add("Alura online");
		palavras.add("Casa do código");
		palavras.add("caelum");

		// sort = default method
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

	
		palavras.sort((s1, s2) ->  Integer.compare(s1.length(), s2.length()));
		 
		
		System.out.println(palavras);

		System.out.println("Print usando lambda");
		palavras.forEach(s -> System.out.println(s));

		// replaceAll = default method interface collections
		palavras.replaceAll(nome -> {
			nome = nome.concat("A");
			return nome;
		});
		System.out.println("replaAll -> " + palavras);

		// para função lambda funcionar, precisa ter uma interface funcional
		 Consumer<String> impressor = System.out::println;
		 palavras.forEach(impressor);
		 
		 palavras.forEach(s -> System.out.println(s));
		 
		 // lambda  iniciando um thread
		 new Thread(() -> System.out.println("Executando um Runnable")).start();
		 
		 
		 // EXEMPLOS DE COMPARATOR COM LAMBDA
		 // EXEMPLO 1
		 palavras.sort(Comparator.comparing(s -> s.length()));
		 System.out.println(palavras);
		 
		 // EXEMPLO 2
		 palavras.sort(comparing(String::length));
		 System.out.println(palavras);
		 
		 
		
		 
		 // EXEMPLO 3
		 Function<String, Integer> funcao = String::length;
		 Comparator<String>  comparador = Comparator.comparing(funcao);
		 palavras.sort(comparador);
		 System.out.println(palavras);
		 
		 
		 
		 // Usuairo
		 Usuario usuario = new Usuario();
		 List<Usuario> listaUsuario = new ArrayList<>();
		 
		 for (int i = 0; i < 10; i++) {
			usuario = new Usuario();
			usuario.setNome("Nome" + i);
			listaUsuario.add(usuario);
		}
		 
		 listaUsuario.forEach(System.out::println);
		 
		 
		 // exemplo 
		 palavras.sort(String.CASE_INSENSITIVE_ORDER);
		 System.out.println(palavras);
		 
	}

}



class Usuario{
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}
	
	
}
 
