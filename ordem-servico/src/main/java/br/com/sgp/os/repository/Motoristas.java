package br.com.sgp.os.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sgp.os.model.Motorista;
import br.com.sgp.os.util.jpa.Transactional;

public class Motoristas implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public Motorista guardar(Motorista motorista) {
		return manager.merge(motorista);
	}
}
