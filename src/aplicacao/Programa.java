package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoPorHora;
import entidade.Departamento;
import entidade.Trabalhador;
import entidade.enums.NivelDeTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDoDepartamento = sc.nextLine();
		
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeDoTrabalhador = sc.nextLine();
		
		System.out.print("Nível: ");
		String nivelDoTrabalhador = sc.nextLine();
		
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeDoTrabalhador, NivelDeTrabalhador.valueOf(nivelDoTrabalhador), salarioBase, new Departamento(nomeDoDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador irá ter? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Entre com o " + i + "° contrato: " );
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataDeContrato = sdf.parse(sc.next());
			
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			
			ContratoPorHora contrato = new ContratoPorHora(dataDeContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
			System.out.println();
		}
		
		System.out.println();
		System.out.print("Entre com o mes e ano para calcular o salário (MM/YYYY): ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("\nNome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Salario de " + mesAno + ": " + String.format("%.2f", trabalhador.recebido(ano, mes)));
		sc.close();
		
	}
}
