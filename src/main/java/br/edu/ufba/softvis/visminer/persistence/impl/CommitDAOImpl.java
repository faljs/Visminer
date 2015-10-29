package br.edu.ufba.softvis.visminer.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ufba.softvis.visminer.model.database.CommitDB;
import br.edu.ufba.softvis.visminer.persistence.dao.CommitDAO;
import br.edu.ufba.softvis.visminer.utility.StringUtils;

/**
 * Implementation of interface {@link CommitDAO}
 */

public class CommitDAOImpl extends DAOImpl<CommitDB, Integer> implements CommitDAO{

	public List<CommitDB> findByTree(int treeId) {
		
		EntityManager em = getEntityManager();
		TypedQuery<CommitDB> query = em.createNamedQuery("CommitDB.findByTree", CommitDB.class);
		query.setParameter("id", treeId);
		return query.getResultList();
		
	}

	public List<CommitDB> findByRepository(String repositoryPath) {
		
		String uid = StringUtils.sha1(repositoryPath.replace("\\", "/"));
		
		EntityManager em = getEntityManager();
		TypedQuery<CommitDB> query = em.createNamedQuery("CommitDB.findByRepository", CommitDB.class);
		query.setParameter("uid", uid);
		return query.getResultList();
		
	}

	public List<CommitDB> findNotRefIssue(int repoId) {

		EntityManager em = getEntityManager();
		TypedQuery<CommitDB> query = em.createNamedQuery("CommitDB.findNotRefIssue", CommitDB.class);
		query.setParameter("repoId", repoId);
		return query.getResultList();
		
	}


	
}