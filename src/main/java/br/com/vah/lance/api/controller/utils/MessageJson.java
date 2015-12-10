package br.com.vah.lance.api.controller.utils;

import java.io.Serializable;

public class MessageJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EnumMessages type;

	private String message;

	public MessageJson(EnumMessages type, String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the type
	 */
	public EnumMessages getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(EnumMessages type) {
		this.type = type;
	}

}
