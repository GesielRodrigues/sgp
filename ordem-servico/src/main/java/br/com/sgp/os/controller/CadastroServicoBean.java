package br.com.sgp.os.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgp.os.model.Servico;
import br.com.sgp.os.model.TipoServico;
import br.com.sgp.os.repository.Servicos;
import br.com.sgp.os.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroServicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Servicos servicos;

	private Servico servico;

	public CadastroServicoBean() {
		limpar();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	private void limpar() {
		this.servico = new Servico();
	}

	public TipoServico[] getTiposDeServico() {
		return TipoServico.values();
	}

	public void salvar() {
		this.servicos.guardar(this.servico);
		limpar();
		FacesUtil.addInfoMessage("Serviço salvo com sucesso.");
	}

}
