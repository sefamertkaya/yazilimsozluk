package com.sefamertkaya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long davaci;
	private Long davali;

	@Column(length = 9999)
	private String sikayet;

	private Date date = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDavaci() {
		return davaci;
	}

	public void setDavaci(Long davaci) {
		this.davaci = davaci;
	}

	public Long getDavali() {
		return davali;
	}

	public void setDavali(Long davali) {
		this.davali = davali;
	}

	public String getSikayet() {
		return sikayet;
	}

	public void setSikayet(String sikayet) {
		this.sikayet = sikayet;
	}

}
