package com.sefamertkaya.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.EntryDAO;
import com.sefamertkaya.entity.Entry;
import com.sefamertkaya.entity.User;

@Service
@Transactional
public class EntryService {

	@Autowired
	private EntryDAO entryDAO;

	public void createEntry(Entry entry, HttpServletRequest request) {

		entryDAO.insert(entry);

	}

	public void updateEntry(Entry entry, HttpServletRequest request) {

		entryDAO.update(entry);

	}

	public void deleteEntry(Entry entry, HttpServletRequest request) {

		entryDAO.delete(entry);

	}

	public Entry getFindByIdEntry(Long id) {

		return entryDAO.getFindByIdEntry(id);

	}

	public ArrayList<Entry> getAll() {

		return entryDAO.getAll();

	}

	public ArrayList<Entry> getPopular() {

		return entryDAO.getpopular();

	}

	public ArrayList<Entry> getAlluserId(Long userid) {

		return entryDAO.getAll(userid);

	}

	public Entry controlTitle(Entry entry) {

		return entryDAO.controlTitle(entry.getTitle());

	}

	public Entry controlTitle(String title) {

		return entryDAO.controlTitle(title);

	}

	public int CountUserEntry(Long userId) {

		return entryDAO.countUserAddEntry(userId);
	}

	public Entry controlEntry(String content) {

		return entryDAO.controlTitle(content);

	}

}
