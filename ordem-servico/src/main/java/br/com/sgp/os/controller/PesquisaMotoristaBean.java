package br.com.sgp.os.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgp.os.model.Mecanico;
import br.com.sgp.os.repository.Mecanicos;
import br.com.sgp.os.repository.filter.MecanicoFilter;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mecanicos repository;

	private MecanicoFilter filtro;
	private List<Mecanico> mecanicos;

	public PesquisaMotoristaBean() {
		limpar();
	}

	private void limpar() {
		this.filtro = new MecanicoFilter();
		this.mecanicos = new ArrayList<>();
	}

	public MecanicoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(MecanicoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Mecanico> getMecanicos() {
		return mecanicos;
	}

	public void pesquisar() {
		this.mecanicos = this.repository.filtrados(filtro);
	}

}
