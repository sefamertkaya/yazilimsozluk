package com.sefamertkaya.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Complaint;

@Repository
public class ComplaintDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Complaint complaint) {

		sessionFactory.getCurrentSession().save(complaint);

	}

}
