package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.ServiceType;

@Stateless
public class ServiceTypeService extends AbstractService<ServiceType>{

	public ServiceTypeService() {
		super(ServiceType.class);
	}

}
