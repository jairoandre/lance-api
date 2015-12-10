package br.com.vah.lance.api.service.utils;

import java.io.Serializable;

public class Filter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String property;
	
	private Object[]  params;
	
	private FilterType type;
	
	public Filter(String property,FilterType type, Object... params){
		this.property = property;
		this.type = type;
		this.params = params;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}

	/**
	 * @return the type
	 */
	public FilterType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(FilterType type) {
		this.type = type;
	}
	
	public Object getFirstParam() {
		return (this.params == null || this.params.length == 0) ? null : this.params[0]; 
	}
	
	

}
