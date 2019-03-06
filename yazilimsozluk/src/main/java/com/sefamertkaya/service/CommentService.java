package com.sefamertkaya.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.CommentDAO;
import com.sefamertkaya.entity.Comment;

@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;

	public void createComment(Comment comment, HttpServletRequest request) {

		commentDAO.insert(comment);

	}

	public void updateComment(Comment comment, HttpServletRequest request) {

		commentDAO.update(comment);

	}

	public void deleteComment(Comment comment, HttpServletRequest request) {

		commentDAO.delete(comment);

	}

	// comment idsi ile comment içeriðini çek.
	public void getFindByIdComment(Long commentId) {

		commentDAO.getFindByIdComment(commentId);
	}

	// üye idsi ile üyenin tüm commentlerini çek
	public ArrayList<Comment> getAllUserId(Long userId) {

		return commentDAO.getAllUserId(userId);

	}

	// entry idsi ile o entry e atýlmýþ commentlerin hepsini çek.
	public ArrayList<Comment> getAllEntryId(Long entryId) {

		return commentDAO.getAllEntryId(entryId);

	}

	public ArrayList<Comment> getAllEntryIdSayfa(Long entryId, int first) {

		return commentDAO.getAllEntryIdSayfa(entryId, first);

	}

	public int getAllEntryIdSayfaSAYI(Long entryId) {
		return commentDAO.getAllEntryIdSayfaSAYI(entryId);

	}

}
