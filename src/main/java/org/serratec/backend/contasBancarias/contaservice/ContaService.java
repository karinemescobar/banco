package org.serratec.backend.contasBancarias.contaservice;

import java.util.ArrayList;
import org.serratec.backend.contasBancarias.contaEntity.ContaEntity;
import org.serratec.backend.contasBancarias.contaEntity.OperacaoEntity;
import org.springframework.stereotype.Service;

@Service

public class ContaService {

	private ArrayList<ContaEntity> contas = new ArrayList<ContaEntity>();

	public ArrayList<ContaEntity> getContas(){
		return contas;
	}
	public ContaEntity getConta(Integer id) throws idnotfound {
		boolean found = true;
		for(ContaEntity conta : contas) {
			if (conta.getId() == id) {
				return conta;
				
			}
			if (!found) throw new idnotfound();
		}
		return null;
	}
	public String AdcionarConta (ContaEntity conta) {
		contas.add(conta);
		return "Conta criada com sucesso.";
	}
	public String AtualizarConta(Integer id, ContaEntity contaAtualizar) throws idnotfound {
		boolean found = true;
		for(ContaEntity conta : contas) {
			if (conta.getId() == id) {
				
				if (contaAtualizar.getTitular()!=null) {
					conta.setTitular(contaAtualizar.getTitular());
				}
				if (contaAtualizar.getId()!=null) {
					conta.setId(contaAtualizar.getId());
				}
				return "Conta atualizada com sucesso";
				
			}
			if (!found) throw new idnotfound();
		}
		return null;
	}
	
	public String DeletarConta(Integer id) throws idnotfound {
		boolean found = true;
		for(ContaEntity conta : contas) {
			if (conta.getId() == id) {
				contas.remove(conta);
				return "Conta deletada com sucesso.";
				
			}
			if (!found) throw new idnotfound();
		}
		return null;
	}
	public ContaEntity getConta(Integer id, OperacaoEntity operacao) throws idnotfound, saldoInsuficiente {
		boolean found = true;
		for(ContaEntity conta : contas) {
			if (conta.getId() == id) {
				if (conta.getSaldo() > operacao.getValor()) {
					conta.transacao(operacao.getValor());
				
				}
				else {
					throw new saldoInsuficiente("Saldo Insuficiente");
				}
				return conta;
				
			}
			if (!found) throw new idnotfound();
		}
		return null;
	}
	public String salvarContas(ArrayList<ContaEntity> contas) {
		this.contas.addAll(contas);
		return "Contas Salvas";
	}
}

