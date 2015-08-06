package br.com.sgp.os.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgp.os.model.Motorista;
import br.com.sgp.os.repository.Motoristas;
import br.com.sgp.os.repository.filter.MotoristaFilter;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Motoristas repository;

	private MotoristaFilter filtro;
	private List<Motorista> motoristas;

	public PesquisaMotoristaBean() {
		limpar();
	}

	private void limpar() {
		this.filtro = new MotoristaFilter();
		this.motoristas = new ArrayList<>();
	}

	public void pesquisar() {
		this.motoristas = this.repository.filtrados(filtro);
	}

	public MotoristaFilter getFiltro() {
		return filtro;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

}
