package com.sefamertkaya.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Information;

@Repository
public class InformationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void createInfo(Information info) {

		sessionFactory.getCurrentSession().save(info);

	}

	public void updateInfo(Information info) {

		sessionFactory.getCurrentSession().update(info);

	}

	public Information getFindById(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Information WHERE id=:id").setLong("id", id);

		return (Information) query.getSingleResult();
	}

}
