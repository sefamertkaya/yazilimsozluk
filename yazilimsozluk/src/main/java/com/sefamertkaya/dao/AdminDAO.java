package com.sefamertkaya.dao;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Admin;

@Repository
public class AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void create(Admin admin) {

		sessionFactory.getCurrentSession().save(admin);

	}

	public void update(Admin admin) {

		sessionFactory.getCurrentSession().update(admin);

	}

	public void delete(Admin admin) {

		sessionFactory.getCurrentSession().delete(admin);
	}

	public ArrayList<Admin> getAll() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Admin");

		return (ArrayList<Admin>) query.getResultList();
	}

	public Admin getFindById(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Admin WHERE id=:id").setLong("id", id);

		return (Admin) query.getSingleResult();
	}

	public Admin loginControl(String email, String password) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM Admin WHERE email=:email AND password=:password").setString("email", email)
				.setString("password", password);

		Admin admin = null;

		try {

			admin = (Admin) query.getSingleResult();

		}

		catch (javax.persistence.NoResultException e) {

			admin = null;

		}
		return admin;
	}

}
