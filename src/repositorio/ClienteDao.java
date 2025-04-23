package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cliente;

public class ClienteDao {

	private Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/registroestacionamento";
		String usuario = "root";
		String senha = "Poderoso13gg";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Funçaõ para cadastrar novo cliente no banco
	public void cadastrarCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (cpf, nome, telefone) VALUES (?, ?, ?)";

		try (Connection conn = getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getTelefone());

			stmt.executeUpdate();
			System.out.println("Cliente cadastrado com sucesso!");

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar cliente:");
			e.printStackTrace();
		}
	}

	public void listarTodosClientes() {
		String sql = "SELECT * FROM cliente";

		try (Connection conn = getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			System.out.println("\n=== CLIENTES CADASTRADOS ===");
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");

				System.out.println("CPF: " + cpf);
				System.out.println("Nome: " + nome);
				System.out.println("Telefone: " + telefone);
				System.out.println("---------------------------");
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar clientes:");
			e.printStackTrace();
		}
	}

}
