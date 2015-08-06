package br.com.sgp.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sgp.os.model.Mecanico;
import br.com.sgp.os.repository.filter.MecanicoFilter;
import br.com.sgp.os.util.jpa.Transactional;

public class Mecanicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public Mecanico guardar(Mecanico mecanico) {
		return manager.merge(mecanico);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mecanico> filtrados(MecanicoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Mecanico.class);

		if (filtro.getId() != null) {
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}

}
