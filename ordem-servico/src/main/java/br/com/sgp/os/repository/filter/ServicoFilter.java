package br.com.sgp.os.repository.filter;

import java.io.Serializable;

import br.com.sgp.os.model.TipoServico;

public class ServicoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private TipoServico tipoDeServico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoServico getTipoDeServico() {
		return tipoDeServico;
	}

	public void setTipoDeServico(TipoServico tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}

}
