package org.serratec.backend.util;

import org.serratec.backend.contasBancarias.contaservice.idnotfound;
import org.serratec.backend.contasBancarias.contaservice.saldoInsuficiente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class CorrecaoExcecao {

	@ExceptionHandler(idnotfound.class)
	public ResponseEntity<String> ContaNaoEncontrada(idnotfound erro) {
		return ResponseEntity.notFound()
				.header("Cliente não encontrado", erro.getMessage())
				.build();
	}
	
	@ExceptionHandler(saldoInsuficiente.class)
	public ResponseEntity<String> ContaNaoEncontrada(saldoInsuficiente erro) {
		return ResponseEntity.notFound()
				.header("Saldo", erro.getMessage())
				.build();
	}
}
