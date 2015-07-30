package br.com.pedreirascontagem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pedreirascontagem.model.Mecanico;
import br.com.pedreirascontagem.repository.Mecanicos;
import br.com.pedreirascontagem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMecanicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mecanicos mecanicos;

	private Mecanico mecanico;

	public CadastroMecanicoBean() {
		limpar();
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	private void limpar() {
		this.mecanico = new Mecanico();
	}

	public void salvar() {
		mecanicos.guardar(this.mecanico);
		limpar();
		FacesUtil.addInfoMessage("Mecânico Salvo com sucesso.");
	}

}
