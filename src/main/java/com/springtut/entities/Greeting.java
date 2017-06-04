package com.springtut.entities;

import java.io.Serializable;

public class Greeting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8031616230239703367L;
	private long id;
	private String context;
	
	public Greeting(long id, String context) {
		super();
		this.id = id;
		this.context = context;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
