package com.sefamertkaya.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.MessageDAO;
import com.sefamertkaya.entity.Comment;
import com.sefamertkaya.entity.Message;

@Service
@Transactional
public class MessageService {

	@Autowired
	private MessageDAO messageDAO;

	public void createMessage(Message message, HttpServletRequest request) {

		messageDAO.insert(message);

	}

	public void updateMessage(Message message, HttpServletRequest request) {

		messageDAO.update(message);

	}

	public void deleteMessage(Message message, HttpServletRequest request) {

		messageDAO.delete(message);

	}

	public Message getSenderMessage(Long senderId) {

		return messageDAO.getSenderMessage(senderId);
	}

	public Message getRecipientMessage(Long recipientId) {

		return messageDAO.getRecipientMessage(recipientId);
	}

	public ArrayList<Message> getAll(Long senderId, Long recipientId) {

		return messageDAO.getAll(senderId, recipientId);

	}

	public ArrayList<Message> recipientMessage(Long recipientId) {

		return messageDAO.recipientMessage(recipientId);

	}

}
