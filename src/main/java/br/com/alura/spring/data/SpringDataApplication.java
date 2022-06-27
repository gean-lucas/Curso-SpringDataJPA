package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService; 
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatorioService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	private Boolean system = true;
	
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatorioService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatório dinâmico");
			
			Integer function = scanner.nextInt();
			switch (function) {
			case 1: {
				cargoService.inicial(scanner);
				break;
			}
			case 2: {
				funcionarioService.inicial(scanner);
				break;
			}
			case 3: {
				unidadeTrabalhoService.inicial(scanner);
				break;
			}
			case 4: {
				relatorioService.inicial(scanner);
				break;
			}
			case 5: {
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			}
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
		}
				
		
	}

}
