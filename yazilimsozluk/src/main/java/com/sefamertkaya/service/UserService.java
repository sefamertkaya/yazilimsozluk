package com.sefamertkaya.service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.UserDAO;
import com.sefamertkaya.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void createUser(User user, HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString();
		user.setKeyreg(uuid); // keyi atadýk
		userDAO.insert(user);

	}

	public void updateUser(User user, HttpServletRequest request) {

		userDAO.update(user);

	}

	public void deleteUser(User user, HttpServletRequest request) {

		userDAO.delete(user);

	}

	public User getFindByEmail(User user) {

		return userDAO.getFindByEmail(user.getEmail());

	}

	public User getEmail(String email) {

		return userDAO.getFindByEmail(email);

	}

	public User getFindByEmailAndPass(User user) {

		return userDAO.getFindByEmailAndPass(user.getEmail(), user.getPassword());

	}

	public User getFindByUsername(User user, HttpServletRequest request) {

		return userDAO.getFindByUsername(user.getUsername());

	}

	public User getUserNameForPass(String username, HttpServletRequest request) {

		return userDAO.getFindByUsername(username);

	}

	public User getFindByUserId(Long userId) {
		return userDAO.getFindByUserId(userId);

	}

	public boolean getFindBykey(String key) {
		User user = userDAO.getFindByKey(key);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public User getFindBykeyUser(String key) {
		User user = userDAO.getFindByKey(key);

		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

}
