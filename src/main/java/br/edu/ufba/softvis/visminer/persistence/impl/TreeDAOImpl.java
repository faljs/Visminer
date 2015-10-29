package br.edu.ufba.softvis.visminer.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ufba.softvis.visminer.model.database.TreeDB;
import br.edu.ufba.softvis.visminer.persistence.dao.TreeDAO;

/**
 * @author Felipe Gustavo de Souza Gomes (felipegustavo1000@gmail.com)
 * @version 0.9
 * 
 * Implementation of interface {@link TreeDAO}
 */

public class TreeDAOImpl extends DAOImpl<TreeDB, Integer> implements TreeDAO{

	public List<TreeDB> findByRepository(int repositoryId) {
		
		EntityManager em = getEntityManager();
		TypedQuery<TreeDB> query = em.createNamedQuery("TreeDB.findByRepository", TreeDB.class);
		query.setParameter("repositoryId", repositoryId);
		return query.getResultList();
		
	}

}
