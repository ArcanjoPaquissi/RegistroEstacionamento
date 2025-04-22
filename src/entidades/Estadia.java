package entidades;

import java.time.LocalDateTime;

public class Estadia {
	private int id;
	private String placaVeiculo;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private double valorPago;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public LocalDateTime getEntrada() {
		return entrada;
	}
	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}
	public LocalDateTime getSaida() {
		return saida;
	}
	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public Estadia(int id, String placaVeiculo, LocalDateTime entrada, LocalDateTime saida, double valorPago) {
		super();
		this.id = id;
		this.placaVeiculo = placaVeiculo;
		this.entrada = entrada;
		this.saida = saida;
		this.valorPago = valorPago;
	}
	@Override
	public String toString() {
		return "Estadia [id=" + id + ", placaVeiculo=" + placaVeiculo + ", entrada=" + entrada + ", saida=" + saida
				+ ", valorPago=" + valorPago + "]";
	}
}
