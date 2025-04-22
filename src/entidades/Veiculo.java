package entidades;

public class Veiculo {
	private String placa;
	private String modelo;
	private String cor;
	private String cpfCliente;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public Veiculo(String placa, String modelo, String cor, String cpfCliente) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.cpfCliente = cpfCliente;
	}
	@Override
	public String toString() {
		return "Veículo [placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", cpfCliente=" + cpfCliente + "]";
	}
}
