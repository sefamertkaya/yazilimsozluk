package com.sefamertkaya.service;

import java.util.ArrayList;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.AnnouncementDAO;
import com.sefamertkaya.entity.Announcement;

@Service
@Transactional
public class AnnouncementService {

	@Autowired
	private AnnouncementDAO annoDAO;

	public void create(Announcement anno) {

		annoDAO.create(anno);

	}

	public void delete(Announcement anno) {

		annoDAO.delete(anno);

	}

	public ArrayList<Announcement> getAll() {

		return annoDAO.getAll();

	}

	public Announcement getFindById(Long id) {

		return annoDAO.getFindById(id);
	}

}
