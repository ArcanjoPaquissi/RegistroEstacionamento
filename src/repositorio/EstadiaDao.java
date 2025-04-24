package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstadiaDao {

	// Método para abrir conexão com o banco
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

	// Método para registrar a entrada de um veículo
	public void registrarEntrada(String placaVeiculo) {
		String sql = "INSERT INTO estadia (placa_veiculo, entrada) VALUES (?, NOW())";

		try (Connection conn = getConexao(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, placaVeiculo);
			pst.executeUpdate();
			System.out.println("Entrada registrada para o veículo " + placaVeiculo);

		} catch (SQLException e) {
			System.err.println("Erro ao registrar entrada:");
			e.printStackTrace();
		}
	}

	// Método para registrar a saída e calcular valor
	public void registrarSaida(int idEstadia) {
		String sqlUpdate = "UPDATE estadia SET saida = NOW(), "
				+ "valor_pago = CEIL(TIMESTAMPDIFF(MINUTE, entrada, NOW()) / 60.0) * 5.0 "
				+ "WHERE id = ? AND saida IS NULL";

		String sqlSelect = "SELECT e.entrada, e.saida, "
				+ "TIMESTAMPDIFF(MINUTE, e.entrada, e.saida) AS duracao_minutos, "
				+ "e.valor_pago, c.nome, c.cpf, c.telefone " + "FROM estadia e "
				+ "INNER JOIN veiculo v ON e.placa_veiculo = v.placa "
				+ "INNER JOIN cliente c ON v.cpf_cliente = c.cpf " + "WHERE e.id = ?";

		try (Connection conn = getConexao();
				PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);
				PreparedStatement pstSelect = conn.prepareStatement(sqlSelect)) {

			pstUpdate.setInt(1, idEstadia);
			int atualizado = pstUpdate.executeUpdate();

			if (atualizado > 0) {
				pstSelect.setInt(1, idEstadia);
				var rs = pstSelect.executeQuery();

				if (rs.next()) {
					String entrada = rs.getString("entrada");
					String saida = rs.getString("saida");
					int duracao = rs.getInt("duracao_minutos");
					double valor = rs.getDouble("valor_pago");
					String nome = rs.getString("nome");
					String cpf = rs.getString("cpf");
					String telefone = rs.getString("telefone");

					System.out.println("\n=== COMPROVANTE DE ESTADIA ===");
					System.out.println("Cliente: " + nome);
					System.out.println("CPF: " + cpf);
					System.out.println("Telefone: " + telefone);
					System.out.println("Entrada: " + entrada);
					System.out.println("Saída: " + saida);
					System.out.println("Duração: " + duracao + " minutos");
					System.out.printf("Valor a pagar: R$ %.2f\n", valor);
					System.out.println("==============================");
				}
			} else {
				System.out.println("Estadia já finalizada ou não encontrada.");
			}

		} catch (SQLException e) {
			System.err.println("Erro ao registrar saída:");
			e.printStackTrace();
		}
	}
}
