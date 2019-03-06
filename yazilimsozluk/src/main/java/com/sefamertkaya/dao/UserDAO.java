package com.sefamertkaya.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(User user) {

		sessionFactory.getCurrentSession().save(user);

	}

	public void update(User user) {

		sessionFactory.getCurrentSession().update(user);

	}

	public void delete(User user) {

		sessionFactory.getCurrentSession().delete(user);

	}

	public User getFindByUsername(String username) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username")
				.setString("username", username);

		User user = null;

		try {
			user = (User) query.getSingleResult();

		} catch (javax.persistence.NoResultException e) {
			user = null;
		}
		return user;

	}

	public User getFindByUserId(Long userId) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE userId=:userId").setLong("userId",
				userId);

		return (User) query.getSingleResult();

	}

	// login ekranýnda kullanýcý yoksa bu hatayý versin.
	public User getFindByEmail(String email) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email").setString("email",
				email);

		User user = null;
		try {
			user = (User) query.getSingleResult();

		} catch (javax.persistence.NoResultException e) {
			user = null;
		}

		return user;
	}

	public User getFindByEmailAndPass(String email, String password) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM User WHERE email=:email AND password=:password").setString("email", email)
				.setString("password", password);

		User user = null;
		try {
			user = (User) query.getSingleResult();

		} catch (javax.persistence.NoResultException e) {
			user = null;
		}

		return user;

	}

// keylere bakarak veritabanýndaki kiþiyi getirir öyle bir kiþi yoksa null döndürür.
	public User getFindByKey(String key) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE keyreg=:key").setString("key",
				key);

		User user = null;
		try {
			user = (User) query.getSingleResult();

		} catch (Exception e) {
			user = null;
		}
		return user;

	}

}
