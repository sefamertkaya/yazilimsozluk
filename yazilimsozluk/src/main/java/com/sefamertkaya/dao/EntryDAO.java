package com.sefamertkaya.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Entry;

@Repository
public class EntryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Entry entry) {

		sessionFactory.getCurrentSession().save(entry);

	}

	public void update(Entry entry) {

		sessionFactory.getCurrentSession().update(entry);

	}

	public void delete(Entry entry) {

		sessionFactory.getCurrentSession().delete(entry);

	}

	// Read

	public Entry getFindByIdEntry(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Entry WHERE entryId=:id").setLong("id", id);

		return (Entry) query.getSingleResult();
	}

	public ArrayList<Entry> getAll() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Entry ORDER BY entryDate DESC");

		return (ArrayList<Entry>) query.getResultList();

	}

	// en popüler baþlýklar için
	public ArrayList<Entry> getpopular() {

		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT Entry.entryId as ei,Entry.title as ti FROM Entry INNER JOIN Comment ON Entry.entryId=Comment.entryId group by Entry.entryId order by count(Comment.comment) DESC");

		return (ArrayList<Entry>) query.getResultList();

	}

	// user id with entries.
	public ArrayList<Entry> getAll(Long entryUserId) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Entry WHERE entryUserId=:user_id")
				.setLong("user_id", entryUserId);

		return (ArrayList<Entry>) query.getResultList();

	}

	public Entry controlTitle(String title) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Entry Where title=:title").setString("title",
				title);

		Entry entry = null;
		try {

			entry = (Entry) query.getSingleResult();

		} catch (javax.persistence.NoResultException e) {

			entry = null;
		}

		return entry;

	}

	public int countUserAddEntry(Long userId) {

		int count = ((Long) sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM Entry WHERE entryUserId=:userId").setLong("userId", userId)
				.uniqueResult()).intValue();

		return count;

	}

	public Entry controlEntry(String content) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Entry Where content=:content")
				.setString("title", content);

		Entry entry = null;
		try {

			entry = (Entry) query.getSingleResult();

		} catch (javax.persistence.NoResultException e) {

			entry = null;
		}

		return entry;

	}

}
