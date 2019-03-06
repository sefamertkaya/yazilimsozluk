package com.sefamertkaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.InformationDAO;
import com.sefamertkaya.entity.Information;

@Service
@Transactional
public class InformationService {

	@Autowired
	private InformationDAO informationDAO;

	public void create(Information info) {

		informationDAO.createInfo(info);

	}

	public void update(Information info) {

		informationDAO.updateInfo(info);

	}

	public Information getFindById(Long id) {

		return informationDAO.getFindById(id);

	}

}
