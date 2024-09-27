package com.cristianpinto.workshopmongo.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDTO author;
	

	public CommentDTO() {
		
	}


	public CommentDTO(String text, String dateString, AuthorDTO author) throws ParseException {
		super();
		this.text = text;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // Horário de greewich
		try{
			this.date = sdf.parse(dateString);
		}catch(ParseException e) {
			throw e;
		}
		this.author = author;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
