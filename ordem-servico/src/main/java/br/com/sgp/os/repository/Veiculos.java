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

import br.com.sgp.os.model.Veiculo;
import br.com.sgp.os.repository.filter.VeiculoFilter;
import br.com.sgp.os.util.jpa.Transactional;

public class Veiculos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public Veiculo guardar(Veiculo veiculo) {
		return this.manager.merge(veiculo);
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> filtrados(VeiculoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Veiculo.class);

		if (filtro.getId() != null) {
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}

		if (StringUtils.isNotBlank(filtro.getPlaca())) {
			criteria.add(Restrictions.ilike("placa", filtro.getPlaca(), MatchMode.START));
		}

		if (StringUtils.isNotBlank(filtro.getModelo())) {
			criteria.add(Restrictions.ilike("modelo", filtro.getModelo(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getAno())) {
			criteria.add(Restrictions.eq("ano", filtro.getAno()));
		}

		return criteria.addOrder(Order.asc("placa")).list();
	}

}
