package br.com.pedreirascontagem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.pedreirascontagem.model.Servico;
import br.com.pedreirascontagem.util.jpa.Transactional;

public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public Servico guardar(Servico servico) {
		return manager.merge(servico);
	}

}
