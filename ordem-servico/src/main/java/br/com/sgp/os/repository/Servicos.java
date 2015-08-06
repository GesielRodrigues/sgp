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

import br.com.sgp.os.model.Servico;
import br.com.sgp.os.repository.filter.ServicoFilter;
import br.com.sgp.os.util.jpa.Transactional;

public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public Servico guardar(Servico servico) {
		return manager.merge(servico);
	}

	@SuppressWarnings("unchecked")
	public List<Servico> filtrados(ServicoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Servico.class);

		if (filtro.getId() != null) {
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}

		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}

		if (filtro.getTipoDeServico() != null) {
			criteria.add(Restrictions.eq("tipoDeServico", filtro.getTipoDeServico()));
		}

		return criteria.addOrder(Order.asc("id")).list();
	}
}
