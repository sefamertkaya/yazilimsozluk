package com.sefamertkaya.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sefamertkaya.entity.Message;

@Repository
public class MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Message message) {

		sessionFactory.getCurrentSession().save(message);

	}

	public void update(Message message) {

		sessionFactory.getCurrentSession().update(message);

	}

	public void delete(Message message) {

		sessionFactory.getCurrentSession().delete(message);

	}

	public Message getSenderMessage(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Message WHERE senderId=:id").setLong("id",
				id);

		return (Message) query.getSingleResult();
	}

	public Message getRecipientMessage(Long id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Message WHERE recipientId=:id").setLong("id",
				id);

		return (Message) query.getSingleResult();
	}

	public ArrayList<Message> getAll(Long senderId, Long recipientId) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Message WHERE (senderId=:senderId AND recipientId=:recipientId) OR (senderId=:recipientId AND recipientId=:senderId) ORDER BY messageDate")
				.setLong("senderId", senderId).setLong("recipientId", recipientId);

		return (ArrayList<Message>) query.getResultList();

	}

	public ArrayList<Message> recipientMessage(Long recipientId) {

		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT DISTINCT userId,username FROM Message INNER JOIN User ON userId=senderId WHERE recipientId=:recipientId ORDER BY messageDate DESC")
				.setLong("recipientId", recipientId);

		return (ArrayList<Message>) query.getResultList();

	}

}
