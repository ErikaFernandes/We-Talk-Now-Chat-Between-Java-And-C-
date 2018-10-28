package com.erika.wetalknow.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String  fromW;
	private String toW;
	
	@NotEmpty
	private String text;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromW() {
		return fromW;
	}
	public void setFromW(String fromW) {
		this.fromW = fromW;
	}

	public String getToW() {
		return toW;
	}
	public void setToW(String toW) {
		this.toW = toW;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Calendar getDate() {
		return date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", from=" + fromW + ", to=" + toW + ", text=" + text + ", date=" + date + "]";
	}
	
	
}
