package entidades;

public class Veiculo {
	private String placa;
	private String modelo;
	private String cor;
	private String tipo;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
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
	public Veiculo(String placa, String modelo, String cor, String tipo, String cpfCliente) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.tipo = tipo;
		this.cpfCliente = cpfCliente;
	}
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", tipo=" + tipo + ", cpfCliente="
				+ cpfCliente + "]";
	}


	
}
