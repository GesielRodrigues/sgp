package br.com.pedreirascontagem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pedreirascontagem.model.Veiculo;
import br.com.pedreirascontagem.repository.Veiculos;
import br.com.pedreirascontagem.repository.filter.VeiculoFilter;

@Named
@ViewScoped
public class PesquisaVeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Veiculos repository;

	private VeiculoFilter filtro;
	private List<Veiculo> veiculos;

	public PesquisaVeiculoBean() {
		limpar();
	}

	private void limpar() {
		this.filtro = new VeiculoFilter();
		this.veiculos = new ArrayList<>();
	}

	public VeiculoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(VeiculoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void pesquisar() {
		this.veiculos = this.repository.filtrados(filtro);
	}

}
