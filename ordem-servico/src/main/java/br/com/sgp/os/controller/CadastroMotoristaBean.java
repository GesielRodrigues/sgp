package br.com.sgp.os.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgp.os.model.Motorista;
import br.com.sgp.os.repository.Motoristas;
import br.com.sgp.os.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Motoristas motoristas;

	private Motorista motorista;

	public CadastroMotoristaBean() {
		limpar();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	private void limpar() {
		this.motorista = new Motorista();
	}

	public void salvar() {
		motoristas.guardar(this.motorista);
		limpar();
		FacesUtil.addInfoMessage("Motorista salvo com sucesso.");
	}

}
