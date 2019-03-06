package com.sefamertkaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.ComplaintDAO;
import com.sefamertkaya.entity.Complaint;

@Service
@Transactional
public class ComplaintService {

	@Autowired
	private ComplaintDAO complaintDAO;

	public void createComplaint(Complaint complaint) {

		complaintDAO.insert(complaint);

	}

}
