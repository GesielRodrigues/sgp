package br.com.pedreirascontagem.repository.filter;

import java.io.Serializable;

public class VeiculoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String placa;
	private String modelo;
	private String ano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
