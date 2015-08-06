package br.com.sgp.os.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgp.os.model.Servico;
import br.com.sgp.os.repository.Servicos;
import br.com.sgp.os.repository.filter.ServicoFilter;

@Named
@ViewScoped
public class PesquisaServicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Servicos repository;

	private ServicoFilter filtro;
	private List<Servico> servicos;

	public PesquisaServicoBean() {
		limpar();
	}

	private void limpar() {
		this.filtro = new ServicoFilter();
		this.servicos = new ArrayList<>();
	}

	public void pesquisar() {
		this.servicos = this.repository.filtrados(filtro);
	}

	public ServicoFilter getFiltro() {
		return filtro;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

}
