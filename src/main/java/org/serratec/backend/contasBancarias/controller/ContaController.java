package org.serratec.backend.contasBancarias.controller;

import java.util.ArrayList;

import org.serratec.backend.contasBancarias.contaEntity.ContaEntity;
import org.serratec.backend.contasBancarias.contaEntity.OperacaoEntity;
import org.serratec.backend.contasBancarias.contaservice.ContaService;
import org.serratec.backend.contasBancarias.contaservice.idnotfound;
import org.serratec.backend.contasBancarias.contaservice.saldoInsuficiente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessoaconta")

public class ContaController {
	@Autowired
	private ContaService service; 
	
	@GetMapping("/contas")
	public ArrayList<ContaEntity> receberContas () {
		return service.getContas();
	}
	@GetMapping("/conta/{id}")
	public ContaEntity getConta(@PathVariable Integer Id) throws idnotfound {
		return service.getConta(Id);
	}
	/*@PostMapping("/adicionarconta")
	public String AdcionarConta(@RequestBody ContaEntity conta) {
		return service.AdcionarConta(conta);
	} */
	@PutMapping("/atualizarconta/{id}")
	public String AtualizarConta(@PathVariable Integer Id, @RequestBody ContaEntity conta) throws idnotfound {
		return service.AtualizarConta(Id, conta);
	}
	@PostMapping("/operacao/{id}")
	public ContaEntity getConta(@PathVariable Integer Id, @RequestBody OperacaoEntity operacao) throws idnotfound, saldoInsuficiente {
		return service.getConta(Id, operacao);
	}
	@DeleteMapping("/deletar/{id}")
	public String DeletarConta(@PathVariable Integer Id) throws idnotfound {
		return service.DeletarConta(Id);
	}
	@PostMapping("/adicionarconta")
	public String AdcionarConta(@RequestBody ArrayList<ContaEntity> conta) {
		return service.salvarContas(conta);
	}
}
