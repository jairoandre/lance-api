package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.Supplier;

@Stateless
public class SupplierService extends AbstractService<Supplier>{

    public SupplierService() {
		super(Supplier.class);
	}
	
}
