import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// LocalDate -> representa somenta data
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadaRio = LocalDate.of(2016, Month.JUNE, 5);
		
		LocalDate proximaOlimpiada = hoje.plusYears(4);
		
		
		System.out.println(proximaOlimpiada);

		
		int anos = proximaOlimpiada.getYear() - hoje.getYear();
		System.out.println(anos);
		
		Period periodo = Period.between(hoje, proximaOlimpiada);
		System.out.println(periodo);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		String dataFormatada = proximaOlimpiada.format(formatador);
		System.out.println(dataFormatada);
		
		
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		System.out.println(agora.format(formatadorComHoras));
		
		
		//Lidando com modelos mais específicos
		
		YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
		System.out.println(anoEMes);
		
		LocalTime intervalo = LocalTime.of(12, 30);
		LocalTime intervalo2 = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		System.out.println(intervalo.isBefore(intervalo2));
		System.out.println(intervalo.isAfter(intervalo2));
		
		
		ZonedDateTime dateTime = ZonedDateTime.now();
		System.out.println(dateTime);
		
		
		// exemplos 1
		
		LocalDate data = LocalDate.of(2099, Month.JANUARY, 25);
		
		// criando periodo java 8 
		LocalDate agora1 = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);

		Period periodo1 = Period.between(agora1, dataFutura);
		System.out.println(periodo1);
	}

}
