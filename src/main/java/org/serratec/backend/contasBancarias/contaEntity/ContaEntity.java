package org.serratec.backend.contasBancarias.contaEntity;

public class ContaEntity {

	private Integer id;
	private String titular;
	private double saldo;
	public ContaEntity(Integer id, String titular, double saldo) {
		super();
		this.id = id;
		this.titular = titular;
		this.saldo = saldo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void transacao(double valor) {
		this.saldo -= valor;
		
	} 
	
}


