package Principal;

import java.util.Scanner;

import entidades.Cliente;
import entidades.Veiculo;
import repositorio.ClienteDao;
import repositorio.EstadiaDao;
import repositorio.VeiculoDao;

public class Principal {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ClienteDao clienteDao = new ClienteDao();
		VeiculoDao veiculoDao = new VeiculoDao();
		EstadiaDao estadiaDao = new EstadiaDao();

		int opcao;

		do {
			System.out.println("\n=== MENU ESTACIONAMENTO ===");
			System.out.println("[1] Cadastrar Cliente");
			System.out.println("[2] Cadastrar Veículo");
			System.out.println("[3] Registrar Entrada");
			System.out.println("[4] Registrar Saída");
			System.out.println("[5] Listar Clientes");
			System.out.println("[6] Listar Veículos");
			System.out.println("[0] Sair");
			System.out.print("Escolha uma opção: ");
			opcao = leia.nextInt();
			leia.nextLine(); 

			switch (opcao) {
			case 1:
				System.out.print("CPF: ");
				String cpf = leia.nextLine();
				System.out.print("Nome: ");
				String nome = leia.nextLine();
				System.out.print("Telefone: ");
				String telefone = leia.nextLine();

				Cliente cliente = new Cliente(cpf, nome, telefone);
				clienteDao.cadastrarCliente(cliente);
				break;

			case 2:
				System.out.print("Placa: ");
				String placa = leia.nextLine();
				System.out.print("Modelo: ");
				String modelo = leia.nextLine();
				System.out.print("Cor: ");
				String cor = leia.nextLine();
				System.out.print("CPF do Cliente: ");
				String cpfCliente = leia.nextLine();

				Veiculo veiculo = new Veiculo(placa, modelo, cor, cpfCliente);
				veiculoDao.cadastrarVeiculo(veiculo);
				break;

			case 3:
				System.out.print("Placa do veículo: ");
				String placaEntrada = leia.nextLine();
				estadiaDao.registrarEntrada(placaEntrada);
				break;

			case 4:
				System.out.print("ID da estadia para registrar saída: ");
				int idEstadia = leia.nextInt();
				leia.nextLine();
				estadiaDao.registrarSaida(idEstadia); // imprime o relatório dentro
				break;
				
			case 5:
			    clienteDao.listarTodosClientes();
			    break;

			case 6:
			    veiculoDao.listarTodosVeiculos();
			    break;

			case 0:
				System.out.println("Encerrando o sistema...");
				break;

			default:
				System.out.println("Opção inválida.");
			}

		} while (opcao != 0);

		leia.close();
	}

}
