package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Veiculo;

public class VeiculoDao {

	// Conexão com o Banco
	private Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/registroestacionamento";
		String usuario = "root";
		String senha = "Poderoso13gg"; // se quiser, mova isso para um arquivo config externo depois

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Função para cadastrar um veículo no banco
	public void cadastrarVeiculo(Veiculo veiculo) {
		String sql = "INSERT INTO veiculo (placa, modelo, cor, tipo, cpf_cliente) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = getConexao(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getModelo());
			pst.setString(3, veiculo.getCor());
			pst.setString(4, veiculo.getTipo());
			pst.setString(5, veiculo.getCpfCliente());

			pst.executeUpdate();
			System.out.println("Veículo cadastrado com sucesso: " + veiculo.getPlaca());

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar veículo:");
			e.printStackTrace();
		}
	}
	// Função para vizualizar os veiculos cadastrados
	public void listarTodosVeiculos() {
		String sql = "SELECT * FROM veiculo";

		try (Connection conn = getConexao();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
			while (rs.next()) {
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String cor = rs.getString("cor");
				String tipo = rs.getString("tipo");
				String cpfCliente = rs.getString("cpf_cliente");

				System.out.println("Placa: " + placa);
				System.out.println("Modelo: " + modelo);
				System.out.println("Cor: " + cor);
				System.out.println("Tipo: " + tipo);
				System.out.println("CPF do Cliente: " + cpfCliente);
				System.out.println("---------------------------");
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar veículos:");
			e.printStackTrace();
		}
	}

}
