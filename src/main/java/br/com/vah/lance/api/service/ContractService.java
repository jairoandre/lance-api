package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.Contract;

@Stateless
public class ContractService extends AbstractService<Contract>{

    public ContractService() {
		super(Contract.class);
	}
	
}
