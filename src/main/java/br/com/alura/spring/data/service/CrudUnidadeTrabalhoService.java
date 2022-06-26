package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	
	private Boolean system = true;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de unidade deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("3 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 0: {
				system = false;
				break;
			}
			case 1: {
				salvar(scanner);
				break;
			}
			case 2: {
				atualizar(scanner);
				break;
			}
			case 3: {
				visualizar();
				break;
			}
			case 4: {
				deletar(scanner);
				break;
			}
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome da unidade");
		String nome = scanner.next();
		System.out.println("Endereço da unidade");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setNome(nome);
		unidade.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidade);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o Id");
		int id = scanner.nextInt();
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();
		System.out.println("Digite o endereço");
		String endereco = scanner.nextLine();
		
		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setId(id);
		unidade.setNome(nome);
		unidade.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidade);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
