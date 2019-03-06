package com.sefamertkaya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long entryId;
	private String kullanici;
	private String kullanmayici;
	private Long entryUserId;
	@Column(length = 149)
	private String title;
	@Column(length = 99999)
	private String content;

	private Date entryDate = new Date();

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Long getEntryUserId() {
		return entryUserId;
	}

	public void setEntryUserId(Long entryUserId) {
		this.entryUserId = entryUserId;
	}

	public String getKullanici() {
		return kullanici;
	}

	public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}

	public String getKullanmayici() {
		return kullanmayici;
	}

	public void setKullanmayici(String kullanmayici) {
		this.kullanmayici = kullanmayici;
	}

}
