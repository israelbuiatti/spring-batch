package br.com.dbc.model;

import lombok.Data;

@Data
public class Conta {

	private String agencia;
	private String conta;
	private String saldo;
	private String status;
	private boolean retorno;
	
}
