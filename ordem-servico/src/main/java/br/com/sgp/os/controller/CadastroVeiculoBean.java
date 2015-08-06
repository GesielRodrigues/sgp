package br.com.pedreirascontagem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pedreirascontagem.model.Veiculo;
import br.com.pedreirascontagem.repository.Veiculos;
import br.com.pedreirascontagem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroVeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Veiculos veiculos;

	private Veiculo veiculo;

	public CadastroVeiculoBean() {
		limpar();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	private void limpar() {
		this.veiculo = new Veiculo();
	}

	public void salvar() {
		this.veiculo.setPlaca(this.veiculo.getPlaca().toUpperCase());
		this.veiculo.setModelo(this.veiculo.getModelo().toUpperCase());
		this.veiculos.guardar(this.veiculo);
		limpar();
		FacesUtil.addInfoMessage("Veiculo Salvo com sucesso.");
	}
}
