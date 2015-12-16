package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.Service;

@Stateless
public class ServiceService extends AbstractService<Service> {

	public ServiceService() {
		super(Service.class);
	}

}
