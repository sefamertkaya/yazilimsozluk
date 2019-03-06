package com.sefamertkaya.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Comment;

@Repository
public class CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Comment comment) {

		sessionFactory.getCurrentSession().save(comment);

	}

	public void update(Comment comment) {

		sessionFactory.getCurrentSession().update(comment);

	}

	public void delete(Comment comment) {

		sessionFactory.getCurrentSession().delete(comment);

	}

	// Read

	public Comment getFindByIdComment(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE entryId=:id").setLong("id",
				id);

		return (Comment) query.getSingleResult();
	}

	public ArrayList<Comment> getAllUserId(Long userId) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE userId=:userId")
				.setLong("userId", userId);

		return (ArrayList<Comment>) query.getResultList();

	}

	// user id with entries.
	public ArrayList<Comment> getAllEntryId(Long entryId) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE entryId=:entryId")
				.setLong("entryId", entryId);

		return (ArrayList<Comment>) query.getResultList();

	}

	public ArrayList<Comment> getAllEntryIdSayfa(Long entryId, int first) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE entryId=:entryId")
				.setLong("entryId", entryId);
		query.setFirstResult(first);
		query.setMaxResults(10);

		return (ArrayList<Comment>) query.getResultList();

	}

	// bir entrye atýlan yorum sayýsýný bulur.
	public int getAllEntryIdSayfaSAYI(Long entryId) {

		int count = ((Long) sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM Comment WHERE entryId=:entryId").setLong("entryId", entryId)
				.uniqueResult()).intValue();

		return count;

	}

}
