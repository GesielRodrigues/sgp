package br.com.sgp.os.repository.filter;

import java.io.Serializable;

public class MecanicoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
