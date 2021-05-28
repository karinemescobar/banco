package org.serratec.backend.contasBancarias.contaEntity;

public class OperacaoEntity {
	private String tipo;
	private Double valor;
	public OperacaoEntity(String tipo, Double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
